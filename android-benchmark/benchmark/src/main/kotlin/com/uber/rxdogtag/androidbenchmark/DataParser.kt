package com.uber.rxdogtag.androidbenchmark

import java.util.Locale

fun main() {

  val data = """
benchmark:         9,770 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:        20,783 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:         7,506 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:         7,275 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=0,guardedDelegateEnabled=false]
benchmark:        50,492 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:        50,787 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:         7,581 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:         7,378 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=true]
benchmark:        49,195 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:        50,081 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:         7,234 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:         7,060 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,guardedDelegateEnabled=false]
benchmark:       313,334 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       342,812 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       153,124 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       152,943 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=true]
benchmark:       312,864 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:       375,208 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:        40,568 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:        40,743 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,guardedDelegateEnabled=false]
benchmark:   257,553,671 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   300,186,228 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   162,547,359 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   166,887,047 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=true]
benchmark:   249,739,764 ns RxDogTagAndroidPerf.observable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:   302,880,498 ns RxDogTagAndroidPerf.flowable_complex[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    26,791,825 ns RxDogTagAndroidPerf.flowable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    27,304,847 ns RxDogTagAndroidPerf.observable_simple[enabled=true,times=1,000,000,guardedDelegateEnabled=false]
benchmark:         1,673 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:         5,741 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:           365 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:           331 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=0,guardedDelegateEnabled=false]
benchmark:        53,672 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:        56,004 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:           519 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:           532 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,guardedDelegateEnabled=false]
benchmark:       291,301 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:       273,178 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:        24,920 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:        23,968 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,guardedDelegateEnabled=false]
benchmark:   252,727,577 ns RxDogTagAndroidPerf.observable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:   304,952,062 ns RxDogTagAndroidPerf.flowable_complex[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    23,952,919 ns RxDogTagAndroidPerf.flowable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
benchmark:    23,993,700 ns RxDogTagAndroidPerf.observable_simple[enabled=false,times=1,000,000,guardedDelegateEnabled=false]
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
  val scoreLength = results.maxBy { it.formattedScore.length }!!.formattedScore.length

  val output = buildString {
    appendln()
    append("## ")
    append(type.title)
    appendln()
    appendln()
    append("_")
    append(type.description)
    append("_")
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
          val content = sorted
              .joinToString("\n") { analysis ->
                analysis.formattedString(
                    scoreLength,
                    largestDelta
                )
              }
          "### ${grouping.name}" +
              "\n| RxDogTag Enabled | Guarded Observer Callbacks Enabled | Time (ms) | Time (ns) |" +
              "\n|----------|----------|------------|-----------|" +
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
private fun String.isSimple(): Boolean = "simple" in this
private fun String.isComplex(): Boolean = "complex" in this

private enum class ResultType(val title: String, val description: String, val groupings: List<Grouping>) {
  THROUGHPUT(
      title = "Event throughput: grouped by number of events",
      description = "Measures the amount of time it takes for given number of elements to pass through the stream.",
      groupings = run {
        mutableListOf<Grouping>().apply {
          val complexities: Map<String, (String) -> Boolean> = mapOf(
              "Simple" to String::isSimple,
              "Complex" to String::isComplex
          )
          val counts: Map<String, (String) -> Boolean> = mapOf(
              "1 item" to String::isSingle,
              "1_000 items" to String::isThousand,
              "1_000_000 items" to String::isMillion
          )
          val types: Map<String, (String) -> Boolean> = mapOf(
              "Observable" to String::isObservable,
              "Flowable" to String::isFlowable
          )
          for (type in types) {
            for (count in counts) {
              for (complexity in complexities) {
                add(Grouping("${complexity.key}: ${count.key} (${type.key})") {
                  complexity.value.invoke(it) && count.value.invoke(it) && type.value.invoke(it)
                })
              }
            }
          }
        }
      }
  ),
  SUBSCRIBE(
      title = "Subscribe cost: grouped by complexity",
      description = "Measures the cost to subscription incurred by RxDogTag. Subscription means no emissions, subscription only.",
      groupings = listOf(
          Grouping("Simple (Observable)") {
            it.isSimple() && it.isSubscribeThroughput() && it.isObservable()
          },
          Grouping("Simple (Flowable)") {
            it.isSimple() && it.isSubscribeThroughput() && it.isFlowable()
          },
          Grouping("Complex (Observable)") {
            it.isComplex() && it.isSubscribeThroughput() && it.isObservable()
          },
          Grouping("Complex (Flowable)") {
            it.isComplex() && it.isSubscribeThroughput() && it.isFlowable()
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

  val rxDogTagEnabled = benchmark.substringAfter("enabled=")
      .substringBefore(",")
      .toBoolean()
  val guardedObserverCallbacksEnabled = benchmark.substringAfter("guardedDelegateEnabled=")
      .substringBefore("]")
      .toBoolean()

  fun formattedString(scoreLength: Int, msLength: Int): String {
    return String.format(Locale.US,
        "| %-${5}s | %-${5}s | %$msLength.3f%s | %${scoreLength}s%s |",
        rxDogTagEnabled,
        guardedObserverCallbacksEnabled,
        score.toFloat() / 1000000,
        "ms",
        formattedScore,
        units
    )
  }

  val formattedScore: String
    get() = String.format(Locale.US, "%,d", score)
}

