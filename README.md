# RxDogTag

RxDogTag is a utility to tag originating subscribe points in RxJava 2 observers, with the goal of 
surfacing their subscribe locations for error reporting/investigation later in the event of an unhandled
error. This is _only_ for RxJava observers that do not implement `onError()`.

## Download

[![Maven Central](https://img.shields.io/maven-central/v/com.uber.rxdogtag/rxdogtag.svg)](https://mvnrepository.com/artifact/com.uber.rxdogtag/rxdogtag)

```gradle
implementation("com.uber.rxdogtag:rxdogtag:x.y.z")
```

# Setup

Install early in your application lifecycle via `RxDogTag.install()`. This will install the necessary
hooks in `RxJavaPlugins`.

TBD: custom handlers

## Examples

For a simple synchronous error, it's usually not difficult to diagnose its origin. It does help to 
demonstrate RxDogTag in action though. 

### Simple

Consider the following trivial case of emitting an error with 
no error handling.

```java
Observable.error(new RuntimeException("Unhandled error!"))
    .subscribe();
```

This results in a stacktrace like this:

```
io.reactivex.exceptions.OnErrorNotImplementedException: The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | Unhandled error!

	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:704)
	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:701)
	at io.reactivex.internal.observers.LambdaObserver.onError(LambdaObserver.java:77)
	at io.reactivex.internal.disposables.EmptyDisposable.error(EmptyDisposable.java:63)
	at io.reactivex.internal.operators.observable.ObservableError.subscribeActual(ObservableError.java:38)
	at io.reactivex.Observable.subscribe(Observable.java:12090)
	at io.reactivex.Observable.subscribe(Observable.java:12076)
	at io.reactivex.Observable.subscribe(Observable.java:11954)
	at com.uber.anotherpackage.ReadMeExample.simpleSubscribe(ReadMeExample.java:26)
	<collapsed internal calls>
Caused by: java.lang.RuntimeException: Unhandled error!
	at com.uber.anotherpackage.ReadMeExample.simpleSubscribe(ReadMeExample.java:25)
	... 25 more
```

Now let's look at the same example with tagging enabled:

```
io.reactivex.exceptions.OnErrorNotImplementedException: Unhandled error!

Caused by: java.lang.RuntimeException: Unhandled error!
	at [[ Inferred subscribe point ]].(:0)
	at com.uber.anotherpackage.ReadMeExample.simpleSubscribe(ReadMeExample.java:26)
	at [[ Original trace ]].(:0)
	at com.uber.anotherpackage.ReadMeExample.simpleSubscribe(ReadMeExample.java:25)
	... 25 more
```

In the simple case, there's not much added benefit since the execution was synchronous and single threaded,
but you can see original trace has now been updated to indicate the exact line that `subscribe()` was called.
In this case: `ReadMeExample.java:26`. 

To reduce noise - RxDogTag will wrap the original cause in a synthetic
`OnErrorNotImplementedException`. This uses the original cause's message and doesn't fill in the 
stacktrace as it's irrelevant to the trace.

### Complex + Threading

Consider a more complex example with threading:

```java
CountDownLatch latch = new CountDownLatch(1);
Observable.range(0, 10)
    .subscribeOn(Schedulers.io())
    .map(i -> i + 1)
    .hide()
    .map(i -> i + 1)
    .hide()
    .map(i -> i + 1)
    .hide()
    .<Integer>map(i -> null)
    .observeOn(Schedulers.io())
    .subscribe(i -> latch.countDown());
latch.await();
```

Without tagging, this yields the following trace:

```
io.reactivex.exceptions.OnErrorNotImplementedException: The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | The mapper function returned a null value.

	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:704)
	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:701)
	at io.reactivex.internal.observers.LambdaObserver.onError(LambdaObserver.java:77)
	at io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver.checkTerminated(ObservableObserveOn.java:281)
	at io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver.drainNormal(ObservableObserveOn.java:172)
	at io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver.run(ObservableObserveOn.java:255)
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
	at io.reactivex.internal.operators.observable.ObservableHide$HideDisposable.onNext(ObservableHide.java:67)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:62)
	at io.reactivex.internal.operators.observable.ObservableHide$HideDisposable.onNext(ObservableHide.java:67)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:62)
	at io.reactivex.internal.operators.observable.ObservableHide$HideDisposable.onNext(ObservableHide.java:67)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:62)
	at io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver.onNext(ObservableSubscribeOn.java:58)
	at io.reactivex.internal.operators.observable.ObservableRange$RangeDisposable.run(ObservableRange.java:64)
	at io.reactivex.internal.operators.observable.ObservableRange.subscribeActual(ObservableRange.java:35)
	at io.reactivex.Observable.subscribe(Observable.java:12090)
	at io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeTask.run(ObservableSubscribeOn.java:96)
	at io.reactivex.Scheduler$DisposeTask.run(Scheduler.java:578)
	... 8 more
```

Yikes! This is basically impossible to investigate if you're looking at a crash report from the wild.

Now the same trace with tagging enabled:

```
io.reactivex.exceptions.OnErrorNotImplementedException: The mapper function returned a null value.

Caused by: java.lang.NullPointerException: The mapper function returned a null value.
	at [[ Inferred subscribe point ]].(:0)
	at com.uber.anotherpackage.ReadMeExample.complex(ReadMeExample.java:43)
	at [[ Original trace ]].(:0)
	at io.reactivex.internal.functions.ObjectHelper.requireNonNull(ObjectHelper.java:39)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:57)
	at io.reactivex.internal.operators.observable.ObservableHide$HideDisposable.onNext(ObservableHide.java:67)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:62)
	at io.reactivex.internal.operators.observable.ObservableHide$HideDisposable.onNext(ObservableHide.java:67)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:62)
	at io.reactivex.internal.operators.observable.ObservableHide$HideDisposable.onNext(ObservableHide.java:67)
	at io.reactivex.internal.operators.observable.ObservableMap$MapObserver.onNext(ObservableMap.java:62)
	at io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver.onNext(ObservableSubscribeOn.java:58)
	at io.reactivex.internal.operators.observable.ObservableRange$RangeDisposable.run(ObservableRange.java:64)
	at io.reactivex.internal.operators.observable.ObservableRange.subscribeActual(ObservableRange.java:35)
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

Now we have the example subscribe line at `ReadMeExample.java:43`. It may not be a silver bullet to 
root-causing why the exception occurred, but at least you know where it's emanating from.

### Delegate callbacks

Let's look at one more example. This is similar to the previous, but instead of the exception occurring
upstream in the chain, the exception occurs in one of the observer callbacks; in this case - `onNext`.

```java
CountDownLatch latch = new CountDownLatch(1);
Observable.range(0, 10)
    .subscribeOn(Schedulers.io())
    .map(i -> i + 1)
    .hide()
    .map(i -> i + 1)
    .hide()
    .map(i -> i + 1)
    .hide()
    .observeOn(Schedulers.io())
    .subscribe(i -> throwSomething());
latch.await();

private void throwSomething() {
  throw new RuntimeException("Unhandled error!");
}
```

Without tagging, this yields the following trace:

```
io.reactivex.exceptions.OnErrorNotImplementedException: The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | Unhandled error!
	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:704)
	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:701)
	at io.reactivex.internal.observers.LambdaObserver.onError(LambdaObserver.java:77)
	at io.reactivex.internal.observers.LambdaObserver.onNext(LambdaObserver.java:67)
	at io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver.drainNormal(ObservableObserveOn.java:201)
	at io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver.run(ObservableObserveOn.java:255)
	at io.reactivex.internal.schedulers.ScheduledRunnable.run(ScheduledRunnable.java:66)
	at io.reactivex.internal.schedulers.ScheduledRunnable.call(ScheduledRunnable.java:57)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$201(ScheduledThreadPoolExecutor.java:180)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:293)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
