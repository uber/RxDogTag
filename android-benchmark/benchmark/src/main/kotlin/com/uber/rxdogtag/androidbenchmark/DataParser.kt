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
    03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=   27,655,627 ns RxDogTagAndroidPerf.observable1000000_false
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=27952770
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=27935498
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=27655627
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=171902
03:04:56 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=1
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000000_false
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=2
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_simple
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          145 ns RxDogTagAndroidPerf.observable_false_subscribe_simple
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1189
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=157
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=155
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=145
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=7
03:04:56 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=2
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_simple
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=3
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_true
03:04:56 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,713 ns RxDogTagAndroidPerf.flowable1_true
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=29
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=19715
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17742
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16713
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=4854
03:04:57 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=3
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_true
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=4
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_simple
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,152 ns RxDogTagAndroidPerf.flowable_true_subscribe_simple
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=30
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=16654
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=16531
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16152
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=367
03:04:57 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=4
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_simple
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=5
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_false
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       28,750 ns RxDogTagAndroidPerf.observable1000_false
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=17
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=29187
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=28984
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=28750
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=609
03:04:57 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=5
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_false
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=6
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e
03:04:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      120,885 ns RxDogTagAndroidPerf.observable_true_e2e
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=745514
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=840651
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=120885
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=476431
03:05:05 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=6
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=7
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_true
03:05:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  251,774,088 ns RxDogTagAndroidPerf.flowable1000000_true
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=280346298
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=282302059
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=251774088
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=11077242
03:05:28 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=7
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_true
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=8
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_complex
03:05:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=        3,652 ns RxDogTagAndroidPerf.observable_false_subscribe_complex
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=59
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=6983
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=7137
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=3652
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=2043
03:05:31 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=8
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_complex
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=9
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_false
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          296 ns RxDogTagAndroidPerf.observable1_false
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=368
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=389
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=323
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=296
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=125
03:05:31 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=9
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_false
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=10
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex
03:05:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       28,177 ns RxDogTagAndroidPerf.flowable_true_subscribe_complex
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=8
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=60960
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=44488
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=28177
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=60831
03:05:39 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=10
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=11
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_true
03:05:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      224,036 ns RxDogTagAndroidPerf.flowable1000_true
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=2
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=259850
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=239323
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=224036
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=50609
03:05:47 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=11
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_true
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=12
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_false
03:05:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=   30,929,430 ns RxDogTagAndroidPerf.flowable1000000_false
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=31055696
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=31063232
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=30929430
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=46026
03:05:57 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=12
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_false
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=13
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_complex
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       81,739 ns RxDogTagAndroidPerf.flowable_false_subscribe_complex
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=5
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=94875
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=91536
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=81739
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=16698
03:05:57 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=13
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_complex
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=14
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_e2e
03:05:57 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      129,895 ns RxDogTagAndroidPerf.flowable_false_e2e
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=872360
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=946302
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=129895
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=452491
03:06:05 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=14
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_e2e
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=15
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000000_true
03:06:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  244,371,691 ns RxDogTagAndroidPerf.observable1000000_true
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=277058936
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=276680470
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=244371691
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=12600930
03:06:28 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=15
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000000_true
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=16
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,715 ns RxDogTagAndroidPerf.observable_true_subscribe_simple
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=17160
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=16923
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16715
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=457
03:06:28 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=16
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=17
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       22,637 ns RxDogTagAndroidPerf.observable_true_subscribe_complex
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=17
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=26246
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=25998
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=22637
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=1671
03:06:28 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=17
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=18
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_true
03:06:28 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       17,105 ns RxDogTagAndroidPerf.observable1_true
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=17645
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17378
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=17105
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=566
03:06:29 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=18
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_true
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=19
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e
03:06:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      173,750 ns RxDogTagAndroidPerf.flowable_true_e2e
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=390623
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=277682
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=173750
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=303828
03:06:37 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=19
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=20
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_simple
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          276 ns RxDogTagAndroidPerf.flowable_false_subscribe_simple
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=750
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=318
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=290
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=276
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=84
03:06:37 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=20
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_simple
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=21
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_e2e
03:06:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      115,416 ns RxDogTagAndroidPerf.observable_false_e2e
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=4
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=591792
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=658873
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=115416
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=369377
03:06:39 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=21
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_e2e
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=22
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_false
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          481 ns RxDogTagAndroidPerf.flowable1_false
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=320
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=583
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=541
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=481
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=147
03:06:39 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=22
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_false
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=23
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_true
03:06:39 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      232,240 ns RxDogTagAndroidPerf.observable1000_true
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=349887
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=248932
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=232240
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=284694
03:06:47 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=23
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_true
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=24
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_false
03:06:47 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
03:06:48 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       31,145 ns RxDogTagAndroidPerf.flowable1000_false
  """.trimIndent()

  val withInline = """
    04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=   27,993,127 ns RxDogTagAndroidPerf.observable1000000_false
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=28544401
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=28505940
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=27993127
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=413973
04:00:07 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=1
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000000_false
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=2
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_simple
04:00:07 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          203 ns RxDogTagAndroidPerf.observable_false_subscribe_simple
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=936
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=272
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=272
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=203
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=19
04:00:08 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=2
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_simple
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=3
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_true
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       17,172 ns RxDogTagAndroidPerf.flowable1_true
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=17790
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17467
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=17172
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=666
04:00:08 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=3
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_true
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=4
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_simple
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,591 ns RxDogTagAndroidPerf.flowable_true_subscribe_simple
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=29
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=17106
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=16941
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16591
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=583
04:00:08 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=4
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_simple
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=5
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_false
04:00:08 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       28,900 ns RxDogTagAndroidPerf.observable1000_false
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=17
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=31855
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=29382
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=28900
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=7226
04:00:09 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=5
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_false
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=6
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e
04:00:09 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      121,197 ns RxDogTagAndroidPerf.observable_true_e2e
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=675977
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=589974
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=121197
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=510608
04:00:17 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=6
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=7
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_true
04:00:17 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  192,294,706 ns RxDogTagAndroidPerf.flowable1000000_true
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=223622777
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=230037444
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=192294706
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=19724335
04:00:36 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=7
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_true
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=8
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_complex
04:00:36 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=        2,708 ns RxDogTagAndroidPerf.observable_false_subscribe_complex
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=10569
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=8750
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=2708
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=10899
04:00:44 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=8
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_complex
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=9
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_false
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          292 ns RxDogTagAndroidPerf.observable1_false
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=629
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=482
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=430
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=292
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=265
04:00:44 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=9
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_false
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=10
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex
04:00:44 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       58,794 ns RxDogTagAndroidPerf.flowable_true_subscribe_complex
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=7
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=60995
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=60416
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=58794
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=1356
04:00:46 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=10
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=11
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_true
04:00:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      202,057 ns RxDogTagAndroidPerf.flowable1000_true
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=2
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=253459
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=225612
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=202057
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=65771
04:00:51 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=11
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_true
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=12
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_false
04:00:51 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=   28,982,971 ns RxDogTagAndroidPerf.flowable1000000_false
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=29156045
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=29107503
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=28982971
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=209575
04:01:00 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=12
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_false
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=13
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_complex
04:01:00 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       56,282 ns RxDogTagAndroidPerf.flowable_false_subscribe_complex
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=8
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=77077
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=68007
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=56282
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=43131
04:01:03 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=13
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_complex
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=14
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_e2e
04:01:03 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      117,605 ns RxDogTagAndroidPerf.flowable_false_e2e
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=1003370
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=956692
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=117605
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=619826
04:01:11 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=14
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_e2e
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=15
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000000_true
04:01:11 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  200,050,333 ns RxDogTagAndroidPerf.observable1000000_true
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=218856559
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=218527001
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=200050333
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=8065470
04:01:30 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=15
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000000_true
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=16
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,798 ns RxDogTagAndroidPerf.observable_true_subscribe_simple
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=17260
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17114
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16798
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=374
04:01:30 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=16
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=17
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex
04:01:30 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       27,454 ns RxDogTagAndroidPerf.observable_true_subscribe_complex
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=16
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=38219
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=35247
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=27454
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=12033
04:01:31 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=17
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=18
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_true
04:01:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       17,382 ns RxDogTagAndroidPerf.observable1_true
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=21497
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=19133
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=17382
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=8008
04:01:32 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=18
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_true
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=19
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e
04:01:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      152,760 ns RxDogTagAndroidPerf.flowable_true_e2e
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=2
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=171963
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=162461
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=152760
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=32193
04:01:37 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=19
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=20
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_simple
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          279 ns RxDogTagAndroidPerf.flowable_false_subscribe_simple
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=561
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=391
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=355
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=279
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=262
04:01:37 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=20
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_simple
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=21
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_e2e
04:01:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       90,781 ns RxDogTagAndroidPerf.observable_false_e2e
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=563084
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=159869
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=90781
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=553562
04:01:45 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=21
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_e2e
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=22
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_false
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          321 ns RxDogTagAndroidPerf.flowable1_false
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=576
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=537
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=471
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=321
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=257
04:01:45 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=22
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_false
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=23
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_true
04:01:45 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      199,635 ns RxDogTagAndroidPerf.observable1000_true
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=270015
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=237708
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=199635
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=118907
04:01:53 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=23
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_true
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=24
04:01:53 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
04:01:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=24
04:01:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
04:01:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_false
04:01:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
04:01:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       29,150 ns RxDogTagAndroidPerf.flowable1000_false
  """.trimIndent()

  // Skip the header line
  val results = withInline.lineSequence()
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
