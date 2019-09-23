package com.uber.rxdogtag.androidbenchmark

import java.util.Locale

fun main() {

  val data = """
benchmark:        27,028 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:        50,602 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:       135,660 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:        14,616 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:       388,472 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:        14,293 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:       116,120 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:       131,163 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:       126,007 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:        14,609 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:       129,253 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:        14,303 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:     1,799,375 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:       130,781 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:       119,878 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:        13,923 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:       123,924 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:        13,903 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:       756,146 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       592,499 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       348,645 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       152,370 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       383,229 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       149,349 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       387,552 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:       718,021 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:       349,218 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:        40,203 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:       390,417 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:        40,871 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:   239,577,889 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   755,996,898 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   229,929,867 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   158,885,276 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   560,666,826 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   161,242,933 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   243,418,670 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:   593,260,735 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:   234,093,097 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    26,045,210 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:   654,682,512 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    26,762,085 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:         9,485 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:        15,904 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:        76,363 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:           350 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:        95,650 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:           329 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:        79,250 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:     1,456,641 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:        78,558 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:           546 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:       870,794 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:           577 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:     1,429,844 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:       470,885 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:       320,312 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:        24,299 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:     1,060,676 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:        23,987 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:   234,562,471 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:   629,395,375 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:   233,551,065 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    23,566,147 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:   630,688,866 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    23,983,701 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
  """.trimIndent()

  // Skip the header line
  val results = data.lineSequence()
      .filterNot { it.isBlank() }
      .filter { it.startsWith("benchmark") }
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
  val groupedResults = type.groupings.associateWith { grouping ->
      results.filter {
        grouping.matchFunction(it.benchmark)
      }
  }
  check(groupedResults.isNotEmpty()) {
    "Empty results for $type with \n$results"
  }
  val benchmarkLength = results.maxBy { it.benchmark.length }!!.benchmark.length
  val scoreLength = results.maxBy { it.formattedScore.length }!!.formattedScore.length

  val output = buildString {
    appendln()
    append("### ")
    append(type.title)
    appendln()
    appendln()
    append(type.description)
    appendln()
    appendln()
    groupedResults.entries
        .joinTo(this, "\n\n", postfix = "\n") { (grouping, matchedAnalyses) ->
          check(matchedAnalyses.isNotEmpty()) {
            "Empty analysis for $type, $grouping, with \n$matchedAnalyses"
          }
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
          "#### ${grouping.name}" +
              "\n| Benchmark | Time (ns) | Time (ms) | Percent Increase |" +
              "\n|----------|------------|-----------|------------------|" +
              "\n$content"
        }
  }

  println(output)
}

private fun String.isFlowable(): Boolean = "flowable" in this
private fun String.isObservable(): Boolean = "observable" in this
private fun String.isSubscribeThroughput(): Boolean = "times=0" in this
private fun String.isSingle(): Boolean = "=1,g" in this
private fun String.isThousand(): Boolean = "=1,000,g" in this
private fun String.isMillion(): Boolean = "=1,000,000,g" in this
private fun String.isE2e(): Boolean = "e2e" in this

private enum class ResultType(val title: String, val description: String, val groupings: List<Grouping>) {
  THROUGHPUT(
      title = "Event throughput: grouped by number of events",
      description = "Measures the amount of time it takes for given number of elements to pass through the stream.",
      groupings = listOf(
          Grouping("1 item (Observable)") {
            it.isSingle() && it.isObservable()
          },
          Grouping("1 item (Flowable)") {
            it.isSingle() && it.isFlowable()
          },
          Grouping("1_000 items (Observable)") {
            it.isThousand() && it.isObservable()
          },
          Grouping("1_000 items (Flowable)") {
            it.isThousand() && it.isFlowable()
          },
          Grouping("1_000_000 items (Observable)") {
            it.isMillion() && it.isObservable()
          },
          Grouping("1_000_000 items (Flowable)") {
            it.isMillion() && it.isFlowable()
          }
      )
  ),
  SUBSCRIBE(
      title = "Subscribe cost: grouped by complexity",
      description = "This measures the cost to subscription incurred by RxDogTag.",
      groupings = listOf(
          Grouping("Simple (Observable)") {
            !it.isE2e() && "simple" in it && it.isSubscribeThroughput() && it.isObservable()
          },
          Grouping("Simple (Flowable)") {
            !it.isE2e() && "simple" in it && it.isSubscribeThroughput() && it.isFlowable()
          },
          Grouping("Complex (Observable)") {
            !it.isE2e() && "complex" in it && it.isSubscribeThroughput() && it.isObservable()
          },
          Grouping("Complex (Flowable)") {
            !it.isE2e() && "complex" in it && it.isSubscribeThroughput() && it.isFlowable()
          }
      )
  ),
  E2E(
      title = "E2E amortized cost",
      description = "This measures the end-to-end amortized cost.",
      groupings = listOf(
          Grouping("1 item (Observable)") {
            it.isE2e() && it.isSingle() && it.isObservable()
          },
          Grouping("1 item (Flowable)") {
            it.isE2e() && it.isSingle() && it.isFlowable()
          },
          Grouping("1_000 items (Observable)") {
            it.isE2e() && it.isThousand() && it.isObservable()
          },
          Grouping("1_000 items (Flowable)") {
            it.isE2e() && it.isThousand() && it.isFlowable()
          },
          Grouping("1_000_000 items (Observable)") {
            it.isE2e() && it.isMillion() && it.isObservable()
          },
          Grouping("1_000_000 items (Flowable)") {
            it.isE2e() && it.isMillion() && it.isFlowable()
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
          "| %-${benchmarkLength}s | %${scoreLength}s%s | %$msLength.3f%s |",
          benchmark,
          formattedScore,
          units,
          score.toFloat() / 1000000,
          "ms")
    } else {
      val delta = ((score - base).toDouble() / base) * 100
      String.format(Locale.US,
          "| %-${benchmarkLength}s | %${scoreLength}s%s | %$msLength.3f%s | %$deltaLength.2f%% |",
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
