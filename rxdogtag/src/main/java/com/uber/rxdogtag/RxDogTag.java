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
package com.uber.rxdogtag;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableSet;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.reactivestreams.Subscriber;

/**
 * RxDogTag is a mechanism to automatically detect RxJava observers with no error handling and wrap
 * them in {@code DogTagObserver}s that attempt to deduce the line number that {@code subscribe()}
 * was called and surface that in the eventual thrown {@link OnErrorNotImplementedException}
 * message.
 *
 * <p>To use, simply call {@link #install} or use {@link #builder()} to install with configuration.
 * Note that this uses {@link RxJavaPlugins}'s {@code onSubscribe} hooks.
 */
public final class RxDogTag {

  public static final String STACK_ELEMENT_SOURCE_HEADER = "[[ ↑↑ Inferred subscribe point ↑↑ ]]";
  public static final String STACK_ELEMENT_SOURCE_DELEGATE = "[[ Originating callback: %s ]]";
  public static final String STACK_ELEMENT_TRACE_HEADER = "[[ ↓↓ Original trace ↓↓ ]]";

  private RxDogTag() {
    throw new InstantiationError();
  }

  /**
   * Resets RxDogTag by resetting custom onSubscribe hooks via {@link RxJavaPlugins}. Note that
   * calling this calls the following methods with null values.
   *
   * <p>
   *
   * <ul>
   *   <li>{@link RxJavaPlugins#setOnFlowableSubscribe(BiFunction)}
   *   <li>{@link RxJavaPlugins#setOnObservableSubscribe(BiFunction)}
   *   <li>{@link RxJavaPlugins#setOnMaybeSubscribe(BiFunction)}
   *   <li>{@link RxJavaPlugins#setOnSingleSubscribe(BiFunction)}
   *   <li>{@link RxJavaPlugins#setOnCompletableSubscribe(BiFunction)}
   * </ul>
   */
  public static synchronized void reset() {
    RxJavaPlugins.setOnFlowableSubscribe(null);
    RxJavaPlugins.setOnObservableSubscribe(null);
    RxJavaPlugins.setOnMaybeSubscribe(null);
    RxJavaPlugins.setOnSingleSubscribe(null);
    RxJavaPlugins.setOnCompletableSubscribe(null);
  }

