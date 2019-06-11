package com.uber.rxdogtag.androidbenchmark

import java.util.Locale

fun main() {

  val data = """
benchmark:    26,984,534 ns RxDogTagAndroidPerf.observable1000000_false
benchmark:           148 ns RxDogTagAndroidPerf.observable_false_subscribe_simple
Timed out waiting for process to appear on google-pixel_2-HT79N1A00303.
benchmark:        16,765 ns RxDogTagAndroidPerf.flowable1_true
benchmark:        15,677 ns RxDogTagAndroidPerf.observable1_true_withoutGuardedDelegate
benchmark:        15,895 ns RxDogTagAndroidPerf.flowable_true_subscribe_simple
benchmark:        27,913 ns RxDogTagAndroidPerf.observable1000_false
benchmark:    34,621,670 ns RxDogTagAndroidPerf.observable1000000_true_withoutGuardedDelegate
benchmark:        15,630 ns RxDogTagAndroidPerf.observable_true_subscribe_simple_withoutGuardedDelegate
benchmark:       129,817 ns RxDogTagAndroidPerf.observable_true_e2e
benchmark:   224,655,387 ns RxDogTagAndroidPerf.flowable1000000_true
benchmark:         5,331 ns RxDogTagAndroidPerf.observable_false_subscribe_complex
benchmark:       152,865 ns RxDogTagAndroidPerf.flowable_true_e2e_withoutGuardedDelegate
benchmark:           423 ns RxDogTagAndroidPerf.observable1_false
benchmark:       126,928 ns RxDogTagAndroidPerf.observable_true_e2e_withoutGuardedDelegate
benchmark:        29,531 ns RxDogTagAndroidPerf.flowable_true_subscribe_complex
benchmark:       210,677 ns RxDogTagAndroidPerf.flowable1000_true
benchmark:    29,811,097 ns RxDogTagAndroidPerf.flowable1000000_false
benchmark:        60,498 ns RxDogTagAndroidPerf.flowable_false_subscribe_complex
benchmark:        36,630 ns RxDogTagAndroidPerf.flowable_true_subscribe_complex_withoutGuardedCall
benchmark:       110,730 ns RxDogTagAndroidPerf.flowable_false_e2e
benchmark:   280,736,746 ns RxDogTagAndroidPerf.observable1000000_true
benchmark:        15,881 ns RxDogTagAndroidPerf.flowable_true_subscribe_simple_withoutGuardedDelegate
benchmark:        15,973 ns RxDogTagAndroidPerf.observable_true_subscribe_simple
benchmark:        23,033 ns RxDogTagAndroidPerf.observable_true_subscribe_complex_withoutGuardedDelegate
benchmark:        22,095 ns RxDogTagAndroidPerf.observable_true_subscribe_complex
benchmark:        16,603 ns RxDogTagAndroidPerf.observable1_true
benchmark:       176,510 ns RxDogTagAndroidPerf.flowable_true_e2e
benchmark:        51,765 ns RxDogTagAndroidPerf.flowable1000_true_withoutGuardedDelegate
benchmark:           198 ns RxDogTagAndroidPerf.flowable_false_subscribe_simple
benchmark:       104,063 ns RxDogTagAndroidPerf.observable_false_e2e
benchmark:    36,557,868 ns RxDogTagAndroidPerf.flowable1000000_true_withoutGuardedDelegate
benchmark:        49,496 ns RxDogTagAndroidPerf.observable1000_true_withoutGuardedDelegate
benchmark:           320 ns RxDogTagAndroidPerf.flowable1_false
benchmark:        16,157 ns RxDogTagAndroidPerf.flowable1_true_withoutGuardedDelegate
benchmark:       249,479 ns RxDogTagAndroidPerf.observable1000_true
benchmark:        32,566 ns RxDogTagAndroidPerf.flowable1000_false
  """.trimIndent()

  // Skip the header line
  val results = data.lineSequence()
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
