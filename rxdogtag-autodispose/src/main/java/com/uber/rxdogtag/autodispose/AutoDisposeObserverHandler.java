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
package com.uber.rxdogtag.autodispose;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.observers.AutoDisposingCompletableObserver;
import com.uber.autodispose.observers.AutoDisposingMaybeObserver;
import com.uber.autodispose.observers.AutoDisposingObserver;
import com.uber.autodispose.observers.AutoDisposingSingleObserver;
import com.uber.autodispose.observers.AutoDisposingSubscriber;
import com.uber.rxdogtag.ObserverHandler;
import com.uber.rxdogtag.RxDogTag;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import java.util.Collections;
import java.util.Set;
import org.reactivestreams.Subscriber;

/**
 * A {@link ObserverHandler} that supports handling AutoDispose's decorating observers to retrieve
 * their underlying delegate observers.
 *
 * <p>Usage: Configure with {@link #configureWith(RxDogTag.Builder)}.
 */
public class AutoDisposeObserverHandler implements ObserverHandler {

  /**
   * Configures an {@link RxDogTag.Builder} with AutoDispose observer handler and ignored packages
   * support.
   *
   * @param builder the builder to configure.
   * @return the same builder for chaining convenience.
   */
  public static RxDogTag.Builder configureWith(RxDogTag.Builder builder) {
    return builder.addObserverHandlers(INSTANCE).addIgnoredPackages(IGNORE_PACKAGES);
  }

  private static final AutoDisposeObserverHandler INSTANCE = new AutoDisposeObserverHandler();

  private static final Set<String> IGNORE_PACKAGES =
      Collections.singleton(
          // "com.uber.autodispose"
          AutoDispose.class.getPackage().getName());

  private AutoDisposeObserverHandler() {}

  @Override
  public Subscriber handle(Flowable flowable, Subscriber subscriber) {
    if (subscriber instanceof AutoDisposingSubscriber) {
      return ((AutoDisposingSubscriber) subscriber).delegateSubscriber();
    }
    return subscriber;
  }

  @Override
  public Observer handle(Observable observable, Observer observer) {
    if (observer instanceof AutoDisposingObserver) {
      return ((AutoDisposingObserver) observer).delegateObserver();
    }
    return observer;
  }

  @Override
  public MaybeObserver handle(Maybe maybe, MaybeObserver observer) {
    if (observer instanceof AutoDisposingMaybeObserver) {
      return ((AutoDisposingMaybeObserver) observer).delegateObserver();
    }
    return observer;
  }

  @Override
  public SingleObserver handle(Single single, SingleObserver observer) {
    if (observer instanceof AutoDisposingSingleObserver) {
      return ((AutoDisposingSingleObserver) observer).delegateObserver();
    }
    return observer;
  }

  @Override
  public CompletableObserver handle(Completable completable, CompletableObserver observer) {
    if (observer instanceof AutoDisposingCompletableObserver) {
      return ((AutoDisposingCompletableObserver) observer).delegateObserver();
    }
    return observer;
  }

  @Override
  public String toString() {
    return "AutoDisposeObserverHandler";
  }
}
