package com.uber.anotherpackage;

import com.uber.rxdogtag.RxDogTag;
import io.reactivex.Observable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

/** This is the code for the README examples. Un-ignore to test yourself. */
@Ignore
public class ReadMeExample {

  @Rule public AggressiveUncaughtExceptionHandlerRule handlerRule = new AggressiveUncaughtExceptionHandlerRule();

  @After
  public void tearDown() {
    RxJavaPlugins.reset();
  }

  @Test
  public void simpleSubscribe() {
    RxDogTag.install();
    Observable.error(new RuntimeException("Unhandled error!"))
        .subscribe();
  }

  @Test
  public void complex() throws InterruptedException {
    RxDogTag.install();
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
    latch.await(1, TimeUnit.SECONDS);
  }

  @Test
  public void complexDelegate() throws InterruptedException {
    RxDogTag.install();
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
    latch.await(1, TimeUnit.SECONDS);
  }

  private void throwSomething() {
    throw new RuntimeException("Unhandled error!");
  }
}
