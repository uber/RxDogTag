# Benchmarks

## Running the benchmark

You can run the benchmark by executing `./gradlew :android-benchmark:benchmark:connectedCheck`. Note that the benchmark should be run on an actual device

You can then take the output from the benchmark and run it through `DataParser.kt` to get a structured breakdown as seen below.

It's important to look at the units than at the percentages. In general, RxDogTag does add some overhead to your RxJava subscriptions but that overhead is irrelevant in the larger execution context of the code around it (less than a millisecond in most cases).

## Results

Running the benchmark on a [Pixel 3](https://store.google.com/product/pixel_3_specs) yields the following results:

### Event throughput: grouped by number of events

Measures the amount of time it takes for given number of elements to pass through the stream.

#### 1 item (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,guardedDelegateEnabled=false]          |         577ns |       0.001ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=false]           |      13,903ns |       0.014ms | 2309.53% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=true]            |      14,303ns |       0.014ms | 2378.86% |
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]      |      23,987ns |       0.024ms | 4057.19% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]       |      40,871ns |       0.041ms | 6983.36% |
| RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,guardedDelegateEnabled=false]             |      78,558ns |       0.079ms | 13514.90% |
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,guardedDelegateEnabled=false]         |      79,250ns |       0.079ms | 13634.84% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=true]           |     116,120ns |       0.116ms | 20024.78% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,guardedDelegateEnabled=false]              |     119,878ns |       0.120ms | 20676.08% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,guardedDelegateEnabled=true]               |     126,007ns |       0.126ms | 21738.30% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]        |     149,349ns |       0.149ms | 25783.71% |
| RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=false]         |     320,312ns |       0.320ms | 55413.34% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=true]           |     348,645ns |       0.349ms | 60323.74% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=false]          |     349,218ns |       0.349ms | 60423.05% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]      |     387,552ns |       0.388ms | 67066.72% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]       |     756,146ns |       0.756ms | 130947.83% |
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]     |   1,429,844ns |       1.430ms | 247706.59% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=false]          |   1,799,375ns |       1.799ms | 311750.09% |
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]  |  23,983,701ns |      23.984ms | 4156520.62% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]   |  26,762,085ns |      26.762ms | 4638042.98% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]    | 161,242,933ns |     161.243ms | 27944949.05% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]       | 229,929,867ns |     229.930ms | 39849097.05% |
| RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]     | 233,551,065ns |     233.551ms | 40476687.69% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]      | 234,093,097ns |     234.093ms | 40570627.38% |
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false] | 234,562,471ns |     234.562ms | 40651974.70% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]   | 239,577,889ns |     239.578ms | 41521197.92% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]  | 243,418,670ns |     243.419ms | 42186844.54% |

#### 1 item (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,guardedDelegateEnabled=false]            |         546ns |        0.001ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=false]             |      13,923ns |        0.014ms | 2450.00% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=true]              |      14,609ns |        0.015ms | 2575.64% |
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]        |      24,299ns |        0.024ms | 4350.37% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]         |      40,203ns |        0.040ms | 7263.19% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,guardedDelegateEnabled=false]                |     123,924ns |        0.124ms | 22596.70% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,guardedDelegateEnabled=true]                 |     129,253ns |        0.129ms | 23572.71% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=false]            |     130,781ns |        0.131ms | 23852.56% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=true]             |     131,163ns |        0.131ms | 23922.53% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]          |     152,370ns |        0.152ms | 27806.59% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=true]             |     383,229ns |        0.383ms | 70088.46% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=false]            |     390,417ns |        0.390ms | 71404.95% |
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]       |     470,885ns |        0.471ms | 86142.67% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]         |     592,499ns |        0.592ms | 108416.30% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]        |     718,021ns |        0.718ms | 131405.68% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,guardedDelegateEnabled=false]               |     870,794ns |        0.871ms | 159386.08% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=false]           |   1,060,676ns |        1.061ms | 194163.00% |
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,guardedDelegateEnabled=false]           |   1,456,641ns |        1.457ms | 266684.07% |
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]    |  23,566,147ns |       23.566ms | 4316044.14% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]     |  26,045,210ns |       26.045ms | 4770084.98% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]      | 158,885,276ns |      158.885ms | 29099767.40% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]         | 560,666,826ns |      560.667ms | 102686131.87% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]    | 593,260,735ns |      593.261ms | 108655712.27% |
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]   | 629,395,375ns |      629.395ms | 115273778.21% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]       | 630,688,866ns |      630.689ms | 115510681.32% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]        | 654,682,512ns |      654.682ms | 119905121.98% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]     | 755,996,898ns |      755.997ms | 138460870.33% |

