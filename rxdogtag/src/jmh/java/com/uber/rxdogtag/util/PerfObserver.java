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
package com.uber.rxdogtag.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.openjdk.jmh.infra.Blackhole;

public final class PerfObserver implements Observer<Object> {
  final Blackhole bh;

  public PerfObserver(Blackhole bh) {
    this.bh = bh;
  }

  @Override
  public void onSubscribe(Disposable d) {
    bh.consume(d);
  }

  @Override
  public void onNext(Object value) {
    bh.consume(value);
  }

  @Override
  public void onError(Throwable e) {
    bh.consume(e);
  }

  @Override
  public void onComplete() {}
}
