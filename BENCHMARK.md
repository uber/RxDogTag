# Benchmarks

## Results

### Event throughput (grouped by number of events)

#### 1 item (Observable)
| Benchmark | time (ns) | time (ms) | percent increase |
|----------|------------|-----------|------------------|
|RxDogTagAndroidPerf.observable1_false | 212ns | 0.000ms|
|RxDogTagAndroidPerf.observable1_true | 13,267ns | 0.013ms | 6158.02% |

#### 1 item (Flowable)
| Benchmark | time (ns) | time (ms) | percent increase |
|----------|------------|-----------|------------------|
| RxDogTagAndroidPerf.flowable1_false | 223ns | 0.000ms |
| RxDogTagAndroidPerf.flowable1_true | 13,129ns | 0.013ms | 5787.44% |

#### 1000 items (Observable)
| Benchmark | time (ns) | time (ms) | percent increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.observable1000_false | 17,596ns | 0.018ms
| RxDogTagAndroidPerf.observable1000_true | 156,953ns | 0.157ms | 791.98%

#### 1000 items (Flowable)
| Benchmark | time (ns) | time (ms) | percent increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.flowable1000_false | 17,854ns | 0.018ms
| RxDogTagAndroidPerf.flowable1000_true | 143,646ns | 0.144ms | 704.56%

##### 1_000_000 items (Observable)
| Benchmark | time (ns) | time (ms) | percent increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.observable1000000_false | 17,078,596ns | 17.079ms
| RxDogTagAndroidPerf.observable1000000_true | 161,099,912ns | 161.100ms | 843.29%

#### 1_000_000 items (Flowable)
| Benchmark | time (ns) | time (ms) | percent increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.flowable1000000_false | 17,790,262ns | 17.790ms
| RxDogTagAndroidPerf.flowable1000000_true | 152,887,724ns | 152.888ms | 759.39%

### Subscribe Cost (grouped by complexity)

#### Simple (Observable)
| Benchmark | time (ns) | time (ms) | percent increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.observable_false_subscribe_simple | 112ns | 0.000ms
| RxDogTagAndroidPerf.observable_true_subscribe_simple | 13,017ns | 0.013ms | 11522.32%

#### Simple (Flowable)
| Benchmark | time (ns) | time (ms) | percent increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_false_subscribe_simple | 147ns | 0.000ms
| RxDogTagAndroidPerf.flowable_true_subscribe_simple | 12,725ns | 0.013ms | 8556.46%

#### Complex (Observable)
| Benchmark | time (ns) | time (ms) | percent increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.observable_false_subscribe_complex | 5,322ns | 0.005ms
| RxDogTagAndroidPerf.observable_true_subscribe_complex | 25,046ns | 0.025ms | 370.61%

#### Complex (Flowable)
| Benchmark | time (ns) | time (ms) | percent increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_false_subscribe_complex | 8,376ns | 0.008ms
| RxDogTagAndroidPerf.flowable_true_subscribe_complex | 49,184ns | 0.049ms | 487.20%

### End-to-end amortized cost

#### Observable
| Benchmark | time (ns) | time (ms) | percent increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.observable_false_e2e | 99,010ns | 0.099ms
| RxDogTagAndroidPerf.observable_true_e2e | 145,833ns | 0.146ms | 47.29%

#### Flowable
| Benchmark | time (ns) | time (ms) | percent increase |
|---------- |-----------|-----------|------------------|
| RxDogTagAndroidPerf.flowable_false_e2e | 126,371ns  0.126ms
| RxDogTagAndroidPerf.flowable_true_e2e | 153,107ns | 0.153ms | 21.16%
