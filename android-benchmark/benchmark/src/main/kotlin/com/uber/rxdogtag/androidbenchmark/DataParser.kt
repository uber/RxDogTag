package com.uber.rxdogtag.androidbenchmark

import java.util.Locale

fun main() {

  val data = """
benchmark:    17,078,596 ns RxDogTagAndroidPerf.observable1000000_false
benchmark:           112 ns RxDogTagAndroidPerf.observable_false_subscribe_simple
benchmark:        13,129 ns RxDogTagAndroidPerf.flowable1_true
benchmark:        12,725 ns RxDogTagAndroidPerf.flowable_true_subscribe_simple
Timed out waiting for process to appear on google-pixel_3-89UX0H5NB.
benchmark:        17,596 ns RxDogTagAndroidPerf.observable1000_false
benchmark:       145,833 ns RxDogTagAndroidPerf.observable_true_e2e
benchmark:   152,887,724 ns RxDogTagAndroidPerf.flowable1000000_true
benchmark:         5,322 ns RxDogTagAndroidPerf.observable_false_subscribe_complex
benchmark:           212 ns RxDogTagAndroidPerf.observable1_false
benchmark:        49,184 ns RxDogTagAndroidPerf.flowable_true_subscribe_complex
benchmark:       143,646 ns RxDogTagAndroidPerf.flowable1000_true
benchmark:    17,790,262 ns RxDogTagAndroidPerf.flowable1000000_false
benchmark:         8,376 ns RxDogTagAndroidPerf.flowable_false_subscribe_complex
benchmark:       126,371 ns RxDogTagAndroidPerf.flowable_false_e2e
benchmark:   161,099,912 ns RxDogTagAndroidPerf.observable1000000_true
benchmark:        13,017 ns RxDogTagAndroidPerf.observable_true_subscribe_simple
benchmark:        25,046 ns RxDogTagAndroidPerf.observable_true_subscribe_complex
benchmark:        13,267 ns RxDogTagAndroidPerf.observable1_true
benchmark:       153,107 ns RxDogTagAndroidPerf.flowable_true_e2e
benchmark:           147 ns RxDogTagAndroidPerf.flowable_false_subscribe_simple
benchmark:        99,010 ns RxDogTagAndroidPerf.observable_false_e2e
benchmark:           223 ns RxDogTagAndroidPerf.flowable1_false
benchmark:       156,953 ns RxDogTagAndroidPerf.observable1000_true
benchmark:        17,854 ns RxDogTagAndroidPerf.flowable1000_false
  """.trimIndent()

  val newData = """
    08:45:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=   27,510,315 ns RxDogTagAndroidPerf.observable1000000_false
08:45:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          192 ns RxDogTagAndroidPerf.observable_false_subscribe_simple
08:45:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       17,012 ns RxDogTagAndroidPerf.flowable1_true
08:45:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,490 ns RxDogTagAndroidPerf.flowable_true_subscribe_simple
08:45:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  237,925,805 ns RxDogTagAndroidPerf.observable1000000_java_true
08:45:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       30,022 ns RxDogTagAndroidPerf.observable1000_false
08:45:58 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      222,916 ns RxDogTagAndroidPerf.flowable1000_java_true
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      159,948 ns RxDogTagAndroidPerf.flowable_true_e2e_java
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=625608
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=590156
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=159948
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=457012
08:46:06 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=8
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e_java
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=9
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_simple_java
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,167 ns RxDogTagAndroidPerf.flowable_true_subscribe_simple_java
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=29
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=16770
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=16604
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16167
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=569
08:46:06 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=9
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_simple_java
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=10
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e
08:46:06 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      136,093 ns RxDogTagAndroidPerf.observable_true_e2e
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=839205
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=861093
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=136093
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=544110
08:46:14 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=10
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=11
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_java_true
08:46:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      199,323 ns RxDogTagAndroidPerf.observable1000_java_true
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=207570
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=205755
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=199323
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=6866
08:46:22 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=11
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_java_true
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=12
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_true
08:46:22 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  209,531,896 ns RxDogTagAndroidPerf.flowable1000000_true
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=224698208
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=224854605
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=209531896
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=7650609
08:46:42 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=12
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_true
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=13
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e_java
08:46:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      130,938 ns RxDogTagAndroidPerf.observable_true_e2e_java
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=362922
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=315104
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=130938
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=214136
08:46:50 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=13
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e_java
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=14
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_complex
08:46:50 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=        2,964 ns RxDogTagAndroidPerf.observable_false_subscribe_complex
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=65
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=6719
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=7322
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=2964
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=2307
08:46:56 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=14
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_complex
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=15
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_false
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          406 ns RxDogTagAndroidPerf.observable1_false
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=329
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=464
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=429
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=406
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=62
08:46:56 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=15
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_false
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=16
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_java_true
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,982 ns RxDogTagAndroidPerf.flowable1_java_true
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=17493
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17414
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16982
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=395
08:46:56 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=16
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_java_true
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=17
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex
08:46:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       30,208 ns RxDogTagAndroidPerf.flowable_true_subscribe_complex
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=7
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=60852
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=55431
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=30208
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=29286
08:47:00 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=17
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=18
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_true
08:47:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      193,255 ns RxDogTagAndroidPerf.flowable1000_true
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=2
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=215538
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=202291
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=193255
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=60219
08:47:08 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=18
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_true
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=19
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_false
08:47:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=   29,223,701 ns RxDogTagAndroidPerf.flowable1000000_false
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=31718490
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=31793961
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=29223701
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=963150
08:47:18 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=19
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_false
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=20
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_complex
08:47:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       39,702 ns RxDogTagAndroidPerf.flowable_false_subscribe_complex
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=7
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=82142
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=65792
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=39702
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=73476
08:47:20 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=20
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_complex
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=21
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_java_true
08:47:20 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  244,343,566 ns RxDogTagAndroidPerf.flowable1000000_java_true
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=258419669
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=258400884
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=244343566
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=6563622
08:47:41 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=21
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_java_true
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=22
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_e2e
08:47:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      124,114 ns RxDogTagAndroidPerf.flowable_false_e2e
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=879341
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=822162
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=124114
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=583197
08:47:49 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=22
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_e2e
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=23
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000000_true
08:47:49 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  209,643,927 ns RxDogTagAndroidPerf.observable1000000_true
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=226842528
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=226867392
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=209643927
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=8234473
08:48:09 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=23
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000000_true
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=24
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex_java
08:48:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       33,825 ns RxDogTagAndroidPerf.flowable_true_subscribe_complex_java
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=9
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=48595
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=45737
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=33825
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=14187
08:48:17 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=24
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex_java
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=25
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_java_true
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       17,079 ns RxDogTagAndroidPerf.observable1_java_true
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=17777
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17742
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=17079
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=511
08:48:17 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=25
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_java_true
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=26
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,845 ns RxDogTagAndroidPerf.observable_true_subscribe_simple
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=18101
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17134
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16845
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=5606
08:48:17 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=26
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=27
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex_java
08:48:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       22,500 ns RxDogTagAndroidPerf.observable_true_subscribe_complex_java
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=12
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=38809
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=35173
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=22500
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=19837
08:48:18 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=27
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex_java
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=28
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex
08:48:18 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       26,448 ns RxDogTagAndroidPerf.observable_true_subscribe_complex
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=16
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=38494
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=37221
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=26448
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=9979
08:48:19 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=28
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=29
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_true
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       17,559 ns RxDogTagAndroidPerf.observable1_true
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=27
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=18102
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17993
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=17559
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=383
08:48:19 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=29
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_true
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=30
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e
08:48:19 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      165,313 ns RxDogTagAndroidPerf.flowable_true_e2e
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=873489
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=900677
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=165313
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=415176
08:48:27 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=30
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=31
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_simple
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          211 ns RxDogTagAndroidPerf.flowable_false_subscribe_simple
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=816
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=294
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=288
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=211
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=54
08:48:27 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=31
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_simple
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=32
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_e2e
08:48:27 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      108,086 ns RxDogTagAndroidPerf.observable_false_e2e
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=4
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=387887
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=246334
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=108086
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=273494
08:48:33 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=32
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_e2e
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=33
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple_java
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,059 ns RxDogTagAndroidPerf.observable_true_subscribe_simple_java
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=29
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=16981
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=16443
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16059
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=1348
08:48:33 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=33
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple_java
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=34
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_false
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          445 ns RxDogTagAndroidPerf.flowable1_false
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=545
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=521
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=485
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=445
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=151
08:48:33 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=34
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_false
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=35
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_true
08:48:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      199,713 ns RxDogTagAndroidPerf.observable1000_true
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=2
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=244483
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=221119
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=199713
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=67362
08:48:41 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=35
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_true
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=36
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_false
08:48:41 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
08:48:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       32,421 ns RxDogTagAndroidPerf.flowable1000_false
  """.trimIndent()

  // Skip the header line
  val results = newData.lineSequence()
      .filter { it.contains("benchmark=") }
      .map { it.substring(it.indexOf("benchmark=")) }
      .map { line ->
        // benchmark:     6,154,949 ns SpeedTest.gson_autovalue_buffer_fromJson_minified
        val (_, score, units, benchmark) = line.split("\\s+".toRegex())
        Analysis(
            benchmark = benchmark,
            score = score.replace(",", "").toLong(),
            units = units
        )
      }
      .toList()

  ResultType.values().forEach { printResults(it, results) }
}

