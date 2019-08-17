package com.uber.rxdogtag.androidbenchmark

import java.util.Locale

fun main() {

  val data = """
benchmark:        14,154 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=0,guardedDelegateEnabled=true]
benchmark:        26,961 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=0,guardedDelegateEnabled=true]
benchmark:        61,956 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=0,guardedDelegateEnabled=true]
benchmark:         7,396 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=0,guardedDelegateEnabled=true]
benchmark:        76,137 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=0,guardedDelegateEnabled=true]
benchmark:         7,386 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=0,guardedDelegateEnabled=true]
benchmark:        13,648 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:        49,232 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:        95,277 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:        13,415 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:       115,971 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:        13,489 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:        23,733 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:        48,692 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:       123,489 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:        13,871 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:       124,774 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:        13,798 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:        23,161 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:        46,348 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:       135,664 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:        13,521 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:       121,839 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:        13,616 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:        23,952 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:        45,931 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       124,947 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       153,437 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:     1,306,163 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       154,010 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:        23,676 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:        48,553 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:       117,101 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:        35,248 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:       139,045 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:        35,432 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:        23,733 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:        47,575 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:    20,760,992 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   165,654,652 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:    22,290,367 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   163,418,506 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:        23,892 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:        48,721 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    20,773,492 ns RxDogTagAndroidPerf.observable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    21,492,294 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    22,197,294 ns RxDogTagAndroidPerf.flowable_e2e[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    21,918,179 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:         9,564 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:        19,611 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:       706,284 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:           366 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:        93,203 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:           331 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:         9,563 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:        20,918 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:        74,808 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:           450 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:        94,531 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:           422 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:         9,223 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:        17,788 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:        96,341 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:        17,838 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:       118,749 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:        19,229 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:         9,389 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:        20,444 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    20,610,783 ns RxDogTagAndroidPerf.observable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    17,714,481 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    22,196,200 ns RxDogTagAndroidPerf.flowable_e2e[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    18,878,438 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
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
