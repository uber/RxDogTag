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
package com.uber.rxdogtag

import com.uber.rxdogtag.RxDogTag.Companion.guardedDelegateCall
import com.uber.rxdogtag.RxDogTag.Companion.reportError

import io.reactivex.FlowableSubscriber
import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.observers.LambdaConsumerIntrospection
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * A delegating [Subscriber] that throws [OnErrorNotImplementedException] with stack
 * element tagging to indicate the exact line number that was subscribed.
 *
 *
 * *NOTE:* This will also capture exceptions thrown by the [&quot;delegate&quot;][.delegate] 's
 * [onSubscribe()][Subscriber.onSubscribe], [Subscriber.onNext]
 * onNext()}, or [Subscriber.onComplete] onComplete()} methods and route them through the
 * more specific [onError()][.onError] in this class for better tagging.
 *
 *
 * Due to restrictions in the ReactiveStreams spec, delegate exception capturing will only work
 * on the more lenient [FlowableSubscriber], which allows callback exceptions to be rerouted
 * through [onError()][.onError]. This is also why this class implements that
 * interface.
 *
 * @param <T> The type
</T> */
internal class DogTagSubscriber<T>(private val config: RxDogTag.Configuration, private val delegate: Subscriber<T>) : FlowableSubscriber<T>, LambdaConsumerIntrospection {

  private val t = Throwable()

  override fun onSubscribe(s: Subscription) {
    guardedDelegateCall(object : RxDogTag.NonCheckingConsumer<Throwable> {
      override fun accept(e: Throwable) {
        reportError(config, t, e, "onSubscribe")
      }
    }, Runnable { delegate.onSubscribe(s) })
  }

  override fun onNext(t: T) {
    guardedDelegateCall(object : RxDogTag.NonCheckingConsumer<Throwable> {
      override fun accept(e: Throwable) {
        reportError(config, this@DogTagSubscriber.t, e, "onNext")
      }
    }, Runnable { delegate.onNext(t) })
  }

  override fun onError(e: Throwable) {
    reportError(config, t, e, null)
  }

  override fun onComplete() {
    guardedDelegateCall(object : RxDogTag.NonCheckingConsumer<Throwable> {
      override fun accept(e: Throwable) {
        reportError(config, this@DogTagSubscriber.t, e, "onComplete")
      }
    }, Runnable { delegate.onComplete() })
  }

  override fun hasCustomOnError(): Boolean {
    return delegate is LambdaConsumerIntrospection && (delegate as LambdaConsumerIntrospection).hasCustomOnError()
  }
}