private fun printResults(type: ResultType, results: List<Analysis>) {
  val groupedResults = type.groupings.associate { grouping ->
    grouping to results.filter {
      grouping.matchFunction(it.benchmark)
    }
  }
  val benchmarkLength = results.maxBy { it.benchmark.length }!!.benchmark.length
  val scoreLength = results.maxBy { it.formattedScore.length }!!.formattedScore.length

  val output = buildString {
    appendln()
    append(type.description)
    appendln(':')
    appendln()
    appendln("```")
    groupedResults.entries
        .joinTo(this, "\n\n", postfix = "\n```") { (grouping, matchedAnalyses) ->
          val sorted = matchedAnalyses.sortedBy { it.score }
          val first = sorted[0]
          val largestDelta = sorted.drop(1)
              .map {
                val delta = ((it.score - first.score).toDouble() / first.score) * 100
                String.format(Locale.US, "%.2f", delta)
              }
              .maxBy {
                it.length
              }!!
              .length
          val msLength = matchedAnalyses.map { String.format(Locale.US, "%.3f", it.score.toFloat() / 1000000) }
              .maxBy { it.length }!!
              .length
          val content = sorted
              .withIndex()
              .joinToString("\n") { (index, analysis) ->
                analysis.formattedString(benchmarkLength,
                    scoreLength,
                    largestDelta,
                    msLength,
                    if (index == 0) null else first.score)
              }
          "${grouping.name}\n$content"
        }
  }

  println(output)
}