#### 1_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]      |      23,987ns |      0.024ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]       |      40,871ns |      0.041ms |   70.39% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]        |     149,349ns |      0.149ms |  522.62% |
| RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=false]         |     320,312ns |      0.320ms | 1235.36% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=true]           |     348,645ns |      0.349ms | 1353.47% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=false]          |     349,218ns |      0.349ms | 1355.86% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]      |     387,552ns |      0.388ms | 1515.68% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]       |     756,146ns |      0.756ms | 3052.32% |
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]     |   1,429,844ns |      1.430ms | 5860.91% |
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]  |  23,983,701ns |     23.984ms | 99886.25% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]   |  26,762,085ns |     26.762ms | 111469.12% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]    | 161,242,933ns |    161.243ms | 672109.67% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]       | 229,929,867ns |    229.930ms | 958460.33% |
| RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]     | 233,551,065ns |    233.551ms | 973556.83% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]      | 234,093,097ns |    234.093ms | 975816.53% |
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false] | 234,562,471ns |    234.562ms | 977773.31% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]   | 239,577,889ns |    239.578ms | 998682.21% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]  | 243,418,670ns |    243.419ms | 1014694.14% |

#### 1_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]        |      24,299ns |      0.024ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]         |      40,203ns |      0.040ms |   65.45% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]          |     152,370ns |      0.152ms |  527.06% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=true]             |     383,229ns |      0.383ms | 1477.14% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=false]            |     390,417ns |      0.390ms | 1506.72% |
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]       |     470,885ns |      0.471ms | 1837.88% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]         |     592,499ns |      0.592ms | 2338.37% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]        |     718,021ns |      0.718ms | 2854.94% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=false]           |   1,060,676ns |      1.061ms | 4265.10% |
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]    |  23,566,147ns |     23.566ms | 96884.02% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]     |  26,045,210ns |     26.045ms | 107086.35% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]      | 158,885,276ns |    158.885ms | 653775.78% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]         | 560,666,826ns |    560.667ms | 2307265.84% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]    | 593,260,735ns |    593.261ms | 2441402.68% |
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]   | 629,395,375ns |    629.395ms | 2590111.02% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]       | 630,688,866ns |    630.689ms | 2595434.24% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]        | 654,682,512ns |    654.682ms | 2694177.59% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]     | 755,996,898ns |    755.997ms | 3111126.38% |

#### 1_000_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]  |  23,983,701ns | 23.984ms |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]   |  26,762,085ns | 26.762ms |   11.58% |
| RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]    | 161,242,933ns | 161.243ms |  572.30% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]       | 229,929,867ns | 229.930ms |  858.69% |
| RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]     | 233,551,065ns | 233.551ms |  873.79% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]      | 234,093,097ns | 234.093ms |  876.05% |
| RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false] | 234,562,471ns | 234.562ms |  878.01% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]   | 239,577,889ns | 239.578ms |  898.92% |
| RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]  | 243,418,670ns | 243.419ms |  914.93% |

#### 1_000_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]    |  23,566,147ns |  23.566ms |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]     |  26,045,210ns |  26.045ms |   10.52% |
| RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]      | 158,885,276ns | 158.885ms |  574.21% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]         | 560,666,826ns | 560.667ms | 2279.12% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]    | 593,260,735ns | 593.261ms | 2417.43% |
| RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]   | 629,395,375ns | 629.395ms | 2570.76% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]       | 630,688,866ns | 630.689ms | 2576.25% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]        | 654,682,512ns | 654.682ms | 2678.06% |
| RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]     | 755,996,898ns | 755.997ms | 3107.98% |


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


### E2E amortized cost

This measures the end-to-end amortized cost.

#### Observable
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.observable_e2e[enabled=false,times=0,guardedDelegateEnabled=false]             |      76,363ns |     0.076ms |
| RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,guardedDelegateEnabled=false]             |      78,558ns |     0.079ms |    2.87% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,guardedDelegateEnabled=false]              |     119,878ns |     0.120ms |   56.98% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,guardedDelegateEnabled=true]               |     126,007ns |     0.126ms |   65.01% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=0,guardedDelegateEnabled=false]              |     135,660ns |     0.136ms |   77.65% |
| RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=false]         |     320,312ns |     0.320ms |  319.46% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=true]           |     348,645ns |     0.349ms |  356.56% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=false]          |     349,218ns |     0.349ms |  357.31% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]       | 229,929,867ns |   229.930ms | 301001.14% |
| RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]     | 233,551,065ns |   233.551ms | 305743.23% |
| RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]      | 234,093,097ns |   234.093ms | 306453.04% |

#### Flowable
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=0,guardedDelegateEnabled=false]               |      95,650ns |     0.096ms |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,guardedDelegateEnabled=false]                |     123,924ns |     0.124ms |   29.56% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,guardedDelegateEnabled=true]                 |     129,253ns |     0.129ms |   35.13% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=true]             |     383,229ns |     0.383ms |  300.66% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=0,guardedDelegateEnabled=false]                |     388,472ns |     0.388ms |  306.14% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=false]            |     390,417ns |     0.390ms |  308.17% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,guardedDelegateEnabled=false]               |     870,794ns |     0.871ms |  810.40% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=false]           |   1,060,676ns |     1.061ms | 1008.91% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]         | 560,666,826ns |   560.667ms | 586065.00% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]       | 630,688,866ns |   630.689ms | 659271.53% |
| RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]        | 654,682,512ns |   654.682ms | 684356.36% |
