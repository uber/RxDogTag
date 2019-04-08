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

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.observers.AutoDisposingCompletableObserver;
import com.uber.autodispose.observers.AutoDisposingMaybeObserver;
import com.uber.autodispose.observers.AutoDisposingObserver;
import com.uber.autodispose.observers.AutoDisposingSingleObserver;
import com.uber.autodispose.observers.AutoDisposingSubscriber;
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
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
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
  public static final String STACK_ELEMENT_CAUSE_HEADER = "[[ Original cause ]]";

  private static final List<String> IGNORED_PACKAGES =
      Arrays.asList(
          // "io.reactivex"
          Observable.class.getPackage().getName(),
          // "com.uber.autodispose"
          AutoDispose.class.getPackage().getName(),
          // "com.uber.rxdogtag"
          DogTagObserver.class.getPackage().getName());

  private RxDogTag() {
    throw new InstantiationError();
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
   * @see #extractStackElementTag(Throwable)
   */
  public static synchronized void install() {
    RxJavaPlugins.setOnObservableSubscribe(
        (observable, originalObserver) -> {
          Observer observerToCheck = originalObserver;
          if (observerToCheck instanceof AutoDisposingObserver) {
            observerToCheck = ((AutoDisposingObserver) observerToCheck).delegateObserver();
          }
          if (observerToCheck instanceof LambdaConsumerIntrospection) {
            if (!((LambdaConsumerIntrospection) observerToCheck).hasCustomOnError()) {
              //noinspection unchecked
              return new DogTagObserver(originalObserver);
            }
          }
          return originalObserver;
        });
    RxJavaPlugins.setOnFlowableSubscribe(
        (flowable, originalSubscriber) -> {
          Subscriber subscriberToCheck = originalSubscriber;
          if (subscriberToCheck instanceof AutoDisposingSubscriber) {
            subscriberToCheck = ((AutoDisposingSubscriber) subscriberToCheck).delegateSubscriber();
          }
          if (subscriberToCheck instanceof LambdaConsumerIntrospection) {
            if (!((LambdaConsumerIntrospection) subscriberToCheck).hasCustomOnError()) {
              //noinspection unchecked
              return new DogTagSubscriber(originalSubscriber);
            }
          }
          return originalSubscriber;
        });
    RxJavaPlugins.setOnSingleSubscribe(
        (single, originalObserver) -> {
          SingleObserver observerToCheck = originalObserver;
          if (observerToCheck instanceof AutoDisposingSingleObserver) {
            observerToCheck = ((AutoDisposingSingleObserver) observerToCheck).delegateObserver();
          }
          if (observerToCheck instanceof LambdaConsumerIntrospection) {
            if (!((LambdaConsumerIntrospection) observerToCheck).hasCustomOnError()) {
              //noinspection unchecked
              return new DogTagSingleObserver(originalObserver);
            }
          }
          return originalObserver;
        });
    RxJavaPlugins.setOnMaybeSubscribe(
        (maybe, originalObserver) -> {
          MaybeObserver observerToCheck = originalObserver;
          if (observerToCheck instanceof AutoDisposingMaybeObserver) {
            observerToCheck = ((AutoDisposingMaybeObserver) observerToCheck).delegateObserver();
          }
          if (observerToCheck instanceof LambdaConsumerIntrospection) {
            if (!((LambdaConsumerIntrospection) observerToCheck).hasCustomOnError()) {
              //noinspection unchecked
              return new DogTagMaybeObserver(originalObserver);
            }
          }
          return originalObserver;
        });
    RxJavaPlugins.setOnCompletableSubscribe(
        (completable, originalObserver) -> {
          CompletableObserver observerToCheck = originalObserver;
          if (observerToCheck instanceof AutoDisposingCompletableObserver) {
            observerToCheck =
                ((AutoDisposingCompletableObserver) observerToCheck).delegateObserver();
          }
          if (observerToCheck instanceof LambdaConsumerIntrospection) {
            if (!((LambdaConsumerIntrospection) observerToCheck).hasCustomOnError()) {
              return new DogTagCompletableObserver(originalObserver);
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
                  Throwable cause = e.getCause();
                  if (cause instanceof CauseHolder) {
                    // We threw this, so throw it as-os
                    errorConsumer.accept(e);
                  } else {
                    errorConsumer.accept(cause);
                  }
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
   * Reports a new {@link OnErrorNotImplementedException} instance with a modified stacktrace. The
   * new stacktrace contains a line pointing to the inferred subscribe point, and then the trace of
   * the original {@code cause} (as the actual trace for the created trace is irrelevant). This does
   * carry a {@link CauseHolder} at the bottom to appease the constructor of {@link
   * OnErrorNotImplementedException}, but it has no stacktrace and only has APIs for testing
   * purposes. The message of the exception is the message from the {@code cause}, if present, and
   * an empty string otherwise.
   *
   * <p>Reporting is done via {@link RxJavaPlugins#onError(Throwable)}.
   *
   * @param stackSource the source throwable to extract a stack element tag from.
   * @param cause the cause of the original error.
   * @param callbackType optional callback type of the original exception (onComplete, onNext, etc).
   */
  static void reportError(Throwable stackSource, Throwable cause, @Nullable String callbackType) {
    StackTraceElement s = RxDogTag.extractStackElementTag(stackSource);
    String message = cause.getMessage();
    if (message == null) {
      message = "";
    }
    OnErrorNotImplementedException error =
        new OnErrorNotImplementedException(message, new CauseHolder(cause));
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
            (StackTraceElement e) -> STACK_ELEMENT_CAUSE_HEADER.equals(e.getClassName()));

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
    newTrace[indexCount] = new StackTraceElement(STACK_ELEMENT_CAUSE_HEADER, "", "", 0);
    if (originalTrace.length != 0) {
      System.arraycopy(
          originalTrace, srcPos, newTrace, syntheticLength, originalTrace.length - srcPos);
    }
    error.setStackTrace(newTrace);
    RxJavaPlugins.onError(error);
  }

  private static boolean containsAnyPackages(String input) {
    for (String packageName : IGNORED_PACKAGES) {
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

  /**
   * A throwable that contains no stacktrace and just holds a reference to a cause (but not set
   * directly).
   */
  static class CauseHolder extends Throwable {

    private final Throwable originalCause;

    private CauseHolder(Throwable cause) {
      this.originalCause = cause;
    }

    Throwable originalCause() {
      return originalCause;
    }

    @Override
    public final synchronized Throwable fillInStackTrace() {
      return this;
    }
  }
}
