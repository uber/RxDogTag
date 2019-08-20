package com.uber.rxdogtag;

import io.reactivex.exceptions.OnErrorNotImplementedException;

/**
 * A marker type to indicate that RxDogTag's should pass the decorated stacktrace to
 * {@link #onError(Throwable)}. Note that this will always be tried directly, and no guarded
 * delegate behavior will be attempted even if
 * {@link RxDogTag.Builder#guardObserverCallbacks(boolean)} is enabled in configuration.
 *
 * <p><em>NOTE:</em> RxDogTag exceptions are always
 * {@link OnErrorNotImplementedException OnErrorNotImplementedExceptions}, as these have special
 * behavior as an escape hatch in RxJava internals. This exception will have no "cause" property if
 * the original exception was not already an {@link OnErrorNotImplementedException}. If it was,
 * which is unusual, it is reused with its original cause (if any) and has its stacktrace modified.
 */
public interface RxDogTagTaggedExceptionReceiver extends RxDogTagErrorReceiver {

}
