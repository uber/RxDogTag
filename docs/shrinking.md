## Proguard/R8

In order to correctly identify which line is the `subscribe()` line, RxDogTag requires keeping the names of 
any types in `io.reactivex` or `com.uber.rxdogtag` packages. This doesn't prevent shrinking unused
types, and as these are open source projects we don't think keeping these public risks any sort of 
secret sauce. Keeping names has a negligible impact on APK size as well. If this is an issue for you
though, then RxDogTag is probably not the right solution for your project.

RxDogTag ships with custom `rxdogtag.pro` rules in the jar resources to handle this automatically.