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

import com.uber.rxdogtag.RxDogTag;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Locale;

interface DogTagTest {

  /** This basically tests {@link RxDogTag#guardedDelegateCall}. See its doc for more details. */
  default void assertUnwrappedError(
      Throwable e,
      int expectedLineNumber,
      OnErrorNotImplementedException originalError,
      String delegateType) {
    assertThat(e).isInstanceOf(OnErrorNotImplementedException.class);
    assertThat(e).hasMessageThat().isEqualTo(originalError.getCause().getMessage());
    assertThat(e.getStackTrace()[0].getClassName())
        .isEqualTo(String.format(Locale.US, RxDogTag.STACK_ELEMENT_SOURCE_DELEGATE, delegateType));
    assertThat(e.getStackTrace()[1].getClassName()).isEqualTo(RxDogTag.STACK_ELEMENT_SOURCE_HEADER);
    assertThat(e.getStackTrace()[2].getFileName()).isEqualTo(getClass().getSimpleName() + ".java");
    assertThat(e.getStackTrace()[2].getLineNumber()).isEqualTo(expectedLineNumber);
    assertThat(e.getStackTrace()[3].getClassName()).isEqualTo(RxDogTag.STACK_ELEMENT_CAUSE_HEADER);
  }
}
