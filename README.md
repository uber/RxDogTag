# RxDogTag

RxDogTag is a utility to tag originating subscribe points in RxJava 2 observers, with the goal of 
surfacing their subscribe locations for error reporting/investigation later in the event of an unhandled
error. This is _only_ for RxJava observers that do not implement `onError()`.

## Download

If you're targeting RxJava 2:

[![Maven Central](https://img.shields.io/maven-central/v/com.uber.rxdogtag/rxdogtag.svg)](https://mvnrepository.com/artifact/com.uber.rxdogtag/rxdogtag)

```gradle
implementation("com.uber.rxdogtag:rxdogtag:x.y.z")
```

If you're targeting RxJava 3:

[![Maven Central](https://img.shields.io/maven-central/v/com.uber.rxdogtag2/rxdogtag.svg)](https://mvnrepository.com/artifact/com.uber.rxdogtag2/rxdogtag)

```gradle
implementation("com.uber.rxdogtag2:rxdogtag:x.y.z")
```

# Setup

Install early in your application lifecycle via `RxDogTag.install()`. This will install the necessary
hooks in `RxJavaPlugins`. Note that these will replace any existing plugins at the hooks it uses. See 
the [JavaDoc](https://uber.github.io/RxDogTag/0.x/rxdogtag/com.uber.rxdogtag/-rx-dog-tag/install/) for full details of which plugins it uses.

## Example

Consider the following classic RxJava error:

```java
Observable.range(0, 10)
    .subscribeOn(Schedulers.io())
    .map(i -> null)
    .subscribe();
```

This is a fairly common case in RxJava concurrency. Without tagging, this yields the following trace:

```
io.reactivex.exceptions.OnErrorNotImplementedException: The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | The mapper function returned a null value.
	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:704)
	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:701)
	at io.reactivex.internal.observers.LambdaObserver.onError(LambdaObserver.java:77)
	at io.reactivex.internal.observers.BasicFuseableObserver.onError(BasicFuseableObserver.java:100)
	at io.reactivex.internal.observers.BasicFuseableObserver.fail(BasicFuseableObserver.java:110)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:59)
	at io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver.onNext(ObservableSubscribeOn.java:58)
	at io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable.run(ObservableScalarXMap.java:248)
	at io.reactivex.internal.operators.observable.ObservableJust.subscribeActual(ObservableJust.java:35)
	at io.reactivex.Observable.subscribe(Observable.java:12090)
	at io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeTask.run(ObservableSubscribeOn.java:96)
	at io.reactivex.Scheduler$DisposeTask.run(Scheduler.java:578)
	at io.reactivex.internal.schedulers.ScheduledRunnable.run(ScheduledRunnable.java:66)
	at io.reactivex.internal.schedulers.ScheduledRunnable.call(ScheduledRunnable.java:57)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$201(ScheduledThreadPoolExecutor.java:180)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:293)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
Caused by: java.lang.NullPointerException: The mapper function returned a null value.
	at io.reactivex.internal.functions.ObjectHelper.requireNonNull(ObjectHelper.java:39)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:57)
	... 14 more
```

This is basically impossible to investigate if you're looking at a crash report from the wild.

Now the same error with RxDogTag enabled:

```
io.reactivex.exceptions.OnErrorNotImplementedException: The mapper function returned a null value.

Caused by: java.lang.NullPointerException: The mapper function returned a null value.
	at anotherpackage.ReadMeExample.complex(ReadMeExample.java:55)
	at [[ ↑↑ Inferred subscribe point ↑↑ ]].(:0)
	at [[ ↓↓ Original trace ↓↓ ]].(:0)
	at io.reactivex.internal.functions.ObjectHelper.requireNonNull(ObjectHelper.java:39)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:57)
	at io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver.onNext(ObservableSubscribeOn.java:58)
	at io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable.run(ObservableScalarXMap.java:248)
	at io.reactivex.internal.operators.observable.ObservableJust.subscribeActual(ObservableJust.java:35)
	at io.reactivex.Observable.subscribe(Observable.java:12090)
	at io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeTask.run(ObservableSubscribeOn.java:96)
	at io.reactivex.Scheduler$DisposeTask.run(Scheduler.java:578)
	at io.reactivex.internal.schedulers.ScheduledRunnable.run(ScheduledRunnable.java:66)
	at io.reactivex.internal.schedulers.ScheduledRunnable.call(ScheduledRunnable.java:57)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$201(ScheduledThreadPoolExecutor.java:180)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:293)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
```

Now we have the example subscribe line at `ReadMeExample.java:55`. It may not be a silver bullet to 
root-causing why the exception occurred, but at least you know where it's emanating from.

The subscribe line reported should also retrace and group well for crash reporting. As we use our own 
in-house reporter though, we're very open to feedback on how this can be improved for other solutions.

More examples and details can be found in the [wiki](https://github.com/uber/RxDogTag/wiki)

## Configuration

RxDogTag has an alternative `RxDogTag.builder()` API to facilitate added configuration, such as annotation
control, stacktrace element location, and more.

### Custom handlers

In the event of custom observers that possibly decorate other observer types, this information can
be passed to RxDogTag via the `ObserverHandler` interface. This interface can be used to unwrap 
these custom observers to reveal their delegates and their potential behavior. Install these via
the `RxDogTag.Builder#addObserverHandlers(...)` overloads that accept handlers.

### Ignored packages

RxDogTag needs to ignore certain packages (such as its own or RxJava's) when inspecting stack traces
to deduce the subscribe point. You can add other custom ones via `RxDogTag.Builder#addIgnoredPackages(...)`.

### AutoDispose support

AutoDispose is a library for automatically disposing streams, and works via its own decorating observers 
under the hood. AutoDispose can work with RxDogTag via its `delegateObserver()` APIs on the AutoDisposingObserver
interfaces. Support for this is available via separate `rxdogtag-autodispose` artifact and its 
`AutoDisposeObserverHandler` singleton instance.

```java
RxDogTag.builder()
    .configureWith(AutoDisposeConfigurer::configure)
    .install();
```

If you're targeting RxJava 2:

[![Maven Central](https://img.shields.io/maven-central/v/com.uber.rxdogtag/rxdogtag-autodispose.svg)](https://mvnrepository.com/artifact/com.uber.rxdogtag/rxdogtag-autodispose)

```gradle
implementation("com.uber.rxdogtag:rxdogtag-autodispose:x.y.z")
```

If you're targeting RxJava 3:

[![Maven Central](https://img.shields.io/maven-central/v/com.uber.rxdogtag2/rxdogtag-autodispose.svg)](https://mvnrepository.com/artifact/com.uber.rxdogtag2/rxdogtag-autodispose)

```gradle
implementation("com.uber.rxdogtag2:rxdogtag-autodispose:x.y.z")
```

## Development

Javadocs for the most recent release can be found here: https://uber.github.io/RxDogTag/0.x/rxdogtag/com.uber.rxdogtag/

Snapshots of the development version are available in [Sonatype's snapshots repository][snapshots].

License
-------

    Copyright (C) 2019 Uber Technologies

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 [snapshots]: https://oss.sonatype.org/content/repositories/snapshots/com/uber/rxdogtag/
