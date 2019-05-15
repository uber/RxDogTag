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

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import org.openjdk.jmh.annotations.*;

/** Measures the time it takes to simply subscribe (but not consume any events). */
@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)
public class SubscriptionPerf {

  @Param({"false", "true"})
  public boolean installRxDogTag;

  // Setup before test to narrow in on what we want to benchmark
  Observable<String> emptyObservable = Observable.empty();
  Consumer<String> emptyStringConsumer = Functions.emptyConsumer();
  Consumer<Throwable> emptyThrowableConsumer = Functions.emptyConsumer();

  @Setup
  public void setup() {
    if (installRxDogTag) {
      RxDogTag.install();
    }
  }

  @TearDown
  public void tearDown() {
    RxJavaPlugins.reset();
  }

  @Benchmark
  public Disposable subscribeWithoutOnError() {
    return emptyObservable.subscribe(emptyStringConsumer);
  }

  @Benchmark
  public Disposable subscribeWithOnError() {
    return emptyObservable.subscribe(emptyStringConsumer, emptyThrowableConsumer);
  }
}
