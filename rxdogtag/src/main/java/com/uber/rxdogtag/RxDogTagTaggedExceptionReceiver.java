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

import io.reactivex.exceptions.OnErrorNotImplementedException;

/**
 * A marker type to indicate that RxDogTag's should pass the decorated stacktrace to {@link
 * #onError(Throwable)}. Note that this will always be tried directly, and no guarded delegate
 * behavior will be attempted even if {@link RxDogTag.Builder#guardObserverCallbacks(boolean)} is
 * enabled in configuration.
 *
 * <p><em>NOTE:</em> RxDogTag exceptions are always {@link OnErrorNotImplementedException
 * OnErrorNotImplementedExceptions}, as these have special behavior as an escape hatch in RxJava
 * internals. This exception will have no "cause" property if the original exception was not already
 * an {@link OnErrorNotImplementedException}. If it was, which is unusual, it is reused with its
 * original cause (if any) and has its stacktrace modified.
 */
public interface RxDogTagTaggedExceptionReceiver extends RxDogTagErrorReceiver {}
