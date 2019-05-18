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
