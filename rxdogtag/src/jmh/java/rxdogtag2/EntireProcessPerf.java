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
package rxdogtag2;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Arrays;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import rxdogtag2.util.PerfConsumer;

/** Measures the time it takes to both subscribe and consume events. */
@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)
public class EntireProcessPerf {

  @Param({"1", "1000", "1000000"})
  public int times;

  @Param({"false", "true"})
  public boolean installRxDogTag;

  Flowable<Integer> flowable = Flowable.empty();
  Observable<Integer> observable = Observable.empty();

  @Setup
  public void setup(Blackhole bh) {
    if (installRxDogTag) {
      RxDogTag.install();
    }

    Integer[] array = new Integer[times];
    Arrays.fill(array, 777);

    flowable = Flowable.fromArray(array);

    observable = Observable.fromArray(array);
  }

  @TearDown
  public void tearDown() {
    RxJavaPlugins.reset();
  }

  @Benchmark
  public Disposable flowable(Blackhole bh) {
    return flowable.subscribe(new PerfConsumer(bh));
  }

  @Benchmark
  public Disposable observable(Blackhole bh) {
    return observable.subscribe(new PerfConsumer(bh));
  }
}
