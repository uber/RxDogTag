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

import com.uber.rxdogtag.ObserverHandler;
import com.uber.rxdogtag.RxDogTag;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

public final class RxDogTagConfigurationTest implements DogTagTest {

  @Rule public RxErrorsRule errorsRule = new RxErrorsRule();

  @After
  public void tearDown() {
    RxDogTag.reset();
  }

  @Test
  public void installAndResetObservers() {
    RxDogTag.install();
    assertThat(RxJavaPlugins.getOnFlowableSubscribe()).isNotNull();
    assertThat(RxJavaPlugins.getOnObservableSubscribe()).isNotNull();
    assertThat(RxJavaPlugins.getOnMaybeSubscribe()).isNotNull();
    assertThat(RxJavaPlugins.getOnSingleSubscribe()).isNotNull();
    assertThat(RxJavaPlugins.getOnCompletableSubscribe()).isNotNull();

    RxDogTag.reset();
    assertThat(RxJavaPlugins.getOnFlowableSubscribe()).isNull();
    assertThat(RxJavaPlugins.getOnObservableSubscribe()).isNull();
    assertThat(RxJavaPlugins.getOnMaybeSubscribe()).isNull();
    assertThat(RxJavaPlugins.getOnSingleSubscribe()).isNull();
    assertThat(RxJavaPlugins.getOnCompletableSubscribe()).isNull();
  }

  @Test
  public void customHandlersGoFirst() {
    // A custom handler that hides the upstream observer to demonstrate that custom handlers get
    // first pick.
    ObserverHandler handler =
        new ObserverHandler() {
          @Override
          public Observer handle(Observable observable, Observer observer) {
            return new LambdaConsumerObserver<Object>() {
              @Override
              public void onSubscribe(Disposable d) {
                observer.onSubscribe(d);
              }

              @Override
              public void onNext(Object o) {
                //noinspection unchecked
                observer.onNext(o);
              }

              @Override
              public void onError(Throwable e) {
                RxJavaPlugins.onError(e);
              }

              @Override
              public void onComplete() {
                observer.onComplete();
              }

              @Override
              public boolean hasCustomOnError() {
                return false;
              }
            };
          }
        };

    RxDogTag.builder().addObserverHandlers(handler).install();
    Exception expected = new RuntimeException("Exception!");
    Observable.error(expected)
        .subscribe(
            new DisposableObserver<Object>() {
              @Override
              public void onNext(Object o) {}

              @Override
              public void onError(Throwable e) {
                throw new RuntimeException("Another exception");
              }

              @Override
              public void onComplete() {}
            });

    Throwable e = errorsRule.take();
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e.getStackTrace()).isEmpty();
    Throwable cause = e.getCause();
    assertThat(cause).isSameAs(expected);
    assertThat(cause.getStackTrace()[1].toString()).contains(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
  }

  @Test
  public void customHandlersAreSkippedPastIfNoHandling() {
    // A custom handler that doesn't report a LambdaConsumerIntrospection
    ObserverHandler handler =
        new ObserverHandler() {
          @Override
          public Observer handle(Observable observable, Observer observer) {
            return observer;
          }
        };

    RxDogTag.builder().addObserverHandlers(handler).install();
    Exception expected = new RuntimeException("Exception!");
    Observable.error(expected).subscribe();

    Throwable e = errorsRule.take();
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e.getStackTrace()).isEmpty();
    Throwable cause = e.getCause();
    assertThat(cause).isSameAs(expected);
    assertThat(cause.getStackTrace()[1].toString()).contains(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
  }

  @Test
  public void customPackages() {
    String thisPackage = getClass().getPackage().getName();

    RxDogTag.builder().addIgnoredPackages(thisPackage).install();
    Exception expected = new RuntimeException("Exception!");
    Observable.error(expected).subscribe();

    Throwable e = errorsRule.take();
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e.getStackTrace()).isEmpty();
    Throwable cause = e.getCause();
    assertThat(cause).isSameAs(expected);
    assertThat(cause.getStackTrace()[1].toString()).contains(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);

    // Confirm that we ignored the subscribe line in this test because of the matching package.
    assertThat(cause.getStackTrace()[1].toString().startsWith(thisPackage)).isFalse();
  }

  @Test
  public void disableAnnotations() {
    RxDogTag.builder().disableAnnotations().install();
    Exception expected = new RuntimeException("Exception!");
    Observable.error(expected).subscribe();

    Throwable e = errorsRule.take();
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e.getStackTrace()).isEmpty();
    Throwable cause = e.getCause();
    assertThat(cause).isSameAs(expected);
    assertThat(cause.getStackTrace()[1].toString())
        .doesNotContain(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
  }

  @Test
  public void repackagingOENIEs_onByDefault() {
    RxDogTag.builder().install();
    Exception expected = new RuntimeException("Exception!");
    OnErrorNotImplementedException parent = new OnErrorNotImplementedException(expected);
    Observable.error(parent).subscribe();

    Throwable e = errorsRule.take();

    // Confirm it's repackaged
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e.getStackTrace()).isEmpty();
    assertThat(e).hasMessageThat().isEqualTo(expected.getMessage());
    Throwable cause = e.getCause();
    assertThat(cause).isSameAs(expected);
    assertThat(cause.getStackTrace()[1].toString()).contains(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
  }

  @Test
  public void repackagingOENIEs_disabled() {
    RxDogTag.builder().disableRepackagingOnErrorNotImplementedExceptions().install();
    Exception expected = new RuntimeException("Exception!");
    OnErrorNotImplementedException parent = new OnErrorNotImplementedException(expected);
    Observable.error(parent).subscribe();

    Throwable e = errorsRule.take();

    // Assert it's the original, untouched exception
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e).isSameAs(parent);
    assertThat(e.getStackTrace()).isEqualTo(parent.getStackTrace());
    assertThat(e).hasMessageThat().isEqualTo(parent.getMessage());
    Throwable cause = e.getCause();
    assertThat(cause).isSameAs(expected);
    assertThat(cause.getStackTrace()[1].toString()).contains(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
  }

  @Test
  public void guardObserverChecks_disabled() {
    RxDogTag.builder().guardObserverCallbacks(false).install();

    Exception original = new RuntimeException("Exception!");
    Observable.error(original).subscribe();

    Throwable e = errorsRule.take();
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e).hasMessageThat().isEqualTo(original.getMessage());
    assertThat(e.getStackTrace()).isEmpty();
    Throwable cause = e.getCause();
    assertThat(cause.getStackTrace()[0].getFileName())
        .isEqualTo(getClass().getSimpleName() + ".java");
    assertThat(cause.getStackTrace()[1].getClassName())
        .isEqualTo(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
    assertThat(cause.getStackTrace()[2].getClassName())
        .isEqualTo(RxDogTag.STACK_ELEMENT_TRACE_HEADER);
  }

  abstract static class LambdaConsumerObserver<T>
      implements Observer<T>, LambdaConsumerIntrospection {}
}
