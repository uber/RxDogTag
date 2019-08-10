# Benchmarks

## Running the benchmark

You can run the benchmark by executing `./gradlew :android-benchmark:benchmark:connectedCheck`. Note that the benchmark should be run on an actual device

You can then take the output from the benchmark and run it through `DataParser.kt` to get a structured breakdown as seen below.

It's important to look at the units than at the percentages. In general, RxDogTag does add some overhead to your RxJava subscriptions but that overhead is irrelevant in the larger execution context of the code around it (less than a millisecond in most cases).

## Results

Running the benchmark on a [Pixel 3](https://store.google.com/product/pixel_3_specs) yields the following results:

### Event throughput (grouped by number of events)

Measures the amount of time it takes for given number of elements to pass through the stream.

#### 1 item (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
|RxDogTagAndroidPerf.observable1_false | 212ns | 0.000ms|
|RxDogTagAndroidPerf.observable1_true | 13,267ns | 0.013ms | 6158.02% |

#### 1 item (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable1_false | 223ns | 0.000ms |
| RxDogTagAndroidPerf.flowable1_true | 13,129ns | 0.013ms | 5787.44% |

#### 1000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.observable1000_false | 17,596ns | 0.018ms
| RxDogTagAndroidPerf.observable1000_true | 156,953ns | 0.157ms | 791.98%

#### 1000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.flowable1000_false | 17,854ns | 0.018ms
| RxDogTagAndroidPerf.flowable1000_true | 143,646ns | 0.144ms | 704.56%

#### 1_000_000 items (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.observable1000000_false | 17,078,596ns | 17.079ms
| RxDogTagAndroidPerf.observable1000000_true | 161,099,912ns | 161.100ms | 843.29%

#### 1_000_000 items (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.flowable1000000_false | 17,790,262ns | 17.790ms
| RxDogTagAndroidPerf.flowable1000000_true | 152,887,724ns | 152.888ms | 759.39%

### Subscribe Cost (grouped by complexity)

This measures the cost to subscription incurred by RxDogTag.

#### Simple (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.observable_false_subscribe_simple | 112ns | 0.000ms
| RxDogTagAndroidPerf.observable_true_subscribe_simple | 13,017ns | 0.013ms | 11522.32%

#### Simple (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_false_subscribe_simple | 147ns | 0.000ms
| RxDogTagAndroidPerf.flowable_true_subscribe_simple | 12,725ns | 0.013ms | 8556.46%

#### Complex (Observable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.observable_false_subscribe_complex | 5,322ns | 0.005ms
| RxDogTagAndroidPerf.observable_true_subscribe_complex | 25,046ns | 0.025ms | 370.61%

#### Complex (Flowable)
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_false_subscribe_complex | 8,376ns | 0.008ms
| RxDogTagAndroidPerf.flowable_true_subscribe_complex | 49,184ns | 0.049ms | 487.20%

### End-to-end amortized cost

This measures the end-to-end amortized cost.

#### Observable
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.observable_false_e2e | 99,010ns | 0.099ms
| RxDogTagAndroidPerf.observable_true_e2e | 145,833ns | 0.146ms | 47.29%

#### Flowable
| Benchmark | Time (ns) | Time (ms) | Percent Increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_false_e2e | 126,371ns | 0.126ms
| RxDogTagAndroidPerf.flowable_true_e2e | 153,107ns | 0.153ms | 21.16%
