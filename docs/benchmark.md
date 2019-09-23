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
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,guardedDelegateEnabled=false]          |         577ns |   0.001ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=false]           |      13,903ns |   0.014ms | 2309.53% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=true]            |      14,303ns |   0.014ms | 2378.86% |

#### Complex: 1 item (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,guardedDelegateEnabled=false]         |      79,250ns |   0.079ms |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=true]           |     116,120ns |   0.116ms | 46.52% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=false]          |   1,799,375ns |   1.799ms | 2170.50% |

#### Simple: 1_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]      |      23,987ns |  0.024ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]       |      40,871ns |  0.041ms | 70.39% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]        |     149,349ns |  0.149ms | 522.62% |

#### Complex: 1_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]      |     387,552ns |  0.388ms |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]       |     756,146ns |  0.756ms | 95.11% |
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]     |   1,429,844ns |  1.430ms | 268.94% |

#### Simple: 1_000_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]  |  23,983,701ns | 23.984ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]   |  26,762,085ns | 26.762ms |   11.58% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]    | 161,242,933ns | 161.243ms |  572.30% |

#### Complex: 1_000_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false] | 234,562,471ns | 234.562ms |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]   | 239,577,889ns | 239.578ms |    2.14% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]  | 243,418,670ns | 243.419ms |    3.78% |

#### Simple: 1 item (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,guardedDelegateEnabled=false]            |         546ns |   0.001ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=false]             |      13,923ns |   0.014ms | 2450.00% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=true]              |      14,609ns |   0.015ms | 2575.64% |

#### Complex: 1 item (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=false]            |     130,781ns |   0.131ms |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=true]             |     131,163ns |   0.131ms |  0.29% |
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,guardedDelegateEnabled=false]           |   1,456,641ns |   1.457ms | 1013.80% |

#### Simple: 1_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]        |      24,299ns |  0.024ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]         |      40,203ns |  0.040ms | 65.45% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]          |     152,370ns |  0.152ms | 527.06% |

#### Complex: 1_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]       |     470,885ns | 0.471ms |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]         |     592,499ns | 0.592ms | 25.83% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]        |     718,021ns | 0.718ms | 52.48% |

#### Simple: 1_000_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]    |  23,566,147ns | 23.566ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]     |  26,045,210ns | 26.045ms |   10.52% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]      | 158,885,276ns | 158.885ms |  574.21% |

#### Complex: 1_000_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]    | 593,260,735ns | 593.261ms |
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]   | 629,395,375ns | 629.395ms |    6.09% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]     | 755,996,898ns | 755.997ms |   27.43% |


### Subscribe cost: grouped by complexity

This measures the cost to subscription incurred by RxDogTag.

#### Simple (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=0,guardedDelegateEnabled=false]          |         329ns |   0.000ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=0,guardedDelegateEnabled=false]           |      14,293ns |   0.014ms | 4244.38% |

#### Simple (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=0,guardedDelegateEnabled=false]            |         350ns |   0.000ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=0,guardedDelegateEnabled=false]             |      14,616ns |   0.015ms | 4076.00% |

#### Complex (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=0,guardedDelegateEnabled=false]         |       9,485ns |  0.009ms |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=0,guardedDelegateEnabled=false]          |      27,028ns |  0.027ms | 184.96% |

#### Complex (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=0,guardedDelegateEnabled=false]           |      15,904ns |  0.016ms |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=0,guardedDelegateEnabled=false]            |      50,602ns |  0.051ms | 218.17% |
