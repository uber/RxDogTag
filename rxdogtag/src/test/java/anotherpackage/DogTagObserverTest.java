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
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import rxdogtag2.RxDogTag;
import rxdogtag2.RxDogTagErrorReceiver;
import rxdogtag2.RxDogTagTaggedExceptionReceiver;

/**
 * NOTE: These tests are a little odd. There are two conditions for them running correctly because
 * they verify via inspecting stacktraces. 1. the throwError() method MUST calculate the line number
 * immediately after subscribe (on the next line). 2. it must not be in the rxdogtag2 package
 * because that is filtered out in stacktrace inspection.
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

  @Test
  public void compositeException() {
    IllegalStateException original = new IllegalStateException("Initial exception");
    RuntimeException runtimeException = new RuntimeException("Resulting exception");

    CompositeException compositeException = new CompositeException(original, runtimeException);
    int expectedLineNumber = subscribeError(Observable.error(compositeException));

    assertRewrittenStacktrace(expectedLineNumber, compositeException);
  }

  @Test
  public void mangledCompositeException() {
    Observable<Integer> mainObservable =
        Observable.concatDelayError(
            withError(
                Observable.just(
                    withError(
                        withError(Observable.just(1), new RuntimeException("1")),
                        new RuntimeException("2"))),
                new RuntimeException("3")));

    int expectedLineNumber = subscribeError(mainObservable);
    Throwable e = errorsRule.take();
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e).hasMessageThat().isEqualTo("2 exceptions occurred. "); // For composite exception
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

  @Test
  public void errorReceiver_noGuards() {
    RxDogTag.reset();
    RxDogTag.builder().guardObserverCallbacks(false).install();
    AtomicReference<Throwable> recordedError = new AtomicReference<>();
    TestErrorReceiver<Integer> o =
        new TestErrorReceiver<Integer>() {
          @Override
          public void onError(Throwable e) {
            recordedError.compareAndSet(null, e);
          }

          @Override
          public void onSubscribe(Disposable d) {}

          @Override
          public void onNext(Integer integer) {}

          @Override
          public void onComplete() {}
        };
    Exception original = new RuntimeException("Blah");
    Observable.<Integer>error(original).subscribe(o);
    Throwable recorded = recordedError.get();
    assertThat(recorded).isSameInstanceAs(original);
  }

  @Test
  public void errorReceiver_withGuard_noException() {
    RxDogTag.reset();
    RxDogTag.builder().guardObserverCallbacks(true).install();
    AtomicReference<Throwable> recordedError = new AtomicReference<>();
    TestErrorReceiver<Integer> o =
        new TestErrorReceiver<Integer>() {
          @Override
          public void onError(Throwable e) {
            recordedError.compareAndSet(null, e);
          }

          @Override
          public void onSubscribe(Disposable d) {}

          @Override
          public void onNext(Integer integer) {}

          @Override
          public void onComplete() {}
        };
    Exception original = new RuntimeException("Blah");
    Observable.<Integer>error(original).subscribe(o);
    Throwable recorded = recordedError.get();
    assertThat(recorded).isSameInstanceAs(original);
  }

  @Test
  public void errorReceiver_withGuard_withException() {
    RxDogTag.reset();
    RxDogTag.builder().guardObserverCallbacks(true).install();
    AtomicReference<Throwable> thrownException = new AtomicReference<>();
    TestErrorReceiver<Integer> o =
        new TestErrorReceiver<Integer>() {
          @Override
          public void onError(Throwable e) {
            RuntimeException toThrow = new RuntimeException(e);
            thrownException.compareAndSet(null, toThrow);
            throw toThrow;
          }

          @Override
          public void onSubscribe(Disposable d) {}

          @Override
          public void onNext(Integer integer) {}

          @Override
          public void onComplete() {}
        };
    Exception original = new RuntimeException("Blah");
    PublishSubject<Integer> subject = PublishSubject.create();
    // Can't do this one synchronously because it will fail in subscribe();
    subject.subscribe(o);
    int lineNumber = getPreviousLineNumber();
    subject.onError(original);
    Throwable recorded = errorsRule.take();
    Throwable thrown = thrownException.get();
    if (thrown == null) {
      // Partially more descriptive error message, partially to make NullAway happy since it doesn't
      // speak truth's isNotNull() assertions
      fail("thrown was null! This means the observer's onError was never called");
      return;
    }
    assertThat(thrown).hasCauseThat().isSameInstanceAs(original);
    assertThat(recorded).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(recorded).hasCauseThat().isSameInstanceAs(thrown);
    // The original cause was put in this
    assertThat(recorded).hasMessageThat().contains("java.lang.RuntimeException: Blah");

    // Slightly duplicated, but this is a special delegates case for onError
    Throwable cause = recorded.getCause();
    assertThat(cause).isNotNull();
    assertThat(cause.getStackTrace()[0].getFileName())
        .isEqualTo(getClass().getSimpleName() + ".java");
    assertThat(cause.getStackTrace()[0].getLineNumber()).isEqualTo(lineNumber);
    assertThat(cause.getStackTrace()[1].getClassName())
        .isEqualTo(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
    assertThat(cause.getStackTrace()[2].getClassName())
        .isEqualTo(String.format(Locale.US, RxDogTag.STACK_ELEMENT_SOURCE_DELEGATE, "onError"));
    assertThat(cause.getStackTrace()[3].getClassName())
        .isEqualTo(RxDogTag.STACK_ELEMENT_TRACE_HEADER);
  }

  @Test
  public void taggedErrorReceiver() {
    AtomicReference<Throwable> recordedError = new AtomicReference<>();
    TestTaggedErrorReceiver<Integer> o =
        new TestTaggedErrorReceiver<Integer>() {
          @Override
          public void onError(Throwable e) {
            recordedError.compareAndSet(null, e);
          }

          @Override
          public void onSubscribe(Disposable d) {}

          @Override
          public void onNext(Integer integer) {}

          @Override
          public void onComplete() {}
        };
    Exception original = new RuntimeException("Blah");
    Observable.<Integer>error(original).subscribe(o);
    int lineNumber = getPreviousLineNumber();
    Throwable recorded = recordedError.get();
    if (recorded == null) {
      fail("No exception recorded!");
    } else {
      assertRewrittenStacktrace(lineNumber, original, recorded);
    }
  }

  private interface TestTaggedErrorReceiver<T>
      extends RxDogTagTaggedExceptionReceiver, Observer<T> {}

  private interface TestErrorReceiver<T> extends RxDogTagErrorReceiver, Observer<T> {}

  /** This tests that the original stacktrace was rewritten with the relevant source information. */
  private void assertRewrittenStacktrace(int expectedLineNumber, Throwable original) {
    Throwable e = errorsRule.take();
    assertRewrittenStacktrace(expectedLineNumber, original, e);
  }
  /** This tests that the original stacktrace was rewritten with the relevant source information. */
  private void assertRewrittenStacktrace(
      int expectedLineNumber, Throwable original, Throwable recorded) {
    assertThat(recorded).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(recorded).hasMessageThat().isEqualTo(original.getMessage());
    assertThat(recorded.getStackTrace()).isEmpty();
    Throwable cause = recorded.getCause();
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

  private static <T> Observable<T> withError(Observable<T> source, Exception exception) {
    return source.concatWith(Observable.error(exception));
  }

  private static class Another extends EmptyObserver<Object> {

    @Override
    public void onNext(Object unit) {}
  }
}
