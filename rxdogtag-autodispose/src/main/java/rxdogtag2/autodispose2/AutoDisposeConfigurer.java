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

import autodispose2.AutoDispose;
import java.util.Collections;
import java.util.Set;
import rxdogtag2.ObserverHandler;
import rxdogtag2.RxDogTag;

/**
 * Configures an {@link RxDogTag.Builder} with:
 *
 * <ul>
 *   <li>A {@link ObserverHandler} that supports handling AutoDispose's decorating observers to
 *       retrieve their underlying delegate observers.
 *   <li>Ignored packages.
 * </ul>
 *
 * <p>Usage: Configure with {@link #configure(RxDogTag.Builder)}.
 */
public final class AutoDisposeConfigurer {

  private AutoDisposeConfigurer() {}

  private static final Set<String> IGNORE_PACKAGES =
      Collections.singleton(
          // "com.uber.autodispose"
          AutoDispose.class.getPackage().getName());

  public static void configure(RxDogTag.Builder builder) {
    builder
        .addObserverHandlers(AutoDisposeObserverHandler.INSTANCE)
        .addIgnoredPackages(IGNORE_PACKAGES);
  }
}
