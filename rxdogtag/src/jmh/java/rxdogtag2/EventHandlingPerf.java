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

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.observers.TestObserver;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import rxdogtag2.util.PerfObserver;

/**
 * Measures the time that RxDogTag's event handling takes.
 *
 * <p>We only measure `Observer` here because the handling is currently identical across all
 * consumers.
 */
@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)
public class EventHandlingPerf {

  @Param({"false", "true"})
  public boolean useRxDogTag;

  Observer<Object> observer = new TestObserver();

  @Setup
  public void setup(final Blackhole bh) {
    Observer<Object> bhObserver = new PerfObserver(bh);

    if (useRxDogTag) {
      RxDogTag.Configuration configuration = new RxDogTag.Configuration(new RxDogTag.Builder());
      observer = new DogTagObserver(configuration, bhObserver);
    } else {
      observer = bhObserver;
    }
  }

  @Benchmark
  public void onNext(Blackhole bh) {
    observer.onNext(12345);
  }
}
