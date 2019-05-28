Changelog
=========

Version 0.2.0
-------------

_2019-05-14_

**New: Builder-based API for configuration**

RxDogTag now uses a builder API for configuration. Currently this includes the existing `ObserverHandler`
 and package whitelisting, as well as a new configuration to optionally disable stacktrace annotations.
 
```java
RxDogTag.builder()
    .disableAnnotations()
    .addObserverHandlers(...)
    .addIgnoredPackages(...)
    .configureWith(...) // For other custom AutoDispose.Configurers
    .install();
```

Note: No-config `RxDogTag.install()` still exists, but is now just a proxy to 
`RxDogTag.builder().install()`

Breaking changes: 
* `ObserverHandler` no longer handles package whitelisting, as this is now moved to 
the builder API.
* The AutoDispose artifact now uses the builder API's `configureWith` support, and 
`AutoDisposeObserverHandler` is now just a package-private implementation detail.

```java
RxDogTag.builder()
    .configureWith(AutoDisposeConfigurer::configure)
    .install();
```

**New: Inferred subscribe point is now the first element in the stacktrace.**

After discussions with others in the community, the inferred subscribe point is now the first element
in the stacktrace for better grouping with crash reporters (which may have otherwise accidentally grouped
the stacktrace header annotations as the "same" crash). This plus some arrow characters means the stacktraces
look like this:

```
io.reactivex.exceptions.OnErrorNotImplementedException: The mapper function returned a null value.

Caused by: java.lang.NullPointerException: The mapper function returned a null value.
	at com.uber.anotherpackage.ReadMeExample.complex(ReadMeExample.java:55)
	at [[ ↑↑ Inferred subscribe point ↑↑ ]].(:0)
	at [[ ↓↓ Original trace ↓↓ ]].(:0)
	at io.reactivex.internal.functions.ObjectHelper.requireNonNull(ObjectHelper.java:39)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:57)
	at io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver.onNext(ObservableSubscribeOn.java:58)
	at io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable.run(ObservableScalarXMap.java:248)
	// ... and so on
```



Version 0.1.0
-------------

_2019-04-09_

Initial release!

