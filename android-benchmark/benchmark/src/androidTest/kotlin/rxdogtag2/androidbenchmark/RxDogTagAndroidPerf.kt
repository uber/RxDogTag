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

package rxdogtag2.androidbenchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.filters.LargeTest
import rxdogtag2.RxDogTag
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
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
    @Parameters(name = "enabled={0},times={1},guardedDelegateEnabled={2}")
    fun data(): List<Array<*>> {
      val list = mutableListOf<Array<*>>()
      for (enabled in ENABLED) {
        for (times in ITERATIONS) {
          for (guardedDelegateEnabled in GUARDED_DELEGATE_ENABLED) {
            @Suppress("ControlFlowWithEmptyBody") // Readability
            if ((!enabled && guardedDelegateEnabled) || (guardedDelegateEnabled && times == 0)) {
              // Skip these configurations since they're irrelevant
            } else {
              list.add(arrayOf(enabled, times, guardedDelegateEnabled))
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
    Schedulers.shutdown()
    Schedulers.start()
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
    Schedulers.shutdown()
  }

  @Test
  fun flowable_simple() {
    val flowable = flowableInstance(times)
    if (times == 0) {
      benchmarkRule.measureRepeated {
        disposeWithTimingDisabled(flowable.subscribe())
      }
    } else {
      benchmarkRule.measureRepeated {
        latchConsumer { flowable.subscribe(it) }
      }
    }
  }

  @Test
  fun observable_simple() {
    val observable = observableInstance(times)
    if (times == 0) {
      benchmarkRule.measureRepeated {
        disposeWithTimingDisabled(observable.subscribe())
      }
    } else {
      benchmarkRule.measureRepeated {
        latchConsumer { observable.subscribe(it) }
      }
    }
  }

  @Test
  fun flowable_complex() {
    val flowable = flowableInstance(times)
        .filter { true }
        .map { it * 2 }
        .subscribeOn(Schedulers.trampoline())
        .observeOn(AndroidSchedulers.mainThread())
        .takeUntil<Any>(Flowable.never())
        .ignoreElements()
    if (times == 0) {
      benchmarkRule.measureRepeated {
        disposeWithTimingDisabled(flowable.subscribe())
      }
    } else {
      benchmarkRule.measureRepeated {
        latchAction { flowable.subscribe(it) }
      }
    }
  }

  @Test
  fun observable_complex() {
    val observable = observableInstance(times)
        .filter { true }
        .map { it * 2 }
        .subscribeOn(Schedulers.trampoline())
        .observeOn(AndroidSchedulers.mainThread())
        .takeUntil<Any>(Observable.never())
        .ignoreElements()
    if (times == 0) {
      benchmarkRule.measureRepeated {
        disposeWithTimingDisabled(observable.subscribe())
      }
    } else {
      benchmarkRule.measureRepeated {
        latchAction { observable.subscribe(it) }
      }
    }
  }

  @Suppress("NOTHING_TO_INLINE") // Inlined for test overhead reasons
  private inline fun BenchmarkRule.Scope.disposeWithTimingDisabled(disposable: Disposable) {
    runWithTimingDisabled { disposable.dispose() }
  }

  private inline fun BenchmarkRule.Scope.latchAction(onComplete: (Action) -> Unit) {
    val latch = runWithTimingDisabled { CountDownLatch(1) }
    onComplete(Action { latch.countDown() })
    latch.await()
  }

  private inline fun BenchmarkRule.Scope.latchConsumer(onComplete: (Consumer<Any>) -> Unit) {
    val latch = runWithTimingDisabled { CountDownLatch(1) }
    onComplete(Consumer { latch.countDown() })
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
    return when (times) {
      0 -> Observable.never()
      -1 -> Observable.empty()
      else -> Observable.fromArray(*Array(times) { 777 })
    }
  }

}
