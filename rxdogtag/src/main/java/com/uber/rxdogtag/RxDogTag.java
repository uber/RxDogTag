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
import java.util.Arrays;
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
 * <p>To use, simply call {@link #install()}. Note that this uses {@link RxJavaPlugins}'s {@code
 * onSubscribe} hooks.
 */
public final class RxDogTag {

  public static final String STACK_ELEMENT_SOURCE_HEADER = "[[ Inferred subscribe point ]]";
  public static final String STACK_ELEMENT_SOURCE_DELEGATE = "[[ Originating callback: %s ]]";
  public static final String STACK_ELEMENT_TRACE_HEADER = "[[ Original trace ]]";

  /** Default ignored packages when sourcing originating subscribe points. */
  private static final Collection<String> DEFAULT_IGNORED_PACKAGES =
      Arrays.asList(
          // "io.reactivex"
          Observable.class.getPackage().getName(),
          // "com.uber.rxdogtag"
          DogTagObserver.class.getPackage().getName());

  private RxDogTag() {
    throw new InstantiationError();
  }

  private static final ObserverHandler DEFAULT_HANDLER =
      new ObserverHandler() {
        @Override
        public Collection<String> ignorablePackagePrefixes() {
          return DEFAULT_IGNORED_PACKAGES;
        }
      };
  @Nullable private static volatile Set<String> ignorablePackages = null;

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
    ignorablePackages = null;
    RxJavaPlugins.setOnFlowableSubscribe(null);
    RxJavaPlugins.setOnObservableSubscribe(null);
    RxJavaPlugins.setOnMaybeSubscribe(null);
    RxJavaPlugins.setOnSingleSubscribe(null);
    RxJavaPlugins.setOnCompletableSubscribe(null);
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
   * @param handlers a list of {@link ObserverHandler} instances to potentially unpack or decorate.
   *     Note that order matters here, and the first one to return a {@link
   *     LambdaConsumerIntrospection} with no custom error handling will be used.
   * @see #extractStackElementTag(Throwable)
   */
  public static synchronized void install(ObserverHandler... handlers) {
    install(Arrays.asList(handlers));
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
   * @param handlers a list of {@link ObserverHandler} instances to potentially unpack or decorate.
   *     Note that order matters here, and the first one to return a {@link
   *     LambdaConsumerIntrospection} with no custom error handling will be used.
   * @see #extractStackElementTag(Throwable)
   */
  public static synchronized void install(List<ObserverHandler> handlers) {
    final List<ObserverHandler> finalHandlers = new ArrayList<>(handlers); // Defensive copy
    finalHandlers.add(DEFAULT_HANDLER);
    Set<String> packagesToIgnore = new LinkedHashSet<>();
    for (ObserverHandler handler : finalHandlers) {
      packagesToIgnore.addAll(handler.ignorablePackagePrefixes());
    }
    RxDogTag.ignorablePackages = unmodifiableSet(packagesToIgnore);
    RxJavaPlugins.setOnObservableSubscribe(
        (observable, originalObserver) -> {
          for (ObserverHandler handler : finalHandlers) {
            Observer observerToCheck = handler.handle(observable, originalObserver);
            if (observerToCheck instanceof LambdaConsumerIntrospection) {
              if (!((LambdaConsumerIntrospection) observerToCheck).hasCustomOnError()) {
                //noinspection unchecked
                return new DogTagObserver(originalObserver);
              }
            }
          }
          return originalObserver;
        });
    RxJavaPlugins.setOnFlowableSubscribe(
        (flowable, originalSubscriber) -> {
          for (ObserverHandler handler : finalHandlers) {
            Subscriber subscriberToCheck = handler.handle(flowable, originalSubscriber);
            if (subscriberToCheck instanceof LambdaConsumerIntrospection) {
              if (!((LambdaConsumerIntrospection) subscriberToCheck).hasCustomOnError()) {
                //noinspection unchecked
                return new DogTagSubscriber(originalSubscriber);
              }
            }
          }
          return originalSubscriber;
        });
    RxJavaPlugins.setOnSingleSubscribe(
        (single, originalObserver) -> {
          for (ObserverHandler handler : finalHandlers) {
            SingleObserver observerToCheck = handler.handle(single, originalObserver);
            if (observerToCheck instanceof LambdaConsumerIntrospection) {
              if (!((LambdaConsumerIntrospection) observerToCheck).hasCustomOnError()) {
                //noinspection unchecked
                return new DogTagSingleObserver(originalObserver);
              }
            }
          }
          return originalObserver;
        });
    RxJavaPlugins.setOnMaybeSubscribe(
        (maybe, originalObserver) -> {
          for (ObserverHandler handler : finalHandlers) {
            MaybeObserver observerToCheck = handler.handle(maybe, originalObserver);
            if (observerToCheck instanceof LambdaConsumerIntrospection) {
              if (!((LambdaConsumerIntrospection) observerToCheck).hasCustomOnError()) {
                //noinspection unchecked
                return new DogTagMaybeObserver(originalObserver);
              }
            }
          }
          return originalObserver;
        });
    RxJavaPlugins.setOnCompletableSubscribe(
        (completable, originalObserver) -> {
          for (ObserverHandler handler : finalHandlers) {
            CompletableObserver observerToCheck = handler.handle(completable, originalObserver);
            if (observerToCheck instanceof LambdaConsumerIntrospection) {
              if (!((LambdaConsumerIntrospection) observerToCheck).hasCustomOnError()) {
                return new DogTagCompletableObserver(originalObserver);
              }
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
  private static StackTraceElement extractStackElementTag(Throwable throwable) {
    // DO NOT switch this to Thread.getCurrentThread().getStackTrace(). The test will pass
    // because Robolectric runs them on the JVM but on Android the elements are different.
    StackTraceElement[] stackTrace = throwable.getStackTrace();
    for (StackTraceElement element : stackTrace) {
      if (containsAnyPackages(element.getClassName())) {
        continue;
      }
      return element;
    }
    return new StackTraceElement("Unknown", "unknown", "unknown", 0);
  }

  /**
   * If the delegate {@code onNext()}/{@code onSuccess()}/{@code onComplete()} throws any exception,
   * that is conventionally routed immediately to its `onError()` before we get a chance at it.
   * Since we know that is always just going to throw the OnErrorNotImplementedException back at us
   * per {@link LambdaConsumerIntrospection}, we can expect it here, unwrap the original cause, and
   * pass it on to our version.
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
      Throwable stackSource, Throwable originalCause, @Nullable String callbackType) {
    StackTraceElement s = RxDogTag.extractStackElementTag(stackSource);
    OnErrorNotImplementedException error;
    Throwable cause;
    if (originalCause instanceof OnErrorNotImplementedException) {
      error = (OnErrorNotImplementedException) originalCause;
      cause = error.getCause();
    } else {
      String message = originalCause.getMessage();
      if (message == null) {
        message = "";
      }
      error = new OnErrorNotImplementedException(message, originalCause);
      error.setStackTrace(new StackTraceElement[0]);
      cause = originalCause;
    }
    StackTraceElement[] originalTrace = cause.getStackTrace();
    int syntheticLength = 3;
    if (callbackType != null) {
      syntheticLength++;
    }
    // If a synchronous subscription races through the lifecycle, we could get "duplicates"
    // here. Check that here and crop the chain to avoid
    // noise.
    // TODO(zsweers) we could possibly explore parsing the past delegate types for better visibility
    int srcPos = 0;
    int lastCauseIndex =
        indexOfLast(
            originalTrace,
            (StackTraceElement e) -> STACK_ELEMENT_TRACE_HEADER.equals(e.getClassName()));

    if (lastCauseIndex != -1) {
      // We have an older cause, chop it any everything in between
      srcPos = lastCauseIndex + 1;
    }
    StackTraceElement[] newTrace =
        new StackTraceElement[originalTrace.length + syntheticLength - srcPos];
    int indexCount = 0;
    if (callbackType != null) {
      newTrace[indexCount++] =
          new StackTraceElement(
              String.format(Locale.US, STACK_ELEMENT_SOURCE_DELEGATE, callbackType), "", "", 0);
    }
    newTrace[indexCount++] = new StackTraceElement(STACK_ELEMENT_SOURCE_HEADER, "", "", 0);
    newTrace[indexCount++] = s;
    newTrace[indexCount] = new StackTraceElement(STACK_ELEMENT_TRACE_HEADER, "", "", 0);
    if (originalTrace.length != 0) {
      System.arraycopy(
          originalTrace, srcPos, newTrace, syntheticLength, originalTrace.length - srcPos);
    }
    cause.setStackTrace(newTrace);
    RxJavaPlugins.onError(error);
  }

  private static boolean containsAnyPackages(String input) {
    Set<String> ignorablePackages = RxDogTag.ignorablePackages;
    if (ignorablePackages == null) {
      // Not actually possible, but here to be safe
      return false;
    }
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

  /**
   * A functional interface (callback) that returns true or false for the given input value.
   *
   * @param <T> the first value
   */
  public interface NonCheckingPredicate<T> {
    /**
     * Test the given input value and return a boolean.
     *
     * @param t the value
     * @return the boolean result
     */
    boolean test(T t);
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
