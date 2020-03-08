## Examples

### Simple

Consider the following trivial case of emitting an error with 
no error handling.

```java
Observable.error(new RuntimeException("Unhandled error!"))
    .subscribe();
```

This results in a stacktrace like this:

```jvm
io.reactivex.exceptions.OnErrorNotImplementedException: The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | Unhandled error!

	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:704)
	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:701)
	at io.reactivex.internal.observers.LambdaObserver.onError(LambdaObserver.java:77)
	at io.reactivex.internal.disposables.EmptyDisposable.error(EmptyDisposable.java:63)
	at io.reactivex.internal.operators.observable.ObservableError.subscribeActual(ObservableError.java:38)
	at io.reactivex.Observable.subscribe(Observable.java:12090)
	at io.reactivex.Observable.subscribe(Observable.java:12076)
	at io.reactivex.Observable.subscribe(Observable.java:11954)
	at anotherpackage.ReadMeExample.simpleSubscribe(ReadMeExample.java:26)
	<collapsed internal calls>
Caused by: java.lang.RuntimeException: Unhandled error!
	at anotherpackage.ReadMeExample.simpleSubscribe(ReadMeExample.java:25)
	... 25 more
```

Now let's look at the same example with tagging enabled:

```
io.reactivex.exceptions.OnErrorNotImplementedException: Unhandled error!

Caused by: java.lang.RuntimeException: Unhandled error!
	at anotherpackage.ReadMeExample.simpleSubscribe(ReadMeExample.java:26)
	at [[ ↑↑ Inferred subscribe point ↑↑ ]].(:0)
	at [[ ↓↓ Original trace ↓↓ ]].(:0)
	at anotherpackage.ReadMeExample.simpleSubscribe(ReadMeExample.java:25)
	... 25 more
```

In the simple case, there's not much added benefit since the execution was synchronous and single threaded,
but you can see original trace has now been updated to indicate the exact line that `subscribe()` was called.
In this case: `ReadMeExample.java:26`. 

To reduce noise - RxDogTag will wrap the original cause in a synthetic
`OnErrorNotImplementedException`. This uses the original cause's message and doesn't fill in the 
stacktrace as it's irrelevant to the trace.

### Threading

Consider a more complex example with threading:

```java
Observable.just(1)
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

Yikes! This is basically impossible to investigate if you're looking at a crash report from the wild.

Now the same trace with tagging enabled:

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

### Delegate callbacks

Let's look at one more example. This is similar to the previous, but instead of the exception occurring
upstream in the chain, the exception occurs in one of the observer callbacks; in this case - `onNext`.

```java
Observable.just(1)
    .subscribeOn(Schedulers.io())
    .subscribe(i -> throwSomething());

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
Caused by: java.lang.RuntimeException: Unhandled error!
	at anotherpackage.ReadMeExample.throwSomething(ReadMeExample.java:68)
	at anotherpackage.ReadMeExample.lambda$complexDelegate$1(ReadMeExample.java:63)
	at io.reactivex.internal.observers.LambdaObserver.onNext(LambdaObserver.java:63)
	... 14 more
```

Similar to the first example, this isn't terrible to root-cause. `onNext` is throwing a traceable 
exception in this trivial case.

With tagging enabled:

```
io.reactivex.exceptions.OnErrorNotImplementedException: The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | Unhandled error!

	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:704)
	at io.reactivex.internal.functions.Functions$OnErrorMissingConsumer.accept(Functions.java:701)
	at io.reactivex.internal.observers.LambdaObserver.onError(LambdaObserver.java:77)
	at io.reactivex.internal.observers.LambdaObserver.onNext(LambdaObserver.java:67)
	at rxdogtag2.DogTagObserver.lambda$onNext$3(DogTagObserver.java:53)
	at rxdogtag2.RxDogTag.guardedDelegateCall(RxDogTag.java:262)
	at rxdogtag2.DogTagObserver.onNext(DogTagObserver.java:53)
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
Caused by: java.lang.RuntimeException: Unhandled error!
	at anotherpackage.ReadMeExample.complexDelegate(ReadMeExample.java:63)
	at [[ ↑↑ Inferred subscribe point ↑↑ ]].(:0)
	at [[ Originating callback: onNext ]].(:0)
	at [[ ↓↓ Original trace ↓↓ ]].(:0)
	at anotherpackage.ReadMeExample.throwSomething(ReadMeExample.java:68)
	at anotherpackage.ReadMeExample.lambda$complexDelegate$1(ReadMeExample.java:63)
	at io.reactivex.internal.observers.LambdaObserver.onNext(LambdaObserver.java:63)
	... 17 more
```

Now we're given added context that this occurred in the `onNext` callback according to `[[ Originating callback: onNext ]]`
at the `subscribe()` call at `ReadMeExample.java:63`. This callback handling is supported for all the
standard callbacks and will report the correct name for each (`onSuccess`, `onComplete`, etc).