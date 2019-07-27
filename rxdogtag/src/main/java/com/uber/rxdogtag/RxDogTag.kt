/*
 * Copyright (C) 2019. Uber Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.uber.rxdogtag

import java.util.Arrays.asList
import java.util.Collections.unmodifiableList
import java.util.Collections.unmodifiableSet

import io.reactivex.CompletableObserver
import io.reactivex.MaybeObserver
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.annotations.Nullable
import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Consumer
import io.reactivex.observers.LambdaConsumerIntrospection
import io.reactivex.plugins.RxJavaPlugins
import java.util.ArrayList
import java.util.LinkedHashSet
import java.util.Locale
import org.reactivestreams.Subscriber

/**
 * RxDogTag is a mechanism to automatically detect RxJava observers with no error handling and wrap
 * them in `DogTagObserver`s that attempt to deduce the line number that `subscribe()`
 * was called and surface that in the eventual thrown [OnErrorNotImplementedException]
 * message.
 *
 *
 * To use, simply call [.install] or use [.builder] to install with configuration.
 * Note that this uses [RxJavaPlugins]'s `onSubscribe` hooks.
 */
class RxDogTag private constructor() {

  init {
    throw InstantiationError()
  }

  class Builder internal constructor() {
    internal var disableAnnotations = false
    internal var observerHandlers: MutableList<ObserverHandler> = ArrayList()
    internal var ignoredPackages: MutableSet<String> = LinkedHashSet()
    internal var repackageOnErrorNotImplementedExceptions = true

    /**
     * Disables stacktrace annotations. No headers like [.STACK_ELEMENT_TRACE_HEADER] will be
     * present in the stack if this is disabled.
     *
     * @return this builder for fluent chaining.
     */
    fun disableAnnotations(): Builder {
      disableAnnotations = true
      return this
    }

    /**
     * @param handlers any number of [ObserverHandler] instances to potentially unpack or
     * decorate observers. Note that order matters here, and the first one to return a [     ] with no custom error handling will be used.
     * @return this builder for fluent chaining.
     */
    fun addObserverHandlers(vararg handlers: ObserverHandler): Builder {
      return addObserverHandlers(asList(*handlers))
    }

    /**
     * @param handlers a list of [ObserverHandler] instances to potentially unpack or decorate
     * observers. Note that order matters here, and the first one to return a [     ] with no custom error handling will be used.
     * @return this builder for fluent chaining.
     */
    fun addObserverHandlers(handlers: Collection<ObserverHandler>): Builder {
      observerHandlers.addAll(handlers)
      return this
    }

    /**
     * @param packages ignorable packages. Useful if decorating observers that you know can be
     * safely ignored when deducing a target subscribe() point. It's recommended that classes in
     * these packages have their names kept in Proguard/R8 obfuscation as well.
     * @return this builder for fluent chaining.
     */
    fun addIgnoredPackages(vararg packages: String): Builder {
      return addIgnoredPackages(asList(*packages))
    }

    /**
     * @param packages ignorable packages. Useful if decorating observers that you know can be
     * safely ignored when deducing a target subscribe() point. It's recommended that classes in
     * these packages have their names kept in Proguard/R8 obfuscation as well.
     * @return this builder for fluent chaining.
     */
    fun addIgnoredPackages(packages: Collection<String>): Builder {
      ignoredPackages.addAll(packages)
      return this
    }

    /**
     * Can be used to compose this builder with a [Configurer] in a way that doesn't break the
     * builder chain.
     *
     *
     * Example:
     *
     * <pre>`
     * RxDogTag.builder()
     * .configureWith(AutoDisposeConfigurer::configure)
     * .install();
    `</pre> *
     *
     * @param configurer an [Configurer] instance to be called.
     * @return this builder for fluent chaining.
     */
    fun configureWith(configurer: Configurer): Builder {
      configurer.apply(this)
      return this
    }

    /**
     * By default, RxDogTag will repackage [ OnErrorNotImplementedExceptions][OnErrorNotImplementedException] with its own custom, simplified one with no stacktrace and
     * the original cause's message copied in. This is effectively the same behavior as any other
     * type of exception.
     *
     *
     * If you don't want this behavior, you can use this configuration to disable that behavior.
     * This should only be disabled if you throw your own custom [ ] that you want visible in the stacktrace.
     *
     * @return this builder for fluent chaining.
     */
    fun disableRepackagingOnErrorNotImplementedExceptions(): Builder {
      this.repackageOnErrorNotImplementedExceptions = false
      return this
    }