  /** @return a new {@link Builder} to configure and install RxDogTag with. */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Initializes RxDogTag with default {@link Builder} settings via {@link Builder#install()}.
   *
   * <p>
   *
   * <ul>
   *   <li>{@link RxJavaPlugins#setOnFlowableSubscribe(BiFunction)}
   *   <li>{@link RxJavaPlugins#setOnObservableSubscribe(BiFunction)}
   *   <li>{@link RxJavaPlugins#setOnMaybeSubscribe(BiFunction)}
   *   <li>{@link RxJavaPlugins#setOnSingleSubscribe(BiFunction)}
   *   <li>{@link RxJavaPlugins#setOnCompletableSubscribe(BiFunction)}
   * </ul>
   *
   * @see #extractStackElementTag(Throwable, Set)
   */
  public static void install() {
    new Builder().install();
  }

  private static boolean shouldDecorate(Object observerToCheck) {
    if (observerToCheck instanceof TryOnError) {
      return true;
    } else if (observerToCheck instanceof LambdaConsumerIntrospection) {
      return !((LambdaConsumerIntrospection) observerToCheck).hasCustomOnError();
    }
    return false;
  }

  private static synchronized void installWithBuilder(final Configuration config) {
    RxJavaPlugins.setOnObservableSubscribe(
        (observable, originalObserver) -> {
          for (ObserverHandler handler : config.observerHandlers) {
            Observer observerToCheck = handler.handle(observable, originalObserver);
            if (shouldDecorate(observerToCheck)) {
              //noinspection unchecked
              return new DogTagObserver(config, originalObserver);
            }
          }
          return originalObserver;
        });
    RxJavaPlugins.setOnFlowableSubscribe(
        (flowable, originalSubscriber) -> {
          for (ObserverHandler handler : config.observerHandlers) {
            Subscriber subscriberToCheck = handler.handle(flowable, originalSubscriber);
            if (shouldDecorate(subscriberToCheck)) {
              //noinspection unchecked
              return new DogTagSubscriber(config, originalSubscriber);
            }
          }
          return originalSubscriber;
        });
    RxJavaPlugins.setOnSingleSubscribe(
        (single, originalObserver) -> {
          for (ObserverHandler handler : config.observerHandlers) {
            SingleObserver observerToCheck = handler.handle(single, originalObserver);
            if (shouldDecorate(observerToCheck)) {
              //noinspection unchecked
              return new DogTagSingleObserver(config, originalObserver);
            }
          }
          return originalObserver;
        });
    RxJavaPlugins.setOnMaybeSubscribe(
        (maybe, originalObserver) -> {
          for (ObserverHandler handler : config.observerHandlers) {
            MaybeObserver observerToCheck = handler.handle(maybe, originalObserver);
            if (shouldDecorate(observerToCheck)) {
              //noinspection unchecked
              return new DogTagMaybeObserver(config, originalObserver);
            }
          }
          return originalObserver;
        });
    RxJavaPlugins.setOnCompletableSubscribe(
        (completable, originalObserver) -> {
          for (ObserverHandler handler : config.observerHandlers) {
            CompletableObserver observerToCheck = handler.handle(completable, originalObserver);
            if (shouldDecorate(observerToCheck)) {
              return new DogTagCompletableObserver(config, originalObserver);
            }
          }
          return originalObserver;
        });
  }

  /**
   * Extract the tag which should be used for the message from the {@code element}.
   *
   * @param throwable the throwable
   * @return the tag to use.
   */
  private static StackTraceElement extractStackElementTag(
      Throwable throwable, Set<String> ignorablePackages) {
    // DO NOT switch this to Thread.getCurrentThread().getStackTrace(). The test will pass
    // because Robolectric runs them on the JVM but on Android the elements are different.
    StackTraceElement[] stackTrace = throwable.getStackTrace();
    for (StackTraceElement element : stackTrace) {
      if (containsAnyPackages(element.getClassName(), ignorablePackages)) {
        continue;
      }
      return element;
    }
    return new StackTraceElement("Unknown", "unknown", "unknown", 0);
  }

  /**
   * If the delegate {@code onNext()}/{@code onSuccess()}/{@code onComplete()} throws any exception,
   * that is conventionally routed immediately to its `onError()` before we get a chance at it.
   * Since we know that is always just going to throw the {@link OnErrorNotImplementedException}
   * back at us per {@link LambdaConsumerIntrospection}, we can expect it here, unwrap the original
   * cause, and pass it on to our version.
   *
   * <p>Should we ever rewrite this in kotlin, this is a great candidate for inlining.
   *
   * @param errorConsumer the error consumer to call with a potentially extracted
   * @param runnable the runnable to execute the underlying action that may throw
   */
  static void guardedDelegateCall(NonCheckingConsumer<Throwable> errorConsumer, Runnable runnable) {
    final Thread.UncaughtExceptionHandler h = Thread.currentThread().getUncaughtExceptionHandler();
    try {
      Thread.currentThread()
          .setUncaughtExceptionHandler(
              (t, e) -> {
                Thread.currentThread().setUncaughtExceptionHandler(h);
                if (e instanceof OnErrorNotImplementedException) {
                  errorConsumer.accept(e);
                } else if (e instanceof NullPointerException
                    && "subscribeActual failed".equals(e.getMessage())) {
                  errorConsumer.accept(e.getCause());
                } else {
                  h.uncaughtException(t, e);
                }
              });
      runnable.run();
    } catch (OnErrorNotImplementedException e) {
      Throwable cause = e.getCause();
      errorConsumer.accept(cause);
    } finally {
      Thread.currentThread().setUncaughtExceptionHandler(h);
    }
  }

  /**
   * Reports a new {@link OnErrorNotImplementedException} instance with an empty stacktrace and its
   * cause with a modified stacktrace. If the original cause is not an instance of
   * OnErrorNotImplementedException, a new one is created with the cause as its original cause. The
   * new modified stacktrace contains a line pointing to the inferred subscribe point, and then the
   * trace of the original {@code originalCause} (as the actual trace for the created trace is
   * irrelevant). The message of the exception is the message from the {@code originalCause}, if
   * present, and an empty string otherwise.
   *
   * <p>Reporting is done via {@link RxJavaPlugins#onError(Throwable)}.
   *
   * @param stackSource the source throwable to extract a stack element tag from.
   * @param originalCause the cause of the original error.
   * @param callbackType optional callback type of the original exception (onComplete, onNext, etc).
   */
  static void reportError(
      Configuration config,
      Throwable stackSource,
      Throwable originalCause,
      @Nullable String callbackType) {
    StackTraceElement s = RxDogTag.extractStackElementTag(stackSource, config.ignoredPackages);
    Throwable varOriginalCause = originalCause;
    OnErrorNotImplementedException error;
    Throwable cause;
    if (config.repackageOnErrorNotImplementedExceptions
        && varOriginalCause instanceof OnErrorNotImplementedException) {
      // Hide the original OENIE because we want to repackage it instead
      varOriginalCause = varOriginalCause.getCause();
    }
    if (varOriginalCause instanceof OnErrorNotImplementedException) {
      error = (OnErrorNotImplementedException) varOriginalCause;
      cause = error.getCause();
    } else {
      String message = varOriginalCause.getMessage();
      if (message == null) {
        message = "";
      }
      error = new OnErrorNotImplementedException(message, varOriginalCause);
      error.setStackTrace(new StackTraceElement[0]);
      cause = varOriginalCause;
    }
    StackTraceElement[] originalTrace = cause.getStackTrace();
    int syntheticLength = 3;
    if (callbackType != null) {
      syntheticLength++;
    }
    StackTraceElement[] newTrace;
    if (config.disableAnnotations) {
      newTrace = new StackTraceElement[originalTrace.length + 1];
      newTrace[0] = s;
      if (originalTrace.length != 0) {
        System.arraycopy(originalTrace, 0, newTrace, 1, originalTrace.length);
      }
    } else {
      // If a synchronous subscription races through the lifecycle, we could get "duplicates"
      // here. Check that here and crop the chain to avoid
      // noise.
      // TODO(zsweers) we could possibly explore parsing the past delegate types for better
      // visibility
      int srcPos = 0;
      int lastCauseIndex =
          indexOfLast(
              originalTrace,
              (StackTraceElement e) -> STACK_ELEMENT_TRACE_HEADER.equals(e.getClassName()));

      if (lastCauseIndex != -1) {
        // We have an older cause, chop it any everything in between
        srcPos = lastCauseIndex + 1;
      }
      newTrace = new StackTraceElement[originalTrace.length + syntheticLength - srcPos];
      int indexCount = 0;
      newTrace[indexCount++] = s;
      newTrace[indexCount++] = new StackTraceElement(STACK_ELEMENT_SOURCE_HEADER, "", "", 0);
      if (callbackType != null) {
        newTrace[indexCount++] =
            new StackTraceElement(
                String.format(Locale.US, STACK_ELEMENT_SOURCE_DELEGATE, callbackType), "", "", 0);
      }
      newTrace[indexCount] = new StackTraceElement(STACK_ELEMENT_TRACE_HEADER, "", "", 0);
      if (originalTrace.length != 0) {
        System.arraycopy(
            originalTrace, srcPos, newTrace, syntheticLength, originalTrace.length - srcPos);
      }
    }
    cause.setStackTrace(newTrace);
    RxJavaPlugins.onError(error);
  }

  private static boolean containsAnyPackages(String input, Set<String> ignorablePackages) {
    for (String packageName : ignorablePackages) {
      if (input.startsWith(packageName)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns index of the last element matching the given {@code predicate}, or -1 if the array does
   * not contain such element.
   */
  private static <T> int indexOfLast(T[] array, NonCheckingPredicate<T> predicate) {
    for (int index = array.length - 1; index >= 0; --index) {
      if (predicate.test(array[index])) {
        return index;
      }
    }
    return -1;
  }

  public static final class Builder {
    boolean guardObserverCallbacks = true;
    boolean disableAnnotations = false;
    List<ObserverHandler> observerHandlers = new ArrayList<>();
    Set<String> ignoredPackages = new LinkedHashSet<>();
    boolean repackageOnErrorNotImplementedExceptions = true;

    Builder() {}

    /**
     * Disables stacktrace annotations. No headers like {@link #STACK_ELEMENT_TRACE_HEADER} will be
     * present in the stack if this is disabled.
     *
     * @return this builder for fluent chaining.
     */
    public Builder disableAnnotations() {
      disableAnnotations = true;
      return this;
    }

    /**
     * @param handlers any number of {@link ObserverHandler} instances to potentially unpack or
     *     decorate observers. Note that order matters here, and the first one to return a {@link
     *     LambdaConsumerIntrospection} with no custom error handling will be used.
     * @return this builder for fluent chaining.
     */
    public Builder addObserverHandlers(ObserverHandler... handlers) {
      return addObserverHandlers(asList(handlers));
    }

    /**
     * @param handlers a list of {@link ObserverHandler} instances to potentially unpack or decorate
     *     observers. Note that order matters here, and the first one to return a {@link
     *     LambdaConsumerIntrospection} with no custom error handling will be used.
     * @return this builder for fluent chaining.
     */
    public Builder addObserverHandlers(Collection<ObserverHandler> handlers) {
      observerHandlers.addAll(handlers);
      return this;
    }

    /**
     * @param packages ignorable packages. Useful if decorating observers that you know can be
     *     safely ignored when deducing a target subscribe() point. It's recommended that classes in
     *     these packages have their names kept in Proguard/R8 obfuscation as well.
     * @return this builder for fluent chaining.
     */
    public Builder addIgnoredPackages(String... packages) {
      return addIgnoredPackages(asList(packages));
    }

    /**
     * @param packages ignorable packages. Useful if decorating observers that you know can be
     *     safely ignored when deducing a target subscribe() point. It's recommended that classes in
     *     these packages have their names kept in Proguard/R8 obfuscation as well.
     * @return this builder for fluent chaining.
     */
    public Builder addIgnoredPackages(Collection<String> packages) {
      ignoredPackages.addAll(packages);
      return this;
    }

    /**
     * @param guardObserverCallbacks Guards observer callbacks so that any exceptions that occur
     *     during observer callbacks are intercepted and routed to RxDogTag's error handling that
     *     will give you more info on the subscription point. Set to true by default.
     * @return this builder for fluent chaining.
     */
    public Builder guardObserverCallbacks(boolean guardObserverCallbacks) {
      this.guardObserverCallbacks = guardObserverCallbacks;
      return this;
    }

    /**
     * Can be used to compose this builder with a {@link Configurer} in a way that doesn't break the
     * builder chain.
     *
     * <p>Example:
     *
     * <pre><code>
     *   RxDogTag.builder()
     *       .configureWith(AutoDisposeConfigurer::configure)
     *       .install();
     * </code></pre>
     *
     * @param configurer an {@link Configurer} instance to be called.
     * @return this builder for fluent chaining.
     */
    public Builder configureWith(Configurer configurer) {
      configurer.apply(this);
      return this;
    }

    /**
     * By default, RxDogTag will repackage {@link OnErrorNotImplementedException
     * OnErrorNotImplementedExceptions} with its own custom, simplified one with no stacktrace and
     * the original cause's message copied in. This is effectively the same behavior as any other
     * type of exception.
     *
     * <p>If you don't want this behavior, you can use this configuration to disable that behavior.
     * This should only be disabled if you throw your own custom {@link
     * OnErrorNotImplementedException} that you want visible in the stacktrace.
     *
     * @return this builder for fluent chaining.
     */
    public Builder disableRepackagingOnErrorNotImplementedExceptions() {
      this.repackageOnErrorNotImplementedExceptions = false;
      return this;
    }

    /**
     * Initializes RxDogTag by installing custom onSubscribe hooks via {@link RxJavaPlugins}. Note
     * that calling this calls the following methods:
     *
     * <p>
     *
     * <ul>
     *   <li>{@link RxJavaPlugins#setOnFlowableSubscribe(BiFunction)}
     *   <li>{@link RxJavaPlugins#setOnObservableSubscribe(BiFunction)}
     *   <li>{@link RxJavaPlugins#setOnMaybeSubscribe(BiFunction)}
     *   <li>{@link RxJavaPlugins#setOnSingleSubscribe(BiFunction)}
     *   <li>{@link RxJavaPlugins#setOnCompletableSubscribe(BiFunction)}
     * </ul>
     *
     * @see #extractStackElementTag(Throwable, Set)
     */
    public void install() {
      RxDogTag.installWithBuilder(new Configuration(this));
    }
  }

  /**
   * Convenience interface to allow custom configurers to hook into a builder to add their own
   * configurations as needed.
   *
   * @see Builder#configureWith(Configurer)
   */
  public interface Configurer {
    /**
     * Called to configure the given {@code builder} instance as needed.
     *
     * @param builder the {@link Builder} to configure.
     */
    void apply(Builder builder);
  }

  /**
   * A functional interface (callback) that returns true or false for the given input value.
   *
   * @param <T> the first value
   */
  private interface NonCheckingPredicate<T> {
    /**
     * Test the given input value and return a boolean.
     *
     * @param t the value
     * @return the boolean result
     */
    boolean test(T t);
  }

  static class Configuration {
    /** Default ignored packages when sourcing originating subscribe points. */
    private static final Collection<String> DEFAULT_IGNORED_PACKAGES =
        asList(
            // "io.reactivex"
            Observable.class.getPackage().getName(),
            // "com.uber.rxdogtag"
            DogTagObserver.class.getPackage().getName());

    private static final ObserverHandler DEFAULT_HANDLER = new ObserverHandler() {};
    final boolean disableAnnotations;
    final List<ObserverHandler> observerHandlers;
    final Set<String> ignoredPackages;
    final boolean repackageOnErrorNotImplementedExceptions;
    final boolean guardObserverCallbacks;

    Configuration(Builder builder) {
      this.disableAnnotations = builder.disableAnnotations;
      final List<ObserverHandler> finalHandlers =
          new ArrayList<>(builder.observerHandlers); // Defensive copy
      finalHandlers.add(DEFAULT_HANDLER);
      final Set<String> finalIgnoredPackages =
          new LinkedHashSet<>(builder.ignoredPackages); // Defensive copy
      finalIgnoredPackages.addAll(DEFAULT_IGNORED_PACKAGES);
      this.observerHandlers = unmodifiableList(finalHandlers);
      this.ignoredPackages = unmodifiableSet(finalIgnoredPackages);
      this.repackageOnErrorNotImplementedExceptions =
          builder.repackageOnErrorNotImplementedExceptions;
      this.guardObserverCallbacks = builder.guardObserverCallbacks;
    }
  }

  /**
   * A functional interface (callback) that accepts a single value. Identical to {@link Consumer}
   * but does not have a checked exception. Solely for use with {@link #guardedDelegateCall}.
   *
   * @param <T> the value type
   */
  interface NonCheckingConsumer<T> {

    /**
     * Consume the given value.
     *
     * @param t the value
     */
    void accept(T t);
  }
}
