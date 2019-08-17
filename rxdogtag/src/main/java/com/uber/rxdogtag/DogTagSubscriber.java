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
package com.uber.rxdogtag;

import static com.uber.rxdogtag.RxDogTag.guardedDelegateCall;
import static com.uber.rxdogtag.RxDogTag.reportError;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.observers.LambdaConsumerIntrospection;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * A delegating {@link Subscriber} that throws {@link OnErrorNotImplementedException} with stack
 * element tagging to indicate the exact line number that was subscribed.
 *
 * <p><em>NOTE:</em> This will also capture exceptions thrown by the {@link #delegate "delegate"} 's
 * {@link Subscriber#onSubscribe(Subscription) onSubscribe()}, {@link Subscriber#onNext(Object)}
 * onNext()}, or {@link Subscriber#onComplete()} onComplete()} methods and route them through the
 * more specific {@link #onError(Throwable) onError()} in this class for better tagging.
 *
 * <p>Due to restrictions in the ReactiveStreams spec, delegate exception capturing will only work
 * on the more lenient {@link FlowableSubscriber}, which allows callback exceptions to be rerouted
 * through {@link #onError(Throwable) onError()}. This is also why this class implements that
 * interface.
 *
 * @param <T> The type
 */
final class DogTagSubscriber<T> implements FlowableSubscriber<T>, LambdaConsumerIntrospection {

  private final Throwable t = new Throwable();
  private final RxDogTag.Configuration config;
  private final Subscriber<T> delegate;

  DogTagSubscriber(RxDogTag.Configuration config, Subscriber<T> delegate) {
    this.config = config;
    this.delegate = delegate;
  }

  @Override
  public void onSubscribe(Subscription s) {
    if (config.guardObserverCallbacks) {
      guardedDelegateCall(
          e -> reportError(config, t, e, "onSubscribe"), () -> delegate.onSubscribe(s));
    } else {
      delegate.onSubscribe(s);
    }
  }

  @Override
  public void onNext(T t) {
    if (config.guardObserverCallbacks) {
      guardedDelegateCall(e -> reportError(config, this.t, e, "onNext"), () -> delegate.onNext(t));
    } else {
      delegate.onNext(t);
    }
  }

  @Override
  public void onError(Throwable e) {
    if (delegate instanceof TryOnError) {
      guardedDelegateCall(e2 -> reportError(config, t, e2, "onError"), () -> delegate.onError(e));
    } else {
      reportError(config, t, e, null);
    }
  }

  @Override
  public void onComplete() {
    if (config.guardObserverCallbacks) {
      guardedDelegateCall(e -> reportError(config, t, e, "onComplete"), delegate::onComplete);
    } else {
      delegate.onComplete();
    }
  }

  @Override
  public boolean hasCustomOnError() {
    return delegate instanceof LambdaConsumerIntrospection
        && ((LambdaConsumerIntrospection) delegate).hasCustomOnError();
  }
}
