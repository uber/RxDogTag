package com.uber.rxdogtag.androidbenchmark

import java.util.Locale

fun main() {

  val data = """
benchmark:        13,774 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=0]

benchmark:        24,137 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=0]

benchmark:        61,635 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=0]

benchmark:         7,451 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=0]

benchmark:        74,453 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=0]

benchmark:         7,390 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=0]

benchmark:        13,768 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1]

benchmark:        27,448 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1]

benchmark:        60,364 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1]

benchmark:         7,268 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1]

benchmark:        73,099 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1]

benchmark:         7,204 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1]

benchmark:        13,579 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000]

benchmark:        48,883 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000]

benchmark:       143,906 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000]

Timed out waiting for process to appear on google-pixel_3-89UX0H5NB.
benchmark:       157,525 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000]

benchmark:     1,307,361 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000]

benchmark:       154,036 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000]

benchmark:        24,311 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000]

benchmark:        44,661 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000]

benchmark:    20,541,252 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000]

benchmark:   158,292,671 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000]

benchmark:    22,119,429 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000]

benchmark:   160,530,434 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000]

benchmark:         9,152 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=0]

benchmark:        20,534 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=0]

benchmark:        73,854 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=0]

benchmark:           355 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=0]

benchmark:        95,656 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=0]

benchmark:           316 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=0]

benchmark:         7,646 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1]

benchmark:        18,802 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1]

benchmark:        90,694 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1]

benchmark:           445 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1]

benchmark:        89,750 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1]

benchmark:           449 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1]

benchmark:         9,252 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000]

benchmark:        15,729 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000]

benchmark:        94,218 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000]

benchmark:        18,060 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000]

benchmark:       121,536 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000]

benchmark:        20,034 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000]

benchmark:         9,001 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,000]

benchmark:        21,583 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,000]

benchmark:    21,301,147 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,000]

benchmark:    17,801,721 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,000]

benchmark:    21,891,044 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,000]

benchmark:    18,230,262 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,000]
>>>>>>> Update parser
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
  val groupedResults = type.groupings.associate { grouping ->
    grouping to results.filter {
      grouping.matchFunction(it.benchmark)
    }
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

private enum class ResultType(val title: String, val description: String, val groupings: List<Grouping>) {
  THROUGHPUT(
      title = "Event throughput: grouped by number of events",
      description = "Measures the amount of time it takes for given number of elements to pass through the stream.",
      groupings = listOf(
          Grouping("1 item (Observable)") {
            "1_" in it && it.isObservable()
          },
          Grouping("1 item (Flowable)") {
            "1_" in it && it.isFlowable()
          },
          Grouping("1000 items (Observable)") {
            "1000_" in it && it.isObservable()
          },
          Grouping("1000 items (Flowable)") {
            "1000_" in it && it.isFlowable()
          },
          Grouping("1_000_000 items (Observable)") {
            "1000000_" in it && it.isObservable()
          },
          Grouping("1_000_000 items (Flowable)") {
            "1000000_" in it && it.isFlowable()
          }
      )
  ),
  SUBSCRIBE(
      title = "Subscribe cost: grouped by complexity",
      description = "This measures the cost to subscription incurred by RxDogTag.",
      groupings = listOf(
          Grouping("Simple (Observable)") {
            "subscribe" in it && "simple" in it && it.isSubscribeThroughput() && it.isObservable()
          },
          Grouping("Simple (Flowable)") {
            "subscribe" in it && "simple" in it && it.isSubscribeThroughput() && it.isFlowable()
          },
          Grouping("Complex (Observable)") {
            "subscribe" in it && "complex" in it && it.isSubscribeThroughput() && it.isObservable()
          },
          Grouping("Complex (Flowable)") {
            "subscribe" in it && "complex" in it && it.isSubscribeThroughput() && it.isFlowable()
          }
      )
  ),
  E2E(
      title = "E2E amortized cost",
      description = "This measures the end-to-end amortized cost.",
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
