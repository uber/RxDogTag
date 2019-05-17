package com.uber.rxdogtag.androidbenchmark

import java.util.Locale

fun main() {

  val data = """
benchmark:    17,013,439 ns RxDogTagAndroidPerf.observable1000000_false
benchmark:           129 ns RxDogTagAndroidPerf.observable_false_subscribe_simple
benchmark:        13,065 ns RxDogTagAndroidPerf.flowable1_true
benchmark:        12,958 ns RxDogTagAndroidPerf.flowable_true_subscribe_simple
benchmark:        17,646 ns RxDogTagAndroidPerf.observable1000_false
Timed out waiting for process to appear on google-pixel_3-89UX0H5NB.
benchmark:       165,859 ns RxDogTagAndroidPerf.observable_true_e2e
benchmark:   159,081,838 ns RxDogTagAndroidPerf.flowable1000000_true
benchmark:        12,552 ns RxDogTagAndroidPerf.observable_false_subscribe_complex
benchmark:           214 ns RxDogTagAndroidPerf.observable1_false
benchmark:        49,884 ns RxDogTagAndroidPerf.flowable_true_subscribe_complex
benchmark:       158,559 ns RxDogTagAndroidPerf.flowable1000_true
benchmark:    18,132,450 ns RxDogTagAndroidPerf.flowable1000000_false
benchmark:        21,414 ns RxDogTagAndroidPerf.flowable_false_subscribe_complex
benchmark:       597,691 ns RxDogTagAndroidPerf.flowable_false_e2e
benchmark:   161,793,141 ns RxDogTagAndroidPerf.observable1000000_true
benchmark:        13,072 ns RxDogTagAndroidPerf.observable_true_subscribe_simple
benchmark:        26,189 ns RxDogTagAndroidPerf.observable_true_subscribe_complex
benchmark:        13,505 ns RxDogTagAndroidPerf.observable1_true
benchmark:       154,218 ns RxDogTagAndroidPerf.flowable_true_e2e
benchmark:           151 ns RxDogTagAndroidPerf.flowable_false_subscribe_simple
benchmark:       100,534 ns RxDogTagAndroidPerf.observable_false_e2e
benchmark:           222 ns RxDogTagAndroidPerf.flowable1_false
benchmark:       153,099 ns RxDogTagAndroidPerf.observable1000_true
benchmark:        17,916 ns RxDogTagAndroidPerf.flowable1000_false
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

//  check(groupedResults.values.flatten().size == results.size) {
//    "Missing information!"
//  }

  val output = buildString {
    appendln()
    append(type.description)
    appendln(':')
    appendln()
    appendln("```")
    groupedResults.entries
        .joinTo(this, "\n\n", postfix = "\n```") { (grouping, matchedAnalyses) ->
          val content = matchedAnalyses.sortedBy { it.score }
              .joinToString("\n") { it.formattedString(benchmarkLength, scoreLength) }
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

  fun formattedString(benchmarkLength: Int, scoreLength: Int): String {
    return String.format(Locale.US,
        "%-${benchmarkLength}s  %${scoreLength}s  %s",
        benchmark, formattedScore, units)
  }

  val formattedScore: String
    get() = String.format(Locale.US, "%,d", score)
}