Caused by: java.lang.RuntimeException: Unhandled error!
	at com.uber.anotherpackage.ReadMeExample.throwSomething(ReadMeExample.java:65)
	at com.uber.anotherpackage.ReadMeExample.lambda$complexDelegate$8(ReadMeExample.java:60)
	at io.reactivex.internal.observers.LambdaObserver.onNext(LambdaObserver.java:63)
	... 10 more
```

Similar to the first example, this isn't terrible to root-cause. `onNext` is throwing a traceable exception.

With tagging enabled:

```
io.reactivex.exceptions.OnErrorNotImplementedException: Unhandled error!
Caused by: java.lang.RuntimeException: Unhandled error!
	at [[ Originating callback: onNext ]].(:0)
	at [[ Inferred subscribe point ]].(:0)
	at com.uber.anotherpackage.ReadMeExample.complexDelegate(ReadMeExample.java:60)
	at [[ Original trace ]].(:0)
	at com.uber.anotherpackage.ReadMeExample.throwSomething(ReadMeExample.java:65)
	at com.uber.anotherpackage.ReadMeExample.lambda$complexDelegate$8(ReadMeExample.java:60)
	at io.reactivex.internal.observers.LambdaObserver.onNext(LambdaObserver.java:63)
	at com.uber.rxdogtag.DogTagObserver.lambda$onNext$3(DogTagObserver.java:53)
	at com.uber.rxdogtag.RxDogTag.guardedDelegateCall(RxDogTag.java:210)
	at com.uber.rxdogtag.DogTagObserver.onNext(DogTagObserver.java:53)
	at io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver.drainNormal(ObservableObserveOn.java:201)
	at io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver.run(ObservableObserveOn.java:255)
	at io.reactivex.internal.schedulers.ScheduledRunnable.run(ScheduledRunnable.java:66)
	at io.reactivex.internal.schedulers.ScheduledRunnable.call(ScheduledRunnable.java:57)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$201(ScheduledThreadPoolExecutor.java:180)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:293)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
