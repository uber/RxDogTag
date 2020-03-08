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
package anotherpackage;

import static anotherpackage.DogTagTestUtil.getPreviousLineNumber;
import static autodispose2.AutoDispose.autoDisposable;
import static com.google.common.truth.Truth.assertThat;

import autodispose2.AutoDispose;
import autodispose2.CompletableSubscribeProxy;
import autodispose2.FlowableSubscribeProxy;
import autodispose2.MaybeSubscribeProxy;
import autodispose2.ObservableSubscribeProxy;
import autodispose2.ScopeProvider;
import autodispose2.SingleSubscribeProxy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import rxdogtag2.RxDogTag;
import rxdogtag2.autodispose2.AutoDisposeConfigurer;

/**
 * NOTE: These tests are a little odd. There are two conditions for them running correctly because
 * they verify via inspecting stacktraces. 1. the throwError() method MUST calculate the line number
 * immediately after subscribe (on the next line). 2. it must not be in the rxdogtag2 package
 * because that is filtered out in stacktrace inspection.
 */
public final class AutoDisposeObserverHandlerTest implements DogTagTest {

  @Rule public RxErrorsRule errorsRule = new RxErrorsRule();

  @Before
  public void setUp() {
    RxDogTag.builder().configureWith(AutoDisposeConfigurer::configure).install();
  }

  @After
  public void tearDown() {
    RxDogTag.reset();
  }

  @Test
  public void testObservable_autodispose() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(
        subscribeError(Observable.error(original).to(autoDisposable(ScopeProvider.UNBOUND))),
        original);
  }

  @Test
  public void testFlowable_autodispose() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(
        subscribeError(Flowable.error(original).to(autoDisposable(ScopeProvider.UNBOUND))),
        original);
  }

  @Test
  public void testSingle_autodispose() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(
        subscribeError(Single.error(original).to(autoDisposable(ScopeProvider.UNBOUND))), original);
  }

  @Test
  public void testMaybe_autodispose() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(
        subscribeError(Maybe.error(original).to(autoDisposable(ScopeProvider.UNBOUND))), original);
  }

  @Test
  public void testCompletable_autodispose() {
    Exception original = new RuntimeException("Blah");
    assertRewrittenStacktrace(
        subscribeError(Completable.error(original).to(autoDisposable(ScopeProvider.UNBOUND))),
        original);
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

  /**
   * This is a weird but necessary tests. We have proguard configurations that depend on these
   * packages to have names kept in order for DogTagObservers to work their magic correctly.
   *
   * <p>In the event that this test fails, please update the proguard configurations with the new
   * package names. You will see something like this in the bundled proguard config.
   *
   * <pre><code>
   *   -keepnames class com.uber.autodispose.**
   * </code></pre>
   *
   * <p>This should be updated with the new package name.
   */
  @Test
  public void verifyPackages() {
    checkPackage("AutoDispose", "autodispose2", AutoDispose.class.getPackage().getName());
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
}
