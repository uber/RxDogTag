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

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.LambdaConsumerIntrospection;

class EmptyMaybeObserver<T> implements MaybeObserver<T>, LambdaConsumerIntrospection {

  @Override
  public void onSubscribe(Disposable d) {}

  @Override
  public void onSuccess(T t) {}

  @Override
  public final void onError(Throwable e) {}

  @Override
  public void onComplete() {}

  @Override
  public final boolean hasCustomOnError() {
    return false;
  }
}
