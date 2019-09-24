# Benchmarks

## Running the benchmark

You can run the benchmark by executing `./gradlew :android-benchmark:benchmark:connectedCheck`. Note that the benchmark should be run on an actual device

You can then take the output from the benchmark and run it through `DataParser.kt` to get a structured breakdown as seen below.

It's important to look at the units. In general, RxDogTag does add some overhead to your RxJava subscriptions but that overhead is irrelevant in the larger execution context of the code around it (less than a millisecond in most cases).

## Results

Running the benchmark on a [Pixel 3](https://store.google.com/product/pixel_3_specs) yields the following results:

### Event throughput: grouped by number of events

Measures the amount of time it takes for given number of elements to pass through the stream.

#### Simple: 1 item (Observable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false |   0.001ms |         532ns |
| true  | false |   0.007ms |       7,060ns |
| true  | true  |   0.007ms |       7,378ns |

#### Complex: 1 item (Observable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| true  | false | 0.049ms |      49,195ns |
| true  | true  | 0.050ms |      50,492ns |
| false | false | 0.054ms |      53,672ns |

#### Simple: 1_000 items (Observable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false |  0.024ms |      23,968ns |
| true  | false |  0.041ms |      40,743ns |
| true  | true  |  0.153ms |     152,943ns |

#### Complex: 1_000 items (Observable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false | 0.291ms |     291,301ns |
| true  | false | 0.313ms |     312,864ns |
| true  | true  | 0.313ms |     313,334ns |

#### Simple: 1_000_000 items (Observable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false | 23.994ms |  23,993,700ns |
| true  | false | 27.305ms |  27,304,847ns |
| true  | true  | 166.887ms | 166,887,047ns |

#### Complex: 1_000_000 items (Observable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| true  | false | 249.740ms | 249,739,764ns |
| false | false | 252.728ms | 252,727,577ns |
| true  | true  | 257.554ms | 257,553,671ns |

#### Simple: 1 item (Flowable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false |   0.001ms |         519ns |
| true  | false |   0.007ms |       7,234ns |
| true  | true  |   0.008ms |       7,581ns |

#### Complex: 1 item (Flowable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| true  | false | 0.050ms |      50,081ns |
| true  | true  | 0.051ms |      50,787ns |
| false | false | 0.056ms |      56,004ns |

#### Simple: 1_000 items (Flowable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false |  0.025ms |      24,920ns |
| true  | false |  0.041ms |      40,568ns |
| true  | true  |  0.153ms |     153,124ns |

#### Complex: 1_000 items (Flowable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false | 0.273ms |     273,178ns |
| true  | true  | 0.343ms |     342,812ns |
| true  | false | 0.375ms |     375,208ns |

#### Simple: 1_000_000 items (Flowable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false | 23.953ms |  23,952,919ns |
| true  | false | 26.792ms |  26,791,825ns |
| true  | true  | 162.547ms | 162,547,359ns |

#### Complex: 1_000_000 items (Flowable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| true  | true  | 300.186ms | 300,186,228ns |
| true  | false | 302.881ms | 302,880,498ns |
| false | false | 304.952ms | 304,952,062ns |


### Subscribe cost: grouped by complexity

This measures the cost to subscription incurred by RxDogTag.

#### Simple (Observable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false |   0.000ms |         331ns |
| true  | false |   0.007ms |       7,275ns |

#### Simple (Flowable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false |   0.000ms |         365ns |
| true  | false |   0.008ms |       7,506ns |

#### Complex (Observable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false |  0.002ms |       1,673ns |
| true  | false |  0.010ms |       9,770ns |

#### Complex (Flowable)
| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |
|----------|----------|------------|-----------|
| false | false |  0.006ms |       5,741ns |
| true  | false |  0.021ms |      20,783ns |
