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
package rxdogtag2.autodispose2;

import autodispose2.observers.AutoDisposingCompletableObserver;
import autodispose2.observers.AutoDisposingMaybeObserver;
import autodispose2.observers.AutoDisposingObserver;
import autodispose2.observers.AutoDisposingSingleObserver;
import autodispose2.observers.AutoDisposingSubscriber;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import org.reactivestreams.Subscriber;
import rxdogtag2.ObserverHandler;

final class AutoDisposeObserverHandler implements ObserverHandler {

  static final AutoDisposeObserverHandler INSTANCE = new AutoDisposeObserverHandler();

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
