# We keep these in order for DogTagObservers to properly work and resolve entries in each of these packages
-keepnames class com.uber.rxdogtag**
-keepnames class io.reactivex**

# R8 may inline subscribe() calls entirely to their call-sites, which breaks RxDogTag's tagging
# While this is sort of a cardinal sin of libraries to do this, RxDogTag is only a few classes and
# incredibly small, so we claim this is a small price to pay.
-keep class com.uber.rxdogtag.** { *; }
-keepclassmembers class io.reactivex.** {
  *** subscribe(...);
}
