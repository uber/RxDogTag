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

import com.uber.rxdogtag.RxDogTag;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.observers.TestObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * NOTE: These tests are a little odd. There are two conditions for them running correctly because
 * they verify via inspecting stacktraces. 1. the throwError() method MUST calculate the line number
 * immediately after subscribe (on the next line). 2. it must not be in the com.uber.rxdogtag
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
    RxDogTag.reset();
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

  @Test
  public void observerWithErrorHandling_ignoredByRxDogTag() {
    Exception originalError = new IllegalStateException("illegal state exception");
    // Test observer which custom error handling.
    TestObserver<Object> testObserver = Observable.error(originalError).test();
    // No errors intercepted by RxDogTag.
    errorsRule.assertNoErrors();

    testObserver.assertError(
        (error) -> {
          assertThat(error).isNotInstanceOf(OnErrorNotImplementedException.class);
          assertThat(error).hasMessageThat().isEqualTo(originalError.getMessage());
          assertThat(error.getStackTrace()).isNotEmpty();
          return true;
        });
  }

  @Test
  public void nullOriginErrorMessage_replacedWithEmptyString() {
    Exception originalError = new IllegalStateException();
    int expectedLineNumber = subscribeError(Observable.error(originalError));

    Throwable e = errorsRule.take();
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    // Original error message was null. Now replaced by empty string
    assertThat(e).hasMessageThat().isNotEqualTo(originalError.getMessage());
    assertThat(e).hasMessageThat().isEqualTo("");

    assertThat(e.getStackTrace()).isEmpty();
    Throwable cause = e.getCause();
    assertThat(cause.getStackTrace()[0].getFileName())
        .isEqualTo(getClass().getSimpleName() + ".java");
    assertThat(cause.getStackTrace()[0].getLineNumber()).isEqualTo(expectedLineNumber);
    assertThat(cause.getStackTrace()[1].getClassName())
        .isEqualTo(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
    assertThat(cause.getStackTrace()[2].getClassName())
        .isEqualTo(RxDogTag.STACK_ELEMENT_TRACE_HEADER);
  }

  /** This tests that the original stacktrace was rewritten with the relevant source information. */
  private void assertRewrittenStacktrace(int expectedLineNumber, Exception original) {
    Throwable e = errorsRule.take();
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e).hasMessageThat().isEqualTo(original.getMessage());
    assertThat(e.getStackTrace()).isEmpty();
    Throwable cause = e.getCause();
    assertThat(cause.getStackTrace()[0].getFileName())
        .isEqualTo(getClass().getSimpleName() + ".java");
    assertThat(cause.getStackTrace()[0].getLineNumber()).isEqualTo(expectedLineNumber);
    assertThat(cause.getStackTrace()[1].getClassName())
        .isEqualTo(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
    assertThat(cause.getStackTrace()[2].getClassName())
        .isEqualTo(RxDogTag.STACK_ELEMENT_TRACE_HEADER);
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
