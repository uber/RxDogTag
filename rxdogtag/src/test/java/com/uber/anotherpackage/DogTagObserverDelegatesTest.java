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
import static org.junit.Assert.fail;

import com.google.common.collect.Lists;
import com.uber.rxdogtag.RxDogTag;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@RunWith(Parameterized.class)
public class DogTagObserverDelegatesTest implements DogTagTest {

  private static final Action EMPTY_ACTION =
      () -> {
        // Noop
      };

  @Parameterized.Parameters(name = "{0}")
  public static Object[] data() {
    return new Object[] {
      TestParams.create(
          TestParamType.SYNCHRONOUS,
          Flowable.just(1),
          Flowable.never(),
          Flowable.empty(),
          Observable.just(1),
          Observable.never(),
          Observable.empty(),
          Maybe.just(1),
          Maybe.never(),
          Maybe.empty(),
          Single.just(1),
          Single.never(),
          Completable.complete(),
          Completable.never()),
      TestParams.create(
          TestParamType.LAZY,
          Flowable.fromCallable(() -> 1),
          Flowable.never(),
          Flowable.fromIterable(Lists.newArrayList()),
          Observable.fromCallable(() -> 1),
          Observable.never(),
          Observable.fromIterable(Lists.newArrayList()),
          Maybe.fromCallable(() -> 1),
          Maybe.never(),
          Maybe.fromAction(EMPTY_ACTION),
          Single.fromCallable(() -> 1),
          Single.never(),
          Completable.fromAction(EMPTY_ACTION),
          Completable.never()),
      TestParams.create(
          TestParamType.DEFERRED,
          Flowable.defer(() -> Flowable.fromCallable(() -> 1)),
          Flowable.defer(Flowable::never),
          Flowable.defer(() -> Flowable.fromIterable(Lists.newArrayList())),
          Observable.defer(() -> Observable.fromCallable(() -> 1)),
          Observable.defer(Observable::never),
          Observable.defer(() -> Observable.fromIterable(Lists.newArrayList())),
          Maybe.defer(() -> Maybe.fromCallable(() -> 1)),
          Maybe.defer(Maybe::never),
          Maybe.defer(() -> Maybe.fromAction(EMPTY_ACTION)),
          Single.defer(() -> Single.fromCallable(() -> 1)),
          Single.defer(Single::never),
          Completable.defer(() -> Completable.fromAction(EMPTY_ACTION)),
          Completable.defer(Completable::never))
    };
  }

  private final TestParams testParams;

  // We're still expecting the root uncaught exception handler to get hit, but by the time it
  // reaches here it should be the decorated exception.
  private AtomicReference<Throwable> ref;

  // We'll similate an OnErrorNotImplemented exception coming from a delegate, which will happen
  // if a delegate hits its internal missing onError first before the DogTagObserver has a chance.
  private OnErrorNotImplementedException originalError;

  public DogTagObserverDelegatesTest(TestParams testParams) {
    this.testParams = testParams;
  }

  @Before
  public void setUp() {
    RxDogTag.install();
    ref = new AtomicReference<>();
    originalError = new OnErrorNotImplementedException(new RuntimeException("Blah"));
  }

  @After
  public void tearDown() {
    RxJavaPlugins.reset();
  }

  @Test
  public void delegateSubscriber_throwingInOnSubscribe_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    Subscriber<Integer> throwingObserver =
        new EmptySubscriber<Integer>() {
          @Override
          public void onSubscribe(Subscription s) {
            throw originalError;
          }
        };