private fun String.isFlowable(): Boolean = "flowable" in this
private fun String.isObservable(): Boolean = "observable" in this

private enum class ResultType(val description: String, val groupings: List<Grouping>) {
  THROUGHPUT(
      description = "Event throughput: grouped by number of events",
      groupings = listOf(
          Grouping("1 item (observable)") {
            "1_" in it && it.isObservable()
          },
          Grouping("1 item (flowable)") {
            "1_" in it && it.isFlowable()
          },
          Grouping("1000 items (observable)") {
            "1000_" in it && it.isObservable()
          },
          Grouping("1000 items (flowable)") {
            "1000_" in it && it.isFlowable()
          },
          Grouping("1000000 items (observable)") {
            "1000000_" in it && it.isObservable()
          },
          Grouping("1000000 items (flowable)") {
            "1000000_" in it && it.isFlowable()
          }
      )
  ),
  SUBSCRIBE(
      description = "Subscribe cost: grouped by complexity",
      groupings = listOf(
          Grouping("Simple (observable)") {
            "subscribe" in it && "simple" in it && it.isObservable()
          },
          Grouping("Simple (flowable)") {
            "subscribe" in it && "simple" in it && it.isFlowable()
          },
          Grouping("Complex (observable)") {
            "subscribe" in it && "complex" in it && it.isObservable()
          },
          Grouping("Complex (flowable)") {
            "subscribe" in it && "complex" in it && it.isFlowable()
          }
      )
  ),
  E2E(
      description = "E2E amortized cost",
      groupings = listOf(
          Grouping("Observable") {
            "e2e" in it && it.isObservable()
          },
          Grouping("Flowable") {
            "e2e" in it && it.isFlowable()
          }
      )
  )
}

private data class Grouping(
    val name: String,
    val matchFunction: (String) -> Boolean
)

private data class Analysis(
    val benchmark: String,
    val score: Long,
    val units: String
) {
  override fun toString() = "$benchmark\t$score\t$units"

  fun formattedString(benchmarkLength: Int, scoreLength: Int, msLength: Int, deltaLength: Int, base: Long?): String {
    return if (base == null) {
      String.format(Locale.US,
          "%-${benchmarkLength}s  %${scoreLength}s%s  %$msLength.3f%s",
          benchmark,
          formattedScore,
          units,
          score.toFloat() / 1000000,
          "ms")
    } else {
      val delta = ((score - base).toDouble() / base) * 100
      String.format(Locale.US,
          "%-${benchmarkLength}s  %${scoreLength}s%s  %$msLength.3f%s  %$deltaLength.2f%%",
          benchmark,
          formattedScore,
          units,
          score.toFloat() / 1000000,
          "ms",
          delta)
    }
  }

  val formattedScore: String
    get() = String.format(Locale.US, "%,d", score)
}
