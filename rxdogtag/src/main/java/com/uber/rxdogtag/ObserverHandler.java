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

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.observers.LambdaConsumerIntrospection;
import java.util.Collection;
import java.util.Collections;
import org.reactivestreams.Subscriber;

/**
 * This interface can be used to further decorate or unpack custom subscribers/observers as needed.
 *
 * <p>Example use cases:
 *
 * <ul>
 *   <li>Unpacking custom observers to yield their underlying delegate observers or {@link
 *       LambdaConsumerIntrospection} behavior.
 *   <li>Decorating observers with custom runtime behavior.
 * </ul>
 *
 * <p>Note: The observer returned here will <em>NOT</em> be used for anything other than determining
 * if there is custom error handling.
 */
public interface ObserverHandler {

  /**
   * @return a list of ignorable packages. Useful if decorating observers that you know can be
   *     safely ignored when deducing a target subscribe() point. It's recommended that classes in
   *     these packages have their names kept in Proguard/R8 obfuscation as well.
   */
  default Collection<String> ignorablePackagePrefixes() {
    return Collections.emptyList();
  }

  /**
   * Callbacks to handle {@link Flowable} and {@link Subscriber}.
   *
   * @param flowable the source flowable.
   * @param subscriber the source subscriber.
   * @return possible decorated or unpacked observer.
   */
  default Subscriber handle(Flowable flowable, Subscriber subscriber) {
    return subscriber;
  }

  /**
   * Callbacks to handle {@link Observable} and {@link Observer}.
   *
   * @param observable the source observable.
   * @param observer the source observer.
   * @return possible decorated or unpacked observer.
   */
  default Observer handle(Observable observable, Observer observer) {
    return observer;
  }

  /**
   * Callbacks to handle {@link Maybe} and {@link MaybeObserver}.
   *
   * @param maybe the source maybe.
   * @param observer the source observer.
   * @return possible decorated or unpacked observer.
   */
  default MaybeObserver handle(Maybe maybe, MaybeObserver observer) {
    return observer;
  }

  /**
   * Callbacks to handle {@link Single} and {@link SingleObserver}.
   *
   * @param single the source single.
   * @param observer the source observer.
   * @return possible decorated or unpacked observer.
   */
  default SingleObserver handle(Single single, SingleObserver observer) {
    return observer;
  }

  /**
   * Callbacks to handle {@link Completable} and {@link CompletableObserver}.
   *
   * @param completable the source completable.
   * @param observer the source observer.
   * @return possible decorated or unpacked observer.
   */
  default CompletableObserver handle(Completable completable, CompletableObserver observer) {
    return observer;
  }
}
