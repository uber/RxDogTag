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
package com.uber.anotherpackage;

import static com.google.common.truth.Truth.assertThat;

import com.uber.rxdogtag.ObserverHandler;
import com.uber.rxdogtag.RxDogTag;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;
import org.junit.Test;

public final class ObserverHandlerDefaultsTest {

  private ObserverHandler handler = new ObserverHandler() {};

  @Test
  public void defaultsShouldReturnSameObserver() {
    // Using TestObserver out of convenience since it implements every Observer type.
    TestObserver<Integer> o = new TestObserver<>();
    TestSubscriber<Integer> s = new TestSubscriber<>();

    assertThat(handler.handle(Flowable.never(), s)).isSameInstanceAs(s);
    assertThat(handler.handle(Observable.never(), o)).isSameInstanceAs(o);
    assertThat(handler.handle(Maybe.never(), o)).isSameInstanceAs(o);
    assertThat(handler.handle(Single.never(), o)).isSameInstanceAs(o);
    assertThat(handler.handle(Completable.never(), o)).isSameInstanceAs(o);
  }

  /**
   * This is a weird but necessary tests. We have proguard configurations that depend on these
   * packages to have names kept in order for DogTagObservers to work their magic correctly.
   *
   * <p>In the event that this test fails, please update the proguard configurations with the new
   * package names. You will see something like this the bundled proguard config.
   *
   * <pre><code>
   *   -keeppackagenames io.reactivex**
   * </code></pre>
   *
   * <p>This should be updated with the new package name.
   */
  @Test
  public void verifyPackages() {
    checkPackage("Observable", "io.reactivex", Observable.class.getPackage().getName());
    checkPackage("RxDogTag", "com.uber.rxdogtag", RxDogTag.class.getPackage().getName());
  }

  private void checkPackage(String name, String expectedPackage, String actualPackage) {
    if (!actualPackage.equals(expectedPackage)) {
      throw new RuntimeException(
          "The package name for "
              + name
              + " has changed. Please "
              + "update this test and the proguard -keepnames configuration to properly keep the new "
              + "package It was \n\"-keepnames class "
              + expectedPackage
              + ".**\"\nbut should now "
              + "be\n\"-keepnames class "
              + actualPackage
              + ".**\"");
    }
  }
}