    /**
     * Initializes RxDogTag by installing custom onSubscribe hooks via [RxJavaPlugins]. Note
     * that calling this calls the following methods:
     *
     *
     *
     *
     *
     *  * [RxJavaPlugins.setOnFlowableSubscribe]
     *  * [RxJavaPlugins.setOnObservableSubscribe]
     *  * [RxJavaPlugins.setOnMaybeSubscribe]
     *  * [RxJavaPlugins.setOnSingleSubscribe]
     *  * [RxJavaPlugins.setOnCompletableSubscribe]
     *
     *
     * @see .extractStackElementTag
     */
    fun install() {
      RxDogTag.installWithBuilder(Configuration(this))
    }
  }

  /**
   * Convenience interface to allow custom configurers to hook into a builder to add their own
   * configurations as needed.
   *
   * @see Builder.configureWith
   */
  interface Configurer {
    /**
     * Called to configure the given `builder` instance as needed.
     *
     * @param builder the [Builder] to configure.
     */
    fun apply(builder: Builder)
  }

  /**
   * A functional interface (callback) that returns true or false for the given input value.
   *
   * @param <T> the first value
  </T> */
  private interface NonCheckingPredicate<T> {
    /**
     * Test the given input value and return a boolean.
     *
     * @param t the value
     * @return the boolean result
     */
    fun test(t: T): Boolean
  }

  internal class Configuration(builder: Builder) {
    val disableAnnotations: Boolean
    val observerHandlers: List<ObserverHandler>
    val ignoredPackages: Set<String>
    val repackageOnErrorNotImplementedExceptions: Boolean

    init {
      this.disableAnnotations = builder.disableAnnotations
      val finalHandlers = ArrayList(builder.observerHandlers) // Defensive copy
      finalHandlers.add(DEFAULT_HANDLER)
      val finalIgnoredPackages = LinkedHashSet(builder.ignoredPackages) // Defensive copy
      finalIgnoredPackages.addAll(DEFAULT_IGNORED_PACKAGES)
      this.observerHandlers = unmodifiableList(finalHandlers)
      this.ignoredPackages = unmodifiableSet(finalIgnoredPackages)
      this.repackageOnErrorNotImplementedExceptions = builder.repackageOnErrorNotImplementedExceptions
    }

    companion object {
      /** Default ignored packages when sourcing originating subscribe points.  */
      private val DEFAULT_IGNORED_PACKAGES = asList<String>(
          // "io.reactivex"
          Observable::class.java.getPackage().name,
          // "com.uber.rxdogtag"
          DogTagObserver::class.java.getPackage().name)

      private val DEFAULT_HANDLER = object : ObserverHandler {

      }
    }
  }

  /**
   * A functional interface (callback) that accepts a single value. Identical to [Consumer]
   * but does not have a checked exception. Solely for use with [.guardedDelegateCall].
   *
   * @param <T> the value type
  </T> */
  internal interface NonCheckingConsumer<T> {

    /**
     * Consume the given value.
     *
     * @param t the value
     */
    fun accept(t: T)
  }

