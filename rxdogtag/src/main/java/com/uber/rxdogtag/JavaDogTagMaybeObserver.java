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

import static com.uber.rxdogtag.JavaRxDogTag.guardedDelegateCall;
import static com.uber.rxdogtag.JavaRxDogTag.reportError;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.observers.LambdaConsumerIntrospection;

/**
 * A delegating {@link MaybeObserver} that throws {@link OnErrorNotImplementedException} with stack
 * element tagging to indicate the exact line number that was subscribed.
 *
 * <p><em>NOTE:</em> This will also capture exceptions thrown by the {@link #delegate "delegate"} 's
 * {@link MaybeObserver#onSubscribe(Disposable) onSubscribe()}, {@link
 * MaybeObserver#onSuccess(Object)} onNext()}, or {@link MaybeObserver#onComplete()} onComplete()}
 * methods and route them through the more specific {@link #onError(Throwable) onError()} in this
 * class for better tagging.
 *
 * @param <T> The type
 */
final class JavaDogTagMaybeObserver<T> implements MaybeObserver<T>, LambdaConsumerIntrospection {

  private final Throwable t = new Throwable();
  private final JavaRxDogTag.Configuration config;
  private final MaybeObserver<T> delegate;

  JavaDogTagMaybeObserver(JavaRxDogTag.Configuration config, MaybeObserver<T> delegate) {
    this.config = config;
    this.delegate = delegate;
  }

  @Override
  public void onSubscribe(Disposable d) {
    guardedDelegateCall(
        e -> reportError(config, t, e, "onSubscribe"), () -> delegate.onSubscribe(d));
  }

  @Override
  public void onSuccess(T t) {
    guardedDelegateCall(
        e -> reportError(config, this.t, e, "onSuccess"), () -> delegate.onSuccess(t));
  }

  @Override
  public void onError(Throwable e) {
    reportError(config, t, e, null);
  }

  @Override
  public void onComplete() {
    guardedDelegateCall(e -> reportError(config, t, e, "onComplete"), delegate::onComplete);
  }

  @Override
  public boolean hasCustomOnError() {
    return delegate instanceof LambdaConsumerIntrospection
        && ((LambdaConsumerIntrospection) delegate).hasCustomOnError();
  }
}
