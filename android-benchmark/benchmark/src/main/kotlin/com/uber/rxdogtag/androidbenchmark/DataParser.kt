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
    11:40:42 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=   28,138,284 ns RxDogTagAndroidPerf.observable1000000_false
11:40:43 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          244 ns RxDogTagAndroidPerf.observable_false_subscribe_simple
11:40:43 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,918 ns RxDogTagAndroidPerf.flowable1_true
11:40:43 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,575 ns RxDogTagAndroidPerf.flowable_true_subscribe_simple
11:41:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  234,386,742 ns RxDogTagAndroidPerf.observable1000000_java_true
11:41:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       30,367 ns RxDogTagAndroidPerf.observable1000_false
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      208,489 ns RxDogTagAndroidPerf.flowable1000_java_true
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=277075
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=271015
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=208489
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=78292
11:41:13 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=7
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_java_true
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=8
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e_java
11:41:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      171,302 ns RxDogTagAndroidPerf.flowable_true_e2e_java
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=895914
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=901042
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=171302
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=514509
11:41:21 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=8
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e_java
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=9
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_simple_java
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,666 ns RxDogTagAndroidPerf.flowable_true_subscribe_simple_java
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=29
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=23207
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=19351
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16666
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=11670
11:41:21 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=9
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_simple_java
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=10
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e
11:41:21 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      126,823 ns RxDogTagAndroidPerf.observable_true_e2e
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=428476
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=366380
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=126823
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=308016
11:41:29 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=10
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=11
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_java_true
11:41:29 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      209,427 ns RxDogTagAndroidPerf.observable1000_java_true
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=225585
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=223568
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=209427
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=11563
11:41:37 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=11
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_java_true
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=12
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_true
11:41:37 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  164,902,360 ns RxDogTagAndroidPerf.flowable1000000_true
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=176954606
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=175047673
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=164902360
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=7404619
11:41:54 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=12
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_true
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=13
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e_java
11:41:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      144,583 ns RxDogTagAndroidPerf.observable_true_e2e_java
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=323153
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=338437
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=144583
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=144382
11:42:02 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=13
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_e2e_java
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=14
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_complex
11:42:02 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=        2,790 ns RxDogTagAndroidPerf.observable_false_subscribe_complex
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=59
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=6323
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=5244
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=2790
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=5045
11:42:04 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=14
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_subscribe_complex
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=15
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_false
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          275 ns RxDogTagAndroidPerf.observable1_false
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=730
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=445
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=292
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=275
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=412
11:42:04 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=15
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_false
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=16
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_java_true
11:42:04 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       17,401 ns RxDogTagAndroidPerf.flowable1_java_true
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=17902
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17831
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=17401
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=415
11:42:05 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=16
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_java_true
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=17
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       38,578 ns RxDogTagAndroidPerf.flowable_true_subscribe_complex
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=10
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=44100
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=43689
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=38578
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=4376
11:42:05 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=17
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=18
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_true
11:42:05 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      200,781 ns RxDogTagAndroidPerf.flowable1000_true
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=252578
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=220182
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=200781
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=71990
11:42:13 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=18
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_true
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=19
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_false
11:42:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=   28,629,066 ns RxDogTagAndroidPerf.flowable1000000_false
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=29892077
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=29701877
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=28629066
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=657013
11:42:23 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=19
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_false
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=20
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_complex
11:42:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,839 ns RxDogTagAndroidPerf.flowable_false_subscribe_complex
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=16
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=30009
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=27154
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16839
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=15346
11:42:24 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=20
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_complex
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=21
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_java_true
11:42:24 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  243,863,410 ns RxDogTagAndroidPerf.flowable1000000_java_true
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=258817628
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=259496927
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=243863410
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=8785281
11:42:46 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=21
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000000_java_true
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=22
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_e2e
11:42:46 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      118,126 ns RxDogTagAndroidPerf.flowable_false_e2e
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=843309
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=916614
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=118126
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=405213
11:42:54 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=22
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_e2e
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=23
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000000_true
11:42:54 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=  164,230,641 ns RxDogTagAndroidPerf.observable1000000_true
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=175429367
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=173484731
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=164230641
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=7672965
11:43:10 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=23
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000000_true
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=24
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex_java
11:43:10 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       37,838 ns RxDogTagAndroidPerf.flowable_true_subscribe_complex_java
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=8
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=72372
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=55465
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=37838
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=60887
11:43:12 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=24
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_subscribe_complex_java
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=25
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_java_true
11:43:12 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       17,328 ns RxDogTagAndroidPerf.observable1_java_true
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=27
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=19094
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=18091
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=17328
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=2483
11:43:13 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=25
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_java_true
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=26
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,755 ns RxDogTagAndroidPerf.observable_true_subscribe_simple
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=17210
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17125
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16755
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=426
11:43:13 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=26
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=27
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex_java
11:43:13 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       23,443 ns RxDogTagAndroidPerf.observable_true_subscribe_complex_java
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=17
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=28660
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=28850
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=23443
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=2069
11:43:14 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=27
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex_java
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=28
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex
11:43:14 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       24,275 ns RxDogTagAndroidPerf.observable_true_subscribe_complex
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=12
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=39498
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=33331
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=24275
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=20419
11:43:15 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=28
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_complex
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=29
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_true
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       17,420 ns RxDogTagAndroidPerf.observable1_true
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=27
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=17850
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=17689
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=17420
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=370
11:43:15 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=29
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1_true
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=30
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e
11:43:15 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      201,197 ns RxDogTagAndroidPerf.flowable_true_e2e
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=1033963
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=1078880
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=201197
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=390877
11:43:23 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=30
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_true_e2e
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=31
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_simple
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          207 ns RxDogTagAndroidPerf.flowable_false_subscribe_simple
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=783
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=355
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=293
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=207
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=300
11:43:23 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=31
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable_false_subscribe_simple
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=32
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_e2e
11:43:23 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      130,208 ns RxDogTagAndroidPerf.observable_false_e2e
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=1
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=950981
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=1013984
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=130208
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=471249
11:43:31 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=32
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_false_e2e
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=33
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple_java
11:43:31 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       16,486 ns RxDogTagAndroidPerf.observable_true_subscribe_simple_java
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=28
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=19871
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=19064
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=16486
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=4109
11:43:32 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=33
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable_true_subscribe_simple_java
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=34
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_false
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=          463 ns RxDogTagAndroidPerf.flowable1_false
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=286
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=541
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=548
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=463
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=70
11:43:32 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=34
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1_false
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=35
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_true
11:43:32 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=      158,411 ns RxDogTagAndroidPerf.observable1000_true
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: count=2
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: mean=192960
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: median=166926
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: min=158411
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: standardDeviation=84365
11:43:33 W/InstrumentationResultParser: invalid instrumentation status bundle unknown result
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: -1
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=35
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=.
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=observable1000_true
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 0
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: class=com.uber.rxdogtag.androidbenchmark.RxDogTagAndroidPerf
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: current=36
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: id=AndroidJUnitRunner
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: numtests=36
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: stream=
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: test=flowable1000_false
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS_CODE: 1
11:43:33 V/InstrumentationResultParser: INSTRUMENTATION_STATUS: android.studio.display.benchmark=       32,447 ns RxDogTagAndroidPerf.flowable1000_false
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
