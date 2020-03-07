Changelog
=========

Version 1.0.0
-------------

_2020_03_07_

* Stable release!
* This release is identical in functionality to 0.3.0.
* Various dependency upgrades. ([#55](https://github.com/uber/RxDogTag/pull/55))
```
RxJava 2.2.18
AutoDispose 1.4.0
Android Benchmark 1.0.0
```

Version 0.3.0
-------------

_2019-09-23_

**New: Builder option to disable guarded observer callbacks. [#43](https://github.com/uber/RxDogTag/pull/43)**

By default, RxDogTag will try/catch every onNext/onSuccess/onComplete calls in its observers to try to catch exceptions
and modify the trace before they're handed to the (unhandled) onError. If you only want to handle
upstream errors, you can disable this behavior in the builder now. This can be useful in hot paths 
where performance is more of a concern.

```java
RxDogTag.builder()
    .guardObserverCallbacks(false)
    .install();
```

**New: ErrorReceivers API. [#45](https://github.com/uber/RxDogTag/pull/45)**

For users that have custom onError() implementations but want to supplement it with RxDogTag, there are
two new APIs to help with this.

`RxDogTagErrorReceiver` is a simple interface that your custom observer can implement to indicate that
it wants its onError() method to be called with the aforementioned guarded observer callback. Note 
however that modified tagged exceptions in this case will be delivered to `RxJavaPlugins.onError()`.

`RxDogTagTaggedExceptionReceiver` is an interface that your custom observer can implement to indicate
that it wants its onError() called with the modified tagged exception. This is useful if you have
custom onError() handling but want to use/report RxDogTag's tagged information for something custom.

**Misc**
- Proguard file has been tuned to use the more idiomatic `-keeppackagenames`. [#29](https://github.com/uber/RxDogTag/pull/29)
- We have a website now! https://uber.github.io/RxDogTag
- We've been doing a lot of work to add thorough benchmarks for RxDogTag. A dedicated section can be 
found on the website at https://uber.github.io/RxDogTag/benchmark.

Special thanks to [@emartynov](https://github.com/emartynov) for contributing to this release!

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

