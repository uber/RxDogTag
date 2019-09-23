# Benchmarks

## Running the benchmark

You can run the benchmark by executing `./gradlew :android-benchmark:benchmark:connectedCheck`. Note that the benchmark should be run on an actual device

You can then take the output from the benchmark and run it through `DataParser.kt` to get a structured breakdown as seen below.

It's important to look at the units than at the percentages. In general, RxDogTag does add some overhead to your RxJava subscriptions but that overhead is irrelevant in the larger execution context of the code around it (less than a millisecond in most cases).

## Results

Running the benchmark on a [Pixel 3](https://store.google.com/product/pixel_3_specs) yields the following results:

### Event throughput: grouped by number of events

Measures the amount of time it takes for given number of elements to pass through the stream.

#### Simple: 1 item (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,guardedDelegateEnabled=false]          |         532ns |   0.001ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=false]           |       7,060ns |   0.007ms | 1227.07% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=true]            |       7,378ns |   0.007ms | 1286.84% |

#### Complex: 1 item (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=false]          |      49,195ns | 0.049ms |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=true]           |      50,492ns | 0.050ms |  2.64% |
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,guardedDelegateEnabled=false]         |      53,672ns | 0.054ms |  9.10% |

#### Simple: 1_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]      |      23,968ns |  0.024ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]       |      40,743ns |  0.041ms | 69.99% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]        |     152,943ns |  0.153ms | 538.11% |

#### Complex: 1_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]     |     291,301ns | 0.291ms |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]      |     312,864ns | 0.313ms |  7.40% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]       |     313,334ns | 0.313ms |  7.56% |

#### Simple: 1_000_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]  |  23,993,700ns | 23.994ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]   |  27,304,847ns | 27.305ms |   13.80% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]    | 166,887,047ns | 166.887ms |  595.55% |

#### Complex: 1_000_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]  | 249,739,764ns | 249.740ms |
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false] | 252,727,577ns | 252.728ms |    1.20% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]   | 257,553,671ns | 257.554ms |    3.13% |

#### Simple: 1 item (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,guardedDelegateEnabled=false]            |         519ns |   0.001ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=false]             |       7,234ns |   0.007ms | 1293.83% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=true]              |       7,581ns |   0.008ms | 1360.69% |

#### Complex: 1 item (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=false]            |      50,081ns | 0.050ms |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=true]             |      50,787ns | 0.051ms |  1.41% |
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,guardedDelegateEnabled=false]           |      56,004ns | 0.056ms | 11.83% |

#### Simple: 1_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]        |      24,920ns |  0.025ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]         |      40,568ns |  0.041ms | 62.79% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]          |     153,124ns |  0.153ms | 514.46% |

#### Complex: 1_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]       |     273,178ns | 0.273ms |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]         |     342,812ns | 0.343ms | 25.49% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]        |     375,208ns | 0.375ms | 37.35% |

#### Simple: 1_000_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]    |  23,952,919ns | 23.953ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]     |  26,791,825ns | 26.792ms |   11.85% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]      | 162,547,359ns | 162.547ms |  578.61% |

#### Complex: 1_000_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]     | 300,186,228ns | 300.186ms |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]    | 302,880,498ns | 302.881ms |    0.90% |
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]   | 304,952,062ns | 304.952ms |    1.59% |


### Subscribe cost: grouped by complexity

This measures the cost to subscription incurred by RxDogTag.

#### Simple (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=0,guardedDelegateEnabled=false]          |         331ns |   0.000ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=0,guardedDelegateEnabled=false]           |       7,275ns |   0.007ms | 2097.89% |

#### Simple (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=0,guardedDelegateEnabled=false]            |         365ns |   0.000ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=0,guardedDelegateEnabled=false]             |       7,506ns |   0.008ms | 1956.44% |

#### Complex (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=0,guardedDelegateEnabled=false]         |       1,673ns |  0.002ms |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=0,guardedDelegateEnabled=false]          |       9,770ns |  0.010ms | 483.98% |

#### Complex (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=0,guardedDelegateEnabled=false]           |       5,741ns |  0.006ms |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=0,guardedDelegateEnabled=false]            |      20,783ns |  0.021ms | 262.01% |
