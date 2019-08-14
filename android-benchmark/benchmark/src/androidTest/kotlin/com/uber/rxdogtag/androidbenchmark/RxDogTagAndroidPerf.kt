/*
 * Copyright (c) 2019 Uber Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uber.rxdogtag.androidbenchmark

import androidx.benchmark.BenchmarkRule
import androidx.benchmark.measureRepeated
import androidx.test.filters.LargeTest
import com.uber.rxdogtag.RxDogTag
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch

/**
 * Measures the time it takes to both subscribe and consume events. Run this like a normal Android
 * instrumentation test on a device. Note that benchmarks should be run on a real device for more
 * realistic real-world results. There are further configurations that can be used for the Androidx
 * Benchmark library used here, full documentation can be found at
 * https://developer.android.com/studio/profile/benchmark.html.
 *
 * Basic command line usage is just to run `./gradlew :android-benchmark:benchmark:connectedCheck`
 */
@LargeTest
class RxDogTagAndroidPerf {

  @get:Rule
  val benchmarkRule = BenchmarkRule()

  @After
  fun tearDown() {
    RxDogTag.reset()
  }

  @Test
  fun flowable1_false() {
    val flowable = flowableInstance(1)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun observable1_false() {
    val observable = observableInstance(1)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun flowable1000_false() {
    val flowable = flowableInstance(1_000)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun observable1000_false() {
    val observable = observableInstance(1_000)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun flowable1000000_false() {
    val flowable = flowableInstance(1_000_000)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun observable1000000_false() {
    val observable = observableInstance(1_000_000)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun flowable1_true() {
    RxDogTag.install()
    val flowable = flowableInstance(1)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun flowable1_true_withoutGuardedDelegate() {
    RxDogTag.builder()
        .guardObserverCallbacks(false)
        .install()
    val flowable = flowableInstance(1)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun observable1_true() {
    RxDogTag.install()
    val observable = observableInstance(1)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun observable1_true_withoutGuardedDelegate() {
    RxDogTag.builder()
        .guardObserverCallbacks(false)
        .install()
    val observable = observableInstance(1)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun flowable1000_true() {
    RxDogTag.install()
    val flowable = flowableInstance(1_000)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun flowable1000_true_withoutGuardedDelegate() {
    RxDogTag.builder()
        .guardObserverCallbacks(false)
        .install()
    val flowable = flowableInstance(1_000)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun observable1000_true() {
    RxDogTag.install()
    val observable = observableInstance(1_000)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun observable1000_true_withoutGuardedDelegate() {
    RxDogTag.builder()
        .guardObserverCallbacks(false)
        .install()
    val observable = observableInstance(1_000)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun flowable1000000_true() {
    RxDogTag.install()
    val flowable = flowableInstance(1_000_000)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun flowable1000000_true_withoutGuardedDelegate() {
    RxDogTag.builder()
        .guardObserverCallbacks(false)
        .install()
    val flowable = flowableInstance(1_000_000)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun observable1000000_true() {
    RxDogTag.install()
    val observable = observableInstance(1_000_000)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun observable1000000_true_withoutGuardedDelegate() {
    RxDogTag.builder()
        .guardObserverCallbacks(false)
        .install()
    val observable = observableInstance(1_000_000)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun flowable_true_subscribe_simple() {
    RxDogTag.install()
    val flowable = flowableInstance(0)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun flowable_true_subscribe_simple_withoutGuardedDelegate() {
    RxDogTag.builder()
        .guardObserverCallbacks(false)
        .install()
    val flowable = flowableInstance(0)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun observable_true_subscribe_simple() {
    RxDogTag.install()
    val observable = observableInstance(0)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun observable_true_subscribe_simple_withoutGuardedDelegate() {
    RxDogTag.builder()
        .guardObserverCallbacks(false)
        .install()
    val observable = observableInstance(0)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun flowable_false_subscribe_simple() {
    val flowable = flowableInstance(0)
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun observable_false_subscribe_simple() {
    val observable = observableInstance(0)
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun flowable_true_subscribe_complex() {
    RxDogTag.install()
    val flowable = flowableInstance(0)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Flowable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun flowable_true_subscribe_complex_withoutGuardedCall() {
    RxDogTag.builder()
        .guardObserverCallbacks(false)
        .install()
    val flowable = flowableInstance(0)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Flowable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun observable_true_subscribe_complex() {
    RxDogTag.install()
    val observable = observableInstance(0)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Observable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun observable_true_subscribe_complex_withoutGuardedDelegate() {
    RxDogTag.builder()
        .guardObserverCallbacks(false)
        .install()
    val observable = observableInstance(0)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Observable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun flowable_false_subscribe_complex() {
    val flowable = flowableInstance(0)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Flowable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      flowable.subscribe()
    }
  }

  @Test
  fun observable_false_subscribe_complex() {
    val observable = observableInstance(0)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Observable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      observable.subscribe()
    }
  }

  @Test
  fun flowable_true_e2e() {
    RxDogTag.install()
    val flowable = flowableInstance(1_000)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Flowable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      val latch = runWithTimingDisabled { CountDownLatch(1) }
      flowable.subscribe { latch.countDown() }
      latch.await()
    }
  }

  @Test
  fun flowable_true_e2e_withoutGuardedDelegate() {
    RxDogTag
        .builder()
        .guardObserverCallbacks(false)
        .install()
    val flowable = flowableInstance(1_000)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Flowable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      val latch = runWithTimingDisabled { CountDownLatch(1) }
      flowable.subscribe { latch.countDown() }
      latch.await()
    }
  }

  @Test
  fun observable_true_e2e() {
    RxDogTag.install()
    val observable = observableInstance(1_000)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Observable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      val latch = runWithTimingDisabled { CountDownLatch(1) }
      observable.subscribe { latch.countDown() }
      latch.await()
    }
  }

  @Test
  fun observable_true_e2e_withoutGuardedDelegate() {
    RxDogTag
        .builder()
        .guardObserverCallbacks(false)
        .install()
    val observable = observableInstance(1_000)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Observable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      val latch = runWithTimingDisabled { CountDownLatch(1) }
      observable.subscribe { latch.countDown() }
      latch.await()
    }
  }

  @Test
  fun flowable_false_e2e() {
    val flowable = flowableInstance(1_000)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Flowable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      val latch = runWithTimingDisabled { CountDownLatch(1) }
      flowable.subscribe { latch.countDown() }
      latch.await()
    }
  }

  @Test
  fun observable_false_e2e() {
    val observable = observableInstance(1_000)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Observable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      val latch = runWithTimingDisabled { CountDownLatch(1) }
      observable.subscribe { latch.countDown() }
      latch.await()
    }
  }

  private fun flowableInstance(times: Int): Flowable<Int> {
    if (times == 0) {
      return Flowable.never()
    }
    return Flowable.fromArray(*Array(times) { 777 })
  }

  private fun observableInstance(times: Int): Observable<Int> {
    if (times == 0) {
      return Observable.never()
    }
    return Observable.fromArray(*Array(times) { 777 })
  }

}
