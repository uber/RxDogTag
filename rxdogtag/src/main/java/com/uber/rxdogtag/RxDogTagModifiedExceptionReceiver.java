package com.uber.rxdogtag;

/**
 * A marker type to indicate that RxDogTag's should pass the decorated stacktrace to
 * {@link #onError(Throwable)}. Note that this will always be tried directly, and no guarded
 * delegate behavior will be attempted even if
 * {@link RxDogTag.Builder#guardObserverCallbacks(boolean)} is enabled in configuration.
 */
public interface RxDogTagModifiedExceptionReceiver extends RxDogTagErrorReceiver {

}