  companion object {

    @JvmField
    val STACK_ELEMENT_SOURCE_HEADER = "[[ ↑↑ Inferred subscribe point ↑↑ ]]"
    @JvmField
    val STACK_ELEMENT_SOURCE_DELEGATE = "[[ Originating callback: %s ]]"
    @JvmField
    val STACK_ELEMENT_TRACE_HEADER = "[[ ↓↓ Original trace ↓↓ ]]"

    /**
     * Resets RxDogTag by resetting custom onSubscribe hooks via [RxJavaPlugins]. Note that
     * calling this calls the following methods with null values.
     *
     *
     *
     *
     *
     *  * [RxJavaPlugins.setOnFlowableSubscribe]
     *  * [RxJavaPlugins.setOnObservableSubscribe]
     *  * [RxJavaPlugins.setOnMaybeSubscribe]
     *  * [RxJavaPlugins.setOnSingleSubscribe]
     *  * [RxJavaPlugins.setOnCompletableSubscribe]
     *
     */
    @Synchronized
    @JvmStatic
    fun reset() {
      RxJavaPlugins.setOnFlowableSubscribe(null)
      RxJavaPlugins.setOnObservableSubscribe(null)
      RxJavaPlugins.setOnMaybeSubscribe(null)
      RxJavaPlugins.setOnSingleSubscribe(null)
      RxJavaPlugins.setOnCompletableSubscribe(null)
    }

    /** @return a new [Builder] to configure and install RxDogTag with.
     */
    @JvmStatic
    fun builder(): Builder {
      return Builder()
    }

    /**
     * Initializes RxDogTag with default [Builder] settings via [Builder.install].
     *
     *
     *
     *
     *
     *  * [RxJavaPlugins.setOnFlowableSubscribe]
     *  * [RxJavaPlugins.setOnObservableSubscribe]
     *  * [RxJavaPlugins.setOnMaybeSubscribe]
     *  * [RxJavaPlugins.setOnSingleSubscribe]
     *  * [RxJavaPlugins.setOnCompletableSubscribe]
     *
     *
     * @see .extractStackElementTag
     */
    @JvmStatic
    fun install() {
      Builder().install()
    }

    @Synchronized
    private fun installWithBuilder(config: Configuration) {
      RxJavaPlugins.setOnObservableSubscribe { observable, originalObserver ->
        for (handler in config.observerHandlers) {
          val observerToCheck = handler.handle(observable, originalObserver)
          if (observerToCheck is LambdaConsumerIntrospection) {
            if (!(observerToCheck as LambdaConsumerIntrospection).hasCustomOnError()) {

              return@setOnObservableSubscribe DogTagObserver(config, originalObserver)
            }
          }
        }
        originalObserver
      }
      RxJavaPlugins.setOnFlowableSubscribe { flowable, originalSubscriber ->
        for (handler in config.observerHandlers) {
          val subscriberToCheck = handler.handle(flowable, originalSubscriber)
          if (subscriberToCheck is LambdaConsumerIntrospection) {
            if (!(subscriberToCheck as LambdaConsumerIntrospection).hasCustomOnError()) {
              return@setOnFlowableSubscribe DogTagSubscriber(config, originalSubscriber)
            }
          }
        }
        originalSubscriber
      }
      RxJavaPlugins.setOnSingleSubscribe { single, originalObserver ->
        for (handler in config.observerHandlers) {
          val observerToCheck = handler.handle(single, originalObserver)
          if (observerToCheck is LambdaConsumerIntrospection) {
            if (!(observerToCheck as LambdaConsumerIntrospection).hasCustomOnError()) {
              return@setOnSingleSubscribe DogTagSingleObserver( config, originalObserver)
            }
          }
        }
        originalObserver
      }
      RxJavaPlugins.setOnMaybeSubscribe { maybe, originalObserver ->
        for (handler in config.observerHandlers) {
          val observerToCheck = handler.handle(maybe, originalObserver)
          if (observerToCheck is LambdaConsumerIntrospection) {
            if (!(observerToCheck as LambdaConsumerIntrospection).hasCustomOnError()) {
              return@setOnMaybeSubscribe DogTagMaybeObserver(config, originalObserver)
            }
          }
        }
        originalObserver
      }
      RxJavaPlugins.setOnCompletableSubscribe { completable, originalObserver ->
        for (handler in config.observerHandlers) {
          val observerToCheck = handler.handle(completable, originalObserver)
          if (observerToCheck is LambdaConsumerIntrospection) {
            if (!(observerToCheck as LambdaConsumerIntrospection).hasCustomOnError()) {
              return@setOnCompletableSubscribe DogTagCompletableObserver(config, originalObserver)
            }
          }
        }
        originalObserver
      }
    }

    /**
     * Extract the tag which should be used for the message from the `element`.
     *
     * @param throwable the throwable
     * @return the tag to use.
     */
    private fun extractStackElementTag(
        throwable: Throwable, ignorablePackages: Set<String>): StackTraceElement {
      // DO NOT switch this to Thread.getCurrentThread().getStackTrace(). The test will pass
      // because Robolectric runs them on the JVM but on Android the elements are different.
      val stackTrace = throwable.stackTrace
      for (element in stackTrace) {
        if (containsAnyPackages(element.className, ignorablePackages)) {
          continue
        }
        return element
      }
      return StackTraceElement("Unknown", "unknown", "unknown", 0)
    }

    /**
     * If the delegate `onNext()`/`onSuccess()`/`onComplete()` throws any exception,
     * that is conventionally routed immediately to its `onError()` before we get a chance at it.
     * Since we know that is always just going to throw the [OnErrorNotImplementedException]
     * back at us per [LambdaConsumerIntrospection], we can expect it here, unwrap the original
     * cause, and pass it on to our version.
     *
     *
     * Should we ever rewrite this in kotlin, this is a great candidate for inlining.
     *
     * @param errorConsumer the error consumer to call with a potentially extracted
     * @param runnable the runnable to execute the underlying action that may throw
     */
    internal inline fun guardedDelegateCall(errorConsumer: NonCheckingConsumer<Throwable>, runnable: () -> Unit) {
      val h = Thread.currentThread().uncaughtExceptionHandler
      try {
        Thread.currentThread()
            .setUncaughtExceptionHandler { t, e ->
              Thread.currentThread().uncaughtExceptionHandler = h
              if (e is OnErrorNotImplementedException) {
                errorConsumer.accept(e)
              } else if (e is NullPointerException && "subscribeActual failed" == e.message) {
                errorConsumer.accept(e.cause!!)
              } else {
                h.uncaughtException(t, e)
              }
            }
        runnable()
      } catch (e: OnErrorNotImplementedException) {
        val cause = e.cause
        errorConsumer.accept(cause!!)
      } finally {
        Thread.currentThread().uncaughtExceptionHandler = h
      }
    }

    /**
     * Reports a new [OnErrorNotImplementedException] instance with an empty stacktrace and its
     * cause with a modified stacktrace. If the original cause is not an instance of
     * OnErrorNotImplementedException, a new one is created with the cause as its original cause. The
     * new modified stacktrace contains a line pointing to the inferred subscribe point, and then the
     * trace of the original `originalCause` (as the actual trace for the created trace is
     * irrelevant). The message of the exception is the message from the `originalCause`, if
     * present, and an empty string otherwise.
     *
     *
     * Reporting is done via [RxJavaPlugins.onError].
     *
     * @param stackSource the source throwable to extract a stack element tag from.
     * @param originalCause the cause of the original error.
     * @param callbackType optional callback type of the original exception (onComplete, onNext, etc).
     */
    internal fun reportError(
        config: Configuration,
        stackSource: Throwable,
        originalCause: Throwable,
        @Nullable callbackType: String?) {
      val s = RxDogTag.extractStackElementTag(stackSource, config.ignoredPackages)
      var varOriginalCause = originalCause
      val error: OnErrorNotImplementedException
      val cause: Throwable
      if (config.repackageOnErrorNotImplementedExceptions && varOriginalCause is OnErrorNotImplementedException) {
        // Hide the original OENIE because we want to repackage it instead
        varOriginalCause = varOriginalCause.cause!!
      }
      if (varOriginalCause is OnErrorNotImplementedException) {
        error = varOriginalCause
        cause = error.cause!!
      } else {
        var message: String? = varOriginalCause.message
        if (message == null) {
          message = ""
        }
        error = OnErrorNotImplementedException(message, varOriginalCause)
        error.stackTrace = arrayOfNulls(0)
        cause = varOriginalCause
      }
      val originalTrace = cause.stackTrace
      var syntheticLength = 3
      if (callbackType != null) {
        syntheticLength++
      }
      val newTrace: Array<StackTraceElement?>
      if (config.disableAnnotations) {
        newTrace = arrayOfNulls(originalTrace.size + 1)
        newTrace[0] = s
        if (originalTrace.isNotEmpty()) {
          System.arraycopy(originalTrace, 0, newTrace, 1, originalTrace.size)
        }
      } else {
        // If a synchronous subscription races through the lifecycle, we could get "duplicates"
        // here. Check that here and crop the chain to avoid
        // noise.
        // TODO(zsweers) we could possibly explore parsing the past delegate types for better
        // visibility
        var srcPos = 0
        val lastCauseIndex = indexOfLast(
            originalTrace,
            object : NonCheckingPredicate<StackTraceElement> {
              override fun test(t: StackTraceElement): Boolean {
                return STACK_ELEMENT_TRACE_HEADER == t.className
              }
            })

        if (lastCauseIndex != -1) {
          // We have an older cause, chop it any everything in between
          srcPos = lastCauseIndex + 1
        }
        newTrace = arrayOfNulls(originalTrace.size + syntheticLength - srcPos)
        var indexCount = 0
        newTrace[indexCount++] = s
        newTrace[indexCount++] = StackTraceElement(STACK_ELEMENT_SOURCE_HEADER, "", "", 0)
        if (callbackType != null) {
          newTrace[indexCount++] = StackTraceElement(
              String.format(Locale.US, STACK_ELEMENT_SOURCE_DELEGATE, callbackType), "", "", 0)
        }
        newTrace[indexCount] = StackTraceElement(STACK_ELEMENT_TRACE_HEADER, "", "", 0)
        if (originalTrace.isNotEmpty()) {
          System.arraycopy(
              originalTrace, srcPos, newTrace, syntheticLength, originalTrace.size - srcPos)
        }
      }
      cause.stackTrace = newTrace
      RxJavaPlugins.onError(error)
    }

    private fun containsAnyPackages(input: String, ignorablePackages: Set<String>): Boolean {
      for (packageName in ignorablePackages) {
        if (input.startsWith(packageName)) {
          return true
        }
      }
      return false
    }

    /**
     * Returns index of the last element matching the given `predicate`, or -1 if the array does
     * not contain such element.
     */
    private fun <T> indexOfLast(array: Array<T>, predicate: NonCheckingPredicate<T>): Int {
      for (index in array.indices.reversed()) {
        if (predicate.test(array[index])) {
          return index
        }
      }
      return -1
    }
  }
}
