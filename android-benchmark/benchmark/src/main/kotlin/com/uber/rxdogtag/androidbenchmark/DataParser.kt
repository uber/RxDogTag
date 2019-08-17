package com.uber.rxdogtag.androidbenchmark

import java.util.Locale

fun main() {

  val data = """
benchmark:        14,269 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:        27,034 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:        63,732 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:         7,442 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:       186,840 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:        14,265 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:        17,560 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:        46,790 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:       115,243 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:        13,404 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:       116,405 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:        13,507 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=0,guardedDelegateEnabled=0]
benchmark:        23,422 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:        46,192 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:        92,916 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:        14,033 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:       122,204 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:        13,980 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:        23,762 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:        47,893 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:        98,776 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:        13,644 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:       119,514 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:        13,592 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=1]
benchmark:        23,466 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:        43,669 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:       136,787 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:       154,427 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:       147,673 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:       159,912 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:        23,180 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:        45,162 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:       378,836 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:        34,509 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:       141,129 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:        34,875 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=1,000]
benchmark:        23,191 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:        44,994 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:    20,738,700 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:   161,182,464 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:    21,975,626 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:   161,894,078 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:        24,027 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:        47,864 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:    20,862,085 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:    20,801,408 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:    22,018,231 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:    20,961,981 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:         7,467 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=0,guardedDelegateEnabled=0]
benchmark:        20,298 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=0,guardedDelegateEnabled=0]
benchmark:        72,360 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=0,guardedDelegateEnabled=0]
benchmark:           358 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=0,guardedDelegateEnabled=0]
benchmark:        92,697 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=0,guardedDelegateEnabled=0]
benchmark:           327 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=0,guardedDelegateEnabled=0]
benchmark:         3,769 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,guardedDelegateEnabled=1]
benchmark:        20,874 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,guardedDelegateEnabled=1]
benchmark:        76,627 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,guardedDelegateEnabled=1]
benchmark:           446 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,guardedDelegateEnabled=1]
benchmark:        90,625 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,guardedDelegateEnabled=1]
benchmark:           432 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,guardedDelegateEnabled=1]
benchmark:         9,268 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,guardedDelegateEnabled=1,000]
benchmark:        20,608 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,guardedDelegateEnabled=1,000]
benchmark:        97,513 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=1,000]
benchmark:        18,109 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,guardedDelegateEnabled=1,000]
benchmark:       117,109 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=1,000]
benchmark:        18,708 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,guardedDelegateEnabled=1,000]
benchmark:         9,318 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:        21,124 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:    20,517,658 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:    17,795,731 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:    21,892,815 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=1,000,000]
benchmark:    18,326,148 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=1,000,000]
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
