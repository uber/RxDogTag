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
import io.reactivex.MaybeObserver
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.observers.LambdaConsumerIntrospection

/**
 * A delegating [MaybeObserver] that throws [OnErrorNotImplementedException] with stack
 * element tagging to indicate the exact line number that was subscribed.
 *
 *
 * *NOTE:* This will also capture exceptions thrown by the [&quot;delegate&quot;][.delegate] 's
 * [onSubscribe()][MaybeObserver.onSubscribe], [ ][MaybeObserver.onSuccess] onNext()}, or [MaybeObserver.onComplete] onComplete()}
 * methods and route them through the more specific [onError()][.onError] in this
 * class for better tagging.
 *
 * @param <T> The type
</T> */
internal class DogTagMaybeObserver<T>(private val config: RxDogTag.Configuration, private val delegate: MaybeObserver<T>) : MaybeObserver<T>, LambdaConsumerIntrospection {

  private val t = Throwable()

  override fun onSubscribe(d: Disposable) {
    guardedDelegateCall(object : RxDogTag.NonCheckingConsumer<Throwable> {
      override fun accept(e: Throwable) {
       reportError(config, t, e, "onSubscribe")
      }
    }) { delegate.onSubscribe(d) }
  }

  override fun onSuccess(t: T) {
    guardedDelegateCall(object : RxDogTag.NonCheckingConsumer<Throwable> {
      override fun accept(e: Throwable) {
        reportError(config, this@DogTagMaybeObserver.t, e, "onSuccess")
      }
    }) { delegate.onSuccess(t) }
  }

  override fun onError(e: Throwable) {
    reportError(config, t, e, null)
  }

  override fun onComplete() {
    guardedDelegateCall(object : RxDogTag.NonCheckingConsumer<Throwable> {
      override fun accept(e: Throwable) {
        reportError(config, this@DogTagMaybeObserver.t, e, "onComplete")
      }
    }) { delegate.onComplete() }
  }

  override fun hasCustomOnError(): Boolean {
    return delegate is LambdaConsumerIntrospection && (delegate as LambdaConsumerIntrospection).hasCustomOnError()
  }
}
