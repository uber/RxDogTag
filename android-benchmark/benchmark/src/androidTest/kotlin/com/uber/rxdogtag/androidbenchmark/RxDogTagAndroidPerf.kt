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

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.filters.LargeTest
import com.uber.rxdogtag.RxDogTag
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
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
@RunWith(Parameterized::class)
class RxDogTagAndroidPerf(
  private val enabled: Boolean,
  private val times: Int,
  private val guardedDelegateEnabled: Boolean
) {

  companion object {
    @JvmStatic
    @Parameters(name = "enabled={0},times={1},guardedDelegateEnabled={1}")
    fun data(): List<Array<*>> {
      val list = mutableListOf<Array<*>>()
      for (enabled in ENABLED) {
        for (iterations in ITERATIONS) {
          for (guardedDelegateEnabled in GUARDED_DELEGATE_ENABLED) {
            if (!enabled && guardedDelegateEnabled) {
              // Skip these configurations since they're irrelevant
            } else {
              list.add(arrayOf(enabled, iterations, guardedDelegateEnabled))
            }
          }
        }
      }
      return list.toList()
    }

    private val ITERATIONS = setOf(0, 1, 1_000, 1_000_000)
    private val ENABLED = setOf(true, false)
    private val GUARDED_DELEGATE_ENABLED = setOf(true, false)
  }

  @get:Rule
  val benchmarkRule = BenchmarkRule()

  @Before
  fun setup() {
    if (enabled) {
      RxDogTag.builder()
          .apply {
            if (!guardedDelegateEnabled) {
              guardObserverCallbacks(false)
            }
          }
          .install()
    }
  }

  @After
  fun tearDown() {
    RxDogTag.reset()
  }

  @Test
  fun flowable_simple() {
    val flowable = flowableInstance(times)
    benchmarkRule.measureRepeated {
      disposeWithTimingDisabled(flowable.subscribe())
    }
  }

  @Test
  fun observable_simple() {
    val observable = observableInstance(times)
    benchmarkRule.measureRepeated {
      disposeWithTimingDisabled(observable.subscribe())
    }
  }

  @Test
  fun flowable_complex() {
    val flowable = flowableInstance(times)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Flowable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      disposeWithTimingDisabled(flowable.subscribe())
    }
  }

  @Test
  fun observable_complex() {
    val observable = observableInstance(times)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Observable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      disposeWithTimingDisabled(observable.subscribe())
    }
  }

  @Test
  fun flowable_e2e() {
    val flowable = flowableInstance(times.takeIf { it != 0 } ?: -1)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Flowable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      latchSubscribe { flowable.subscribe(it) }
    }
  }

  @Test
  fun observable_e2e() {
    val observable = observableInstance(times.takeIf { it != 0 } ?: -1)
        .filter { it == 2 }
        .map { it * 2 }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .ambWith(Observable.never())
        .ignoreElements()
    benchmarkRule.measureRepeated {
      latchSubscribe { observable.subscribe(it) }
    }
  }

  private inline fun BenchmarkRule.Scope.disposeWithTimingDisabled(disposable: Disposable) {
    runWithTimingDisabled { disposable.dispose() }
  }

  private inline fun BenchmarkRule.Scope.latchSubscribe(onComplete: (Action) -> Unit) {
    val latch = runWithTimingDisabled { CountDownLatch(1) }
    onComplete(Action { latch.countDown() })
    latch.await()
  }

  /**
   * @param times -1 for empty, 0 for never, otherwise that number of emissions
   */
  private fun flowableInstance(times: Int): Flowable<Int> {
    if (times == 0) {
      return Flowable.never()
    } else if (times == -1) {
      return Flowable.empty()
    }
    return Flowable.fromArray(*Array(times) { 777 })
  }

  /**
   * @param times -1 for empty, 0 for never, otherwise that number of emissions
   */
  private fun observableInstance(times: Int): Observable<Int> {
    if (times == 0) {
      return Observable.never()
    } else if (times == -1) {
      return Observable.empty()
    }
    return Observable.fromArray(*Array(times) { 777 })
  }

}
