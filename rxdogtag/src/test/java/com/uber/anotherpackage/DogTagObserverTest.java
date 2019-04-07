/*
 * Copyright (C) 2019. Uber Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.uber.anotherpackage;

import static com.google.common.truth.Truth.assertThat;
import static com.uber.anotherpackage.DogTagTestUtil.getPreviousLineNumber;
import static com.uber.autodispose.AutoDispose.autoDisposable;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.CompletableSubscribeProxy;
import com.uber.autodispose.FlowableSubscribeProxy;
import com.uber.autodispose.MaybeSubscribeProxy;
import com.uber.autodispose.ObservableSubscribeProxy;
import com.uber.autodispose.ScopeProvider;
import com.uber.autodispose.SingleSubscribeProxy;
import com.uber.rxdogtag.RxDogTag;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.plugins.RxJavaPlugins;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * NOTE: These tests are a little odd. There are two conditions for them running correctly because
 * they verify via inspecting stacktraces. 1. the throwError() method MUST calculate the line number
 * immediately after subscribe (on the next line). 2. it must not be in the com.ubercab.rx2.java
 * package because that is filtered out in stacktrace inspection.
 */
public class DogTagObserverTest implements DogTagTest {

  @Rule public RxErrorsRule errorsRule = new RxErrorsRule();

  @Before
  public void setUp() {
    RxDogTag.install();
  }

  @After
  public void tearDown() {
    RxJavaPlugins.reset();
  }

  @Test
  public void testObservable_autodispose() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(
        subscribeError(Observable.error(original).as(autoDisposable(ScopeProvider.UNBOUND))),
        original);
  }

  @Test
  public void testFlowable_autodispose() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(
        subscribeError(Flowable.error(original).as(autoDisposable(ScopeProvider.UNBOUND))),
        original);
  }

  @Test
  public void testSingle_autodispose() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(
        subscribeError(Single.error(original).as(autoDisposable(ScopeProvider.UNBOUND))), original);
  }

  @Test
  public void testMaybe_autodispose() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(
        subscribeError(Maybe.error(original).as(autoDisposable(ScopeProvider.UNBOUND))), original);
  }

  @Test
  public void testCompletable_autodispose() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(
        subscribeError(Completable.error(original).as(autoDisposable(ScopeProvider.UNBOUND))),
        original);
  }

  @Test
  public void testObservable() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(subscribeError(Observable.error(original)), original);
  }

  @Test
  public void testFlowable() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(subscribeError(Flowable.error(original)), original);
  }

  @Test
  public void testSingle() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(subscribeError(Single.error(original)), original);
  }

  @Test
  public void testMaybe() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(subscribeError(Maybe.error(original)), original);
  }

  @Test
  public void testCompletable() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(subscribeError(Completable.error(original)), original);
  }

  @Test
  public void noConstructor_generatesStringFromStackElement_anonymous() {
    Exception originalError = new IllegalStateException("illegal state exception");
    assertRewrittenStacktrace(
        throwError(new EmptyObserver<Integer>() {}, originalError), originalError);
  }

  @Test
  public void noConstructor_generatesStringFromStackElement_instance() {
    Exception originalError = new IllegalStateException("illegal state exception");
    Observer<Integer> o = new EmptyObserver<Integer>() {};
    assertRewrittenStacktrace(throwError(o, originalError), originalError);
  }

  @Test
  public void noConstructor_generatesStringFromStackElement_subclass() {
    Exception originalError = new IllegalStateException("illegal state exception");
    Another o = new Another();
    assertRewrittenStacktrace(throwError(o, originalError), originalError);
  }

  /** This tests that the original stacktrace was rewritten with the relevant source information. */
  private void assertRewrittenStacktrace(int expectedLineNumber, Exception original) {
    Throwable e = errorsRule.take();
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e).hasMessageThat().isEqualTo(original.getMessage());
    assertThat(e.getStackTrace()[0].getClassName()).isEqualTo(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
    assertThat(e.getStackTrace()[1].getFileName()).isEqualTo(getClass().getSimpleName() + ".java");
    assertThat(e.getStackTrace()[1].getLineNumber()).isEqualTo(expectedLineNumber);
    assertThat(e.getStackTrace()[2].getClassName()).isEqualTo(RxDogTag.STACK_ELEMENT_CAUSE_HEADER);
  }

  /**
   * This is a weird but necessary tests. We have proguard configurations that depend on these
   * packages to have names kept in order for DogTagObservers to work their magic correctly.
   *
   * <p>In the event that this test fails, please update the proguard configurations with the new
   * package names. You will see something like this in our global proguard config.
   *
   * <pre><code>
   *   -keepnames class io.reactivex.**
   * </code></pre>
   *
   * <p>This should be updated with the new package name.
   */
  @Test
  public void verifyPackages() {
    checkPackage("Observable", "io.reactivex", Observable.class.getPackage().getName());
    checkPackage("AutoDispose", "com.uber.autodispose", AutoDispose.class.getPackage().getName());
    checkPackage(
        "RxDogTag",
        "com.uber.rxdogtag",
        RxDogTag.class.getPackage().getName().replace(".RxDogTag", ""));
  }

  private void checkPackage(String name, String expectedPackage, String actualPackage) {
    if (!actualPackage.equals(expectedPackage)) {
      throw new RuntimeException(
          "The package name for "
              + name
              + " has changed. Please "
              + "update this test and the proguard -keepnames configuration to properly keep the new "
              + "package It was \n\"-keepnames class "
              + expectedPackage
              + ".**\"\nbut should now "
              + "be\n\"-keepnames class "
              + actualPackage
              + ".**\"");
    }
  }

  private static int subscribeError(CompletableSubscribeProxy completable) {
    completable.subscribe();
    return getPreviousLineNumber();
  }

  private static <T> int subscribeError(ObservableSubscribeProxy<T> observable) {
    observable.subscribe();
    return getPreviousLineNumber();
  }

  private static <T> int subscribeError(MaybeSubscribeProxy<T> maybe) {
    maybe.subscribe();
    return getPreviousLineNumber();
  }

  private static <T> int subscribeError(SingleSubscribeProxy<T> single) {
    single.subscribe();
    return getPreviousLineNumber();
  }

  private static <T> int subscribeError(FlowableSubscribeProxy<T> flowable) {
    flowable.subscribe();
    return getPreviousLineNumber();
  }

  private static int subscribeError(Completable completable) {
    completable.subscribe();
    return getPreviousLineNumber();
  }

  private static <T> int subscribeError(Observable<T> observable) {
    observable.subscribe();
    return getPreviousLineNumber();
  }

  private static <T> int subscribeError(Maybe<T> maybe) {
    maybe.subscribe();
    return getPreviousLineNumber();
  }

  private static <T> int subscribeError(Single<T> single) {
    single.subscribe();
    return getPreviousLineNumber();
  }

  private static <T> int subscribeError(Flowable<T> flowable) {
    flowable.subscribe();
    return getPreviousLineNumber();
  }

  private static <T> int throwError(Observer<T> observer, Exception error) {
    Observable.<T>defer(() -> Observable.error(error)).subscribe(observer);
    return getPreviousLineNumber();
  }

  private static class Another extends EmptyObserver<Object> {

    @Override
    public void onNext(Object unit) {}
  }
}
