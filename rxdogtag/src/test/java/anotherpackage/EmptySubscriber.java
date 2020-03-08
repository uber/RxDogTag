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

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import org.reactivestreams.Subscription;

/**
 * Note we implement FlowableSubscriber here because it's required for CrashOnErrorObserver to work.
 * See its doc for more details.
 *
 * @param <T> the type
 */
class EmptySubscriber<T> implements FlowableSubscriber<T>, LambdaConsumerIntrospection {

  @Override
  public void onSubscribe(Subscription s) {
    s.request(Long.MAX_VALUE);
  }

  @Override
  public void onNext(T t) {}

  @Override
  public final void onError(Throwable e) {}

  @Override
  public void onComplete() {}

  @Override
  public final boolean hasCustomOnError() {
    return false;
  }
}