```

Now we're given added context that this occurred in the `onNext` callback according to `[[ Originating callback: onNext ]]`
at the `subscribe()` call at `ReadMeExample.java:60`. This callback handling is supported for all the
standard callbacks and will report the correct name for each (`onSuccess`, `onComplete`, etc).

## Under the hood

This mechanism relies on a combination of `RxJavaPlugins`'s `on*Subscribe` hooks and 
`LambdaConsumerIntrospection`.

The onSubscribe hooks allow RxDogTag to inspect incoming Observers and, if no error handling is implemented
according to `LambdaConsumerIntrospection`, will wrap them in a custom decorating observer that records
the necessary tagging information via `Throwable` created at subscribe-time. This gives us all the information
needed later to report any errors. In the event of an error from upstream, the decorating observer will
synthesize a new stacktrace with the deduced `subscribe()` line.

The `Throwable` created at subscribe-time does incur a non-zero cost to create, but in practice we haven't
found this to be an issue. This mechanism is also lighter weight than assembly tracking, and more targeted
since it tells you exactly where to look. The idea is that usually hardest part is finding where the
error is happening, and not necessarily fixing it once you've found it.

More information on `LambdaConsumerIntrospection` can be found in its implementation PR: https://github.com/ReactiveX/RxJava/pull/5590

Decision tree:
```
-> Is the observer an instance of `LambdaConsumerIntrospection`?
  -> Does `hasCustomOnError()` return `false`?
    -> Decorate with a DogTag observer.
```

## AutoDispose support

AutoDispose is a library for automatically disposing streams, and works via its own decorating observers 
under the hood. AutoDispose can work with RxDogTag via its `delegateObserver()` APIs on the AutoDisposingObserver
interfaces.

TBD: First party autodispose artifact.

## Proguard/R8

In order to correctly identify which line is the `subscribe()` line, RxDogTag requires keeping the names of 
any types in `io.reactivex` or `com.uber.rxdogtag` packages. This doesn't prevent shrinking unused
types, and as these are open source projects we don't think keeping these public risks any sort of 
secret sauce. Keeping names has a negligible impact on APK size as well. If this is an issue for you
though, then RxDogTag is probably not the right solution for your project.

RxDogTag ships with custom `rxdogtag.pro` rules in the jar resources to handle this automatically.

TBD - custom handlers.

## TBD License