    testParams.flowableNever.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onSubscribe");
  }

  @Test
  public void delegateSubscriber_throwingInOnNext_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    Subscriber<Integer> throwingOnNext =
        new EmptySubscriber<Integer>() {
          @Override
          public void onNext(Integer integer) {
            throw originalError;
          }
        };

    // For Flowable - a synchronous just() will complete in onSubscribe!
    String delegateType = testParams.type == TestParamType.SYNCHRONOUS ? "onSubscribe" : "onNext";
    testParams.flowable.subscribe(throwingOnNext);
    assertTaggedError(getPreviousLineNumber(), handler, delegateType);
  }

  @Test
  public void delegateSubscriber_throwingInOnComplete_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    Subscriber<Integer> throwingObserver =
        new EmptySubscriber<Integer>() {
          @Override
          public void onComplete() {
            throw originalError;
          }
        };

    testParams.flowableComplete.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onComplete");
  }

  @Test
  public void delegateObserver_throwingInOnSubscribe_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    Observer<Integer> throwingObserver =
        new EmptyObserver<Integer>() {
          @Override
          public void onSubscribe(Disposable d) {
            throw originalError;
          }
        };

    testParams.observableNever.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onSubscribe");
  }

  @Test
  public void delegateObserver_throwingInOnNext_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    Observer<Integer> throwingObserver =
        new EmptyObserver<Integer>() {
          @Override
          public void onNext(Integer integer) {
            throw originalError;
          }
        };

    testParams.observable.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onNext");
  }

  @Test
  public void delegateObserver_throwingInOnComplete_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    Observer<Integer> throwingObserver =
        new EmptyObserver<Integer>() {
          @Override
          public void onComplete() {
            throw originalError;
          }
        };

    testParams.observableComplete.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onComplete");
  }

  @Test
  public void delegateSingleObserver_throwingInOnSubscribe_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    SingleObserver<Integer> throwingObserver =
        new EmptySingleObserver<Integer>() {
          @Override
          public void onSubscribe(Disposable d) {
            throw originalError;
          }
        };

    testParams.singleNever.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onSubscribe");
  }

  @Test
  public void delegateSingleObserver_throwingInOnSuccess_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    SingleObserver<Integer> throwingObserver =
        new EmptySingleObserver<Integer>() {
          @Override
          public void onSuccess(Integer integer) {
            throw originalError;
          }
        };

    testParams.single.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onSuccess");
  }

  @Test
  public void delegateMaybeObserver_throwingInOnSubscribe_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    MaybeObserver<Integer> throwingObserver =
        new EmptyMaybeObserver<Integer>() {
          @Override
          public void onSubscribe(Disposable d) {
            throw originalError;
          }
        };

    testParams.maybeNever.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onSubscribe");
  }

  @Test
  public void delegateMaybeObserver_throwingInOnSuccess_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    MaybeObserver<Integer> throwingObserver =
        new EmptyMaybeObserver<Integer>() {
          @Override
          public void onSuccess(Integer integer) {
            throw originalError;
          }
        };

    testParams.maybe.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onSuccess");
  }

  @Test
  public void delegateMaybeObserver_throwingInOnComplete_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    MaybeObserver<Integer> throwingObserver =
        new EmptyMaybeObserver<Integer>() {
          @Override
          public void onComplete() {
            throw originalError;
          }
        };

    testParams.maybeComplete.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onComplete");
  }

  @Test
  public void delegateCompletableObserver_throwingInOnSubscribe_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    CompletableObserver throwingObserver =
        new EmptyCompletableObserver() {
          @Override
          public void onSubscribe(Disposable d) {
            throw originalError;
          }
        };

    testParams.completableNever.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onSubscribe");
  }

  @Test
  public void delegateCompletableObserver_throwingInOnComplete_shouldBeGuarded() {
    Thread.UncaughtExceptionHandler handler = prepareTest();
    CompletableObserver throwingObserver =
        new EmptyCompletableObserver() {
          @Override
          public void onComplete() {
            throw originalError;
          }
        };

    testParams.completable.subscribe(throwingObserver);
    assertTaggedError(getPreviousLineNumber(), handler, "onComplete");
  }

  @SuppressWarnings("NullAway") // https://github.com/uber/NullAway/issues/301
  private void assertTaggedError(
      int lineNumber, Thread.UncaughtExceptionHandler handler, String delegateType) {
    Throwable recordedThrowable = ref.get();
    assertThat(recordedThrowable).isNotNull();
    assertUnwrappedError(recordedThrowable, lineNumber, originalError, delegateType);

    // Make sure we've restored the original handler
    assertThat(Thread.currentThread().getUncaughtExceptionHandler()).isSameAs(handler);
  }

  private Thread.UncaughtExceptionHandler prepareTest() {
    // Taking back control from the RxErrorsRule for this test
    RxJavaPlugins.setErrorHandler(null);

    Thread.UncaughtExceptionHandler handler =
        (t, e) -> {
          if (ref.compareAndSet(null, e)) {
            return;
          }
          // This should not be hit a second time
          fail("This shouldn't be hit a second time. " + e);
        };
    Thread.currentThread().setUncaughtExceptionHandler(handler);
    return handler;
  }

  enum TestParamType {
    SYNCHRONOUS,
    LAZY,
    DEFERRED
  }

  static class TestParams {

    static TestParams create(
        TestParamType type,
        Flowable<Integer> flowable,
        Flowable<Integer> flowableNever,
        Flowable<Integer> flowableComplete,
        Observable<Integer> observable,
        Observable<Integer> observableNever,
        Observable<Integer> observableComplete,
        Maybe<Integer> maybe,
        Maybe<Integer> maybeNever,
        Maybe<Integer> maybeComplete,
        Single<Integer> single,
        Single<Integer> singleNever,
        Completable completable,
        Completable completableNever) {
      return new TestParams(
          type,
          flowable,
          flowableNever,
          flowableComplete,
          observable,
          observableNever,
          observableComplete,
          maybe,
          maybeNever,
          maybeComplete,
          single,
          singleNever,
          completable,
          completableNever);
    }

    final TestParamType type;
    final Flowable<Integer> flowable;
    final Flowable<Integer> flowableNever;
    final Flowable<Integer> flowableComplete;
    final Observable<Integer> observable;
    final Observable<Integer> observableNever;
    final Observable<Integer> observableComplete;
    final Maybe<Integer> maybe;
    final Maybe<Integer> maybeNever;
    final Maybe<Integer> maybeComplete;
    final Single<Integer> single;
    final Single<Integer> singleNever;
    final Completable completable;
    final Completable completableNever;

    TestParams(
        TestParamType type,
        Flowable<Integer> flowable,
        Flowable<Integer> flowableNever,
        Flowable<Integer> flowableComplete,
        Observable<Integer> observable,
        Observable<Integer> observableNever,
        Observable<Integer> observableComplete,
        Maybe<Integer> maybe,
        Maybe<Integer> maybeNever,
        Maybe<Integer> maybeComplete,
        Single<Integer> single,
        Single<Integer> singleNever,
        Completable completable,
        Completable completableNever) {
      this.type = type;
      this.flowable = flowable;
      this.flowableNever = flowableNever;
      this.flowableComplete = flowableComplete;
      this.observable = observable;
      this.observableNever = observableNever;
      this.observableComplete = observableComplete;
      this.maybe = maybe;
      this.maybeNever = maybeNever;
      this.maybeComplete = maybeComplete;
      this.single = single;
      this.singleNever = singleNever;
      this.completable = completable;
      this.completableNever = completableNever;
    }

    @Override
    public String toString() {
      return type.name();
    }
  }
}
