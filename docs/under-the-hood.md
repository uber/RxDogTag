## Under the hood

More information on `LambdaConsumerIntrospection` can be found in its implementation PR: https://github.com/ReactiveX/RxJava/pull/5590

Decision tree:
```
-> Is the observer an instance of `LambdaConsumerIntrospection`?
  -> Does `hasCustomOnError()` return `false`?
    -> Decorate with a DogTag observer.
```