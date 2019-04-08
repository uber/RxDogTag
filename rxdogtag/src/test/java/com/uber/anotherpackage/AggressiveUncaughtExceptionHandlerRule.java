package com.uber.anotherpackage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * A {@link TestWatcher} used to install an aggressive default {@link UncaughtExceptionHandler}
 * similar to the one found on Android. No exceptions should escape from RxDogTag that might cause
 * apps to be killed or tests to fail on Android.
 */
public final class AggressiveUncaughtExceptionHandlerRule extends TestWatcher {

  private UncaughtExceptionHandler oldDefaultUncaughtExceptionHandler;
  private Description lastTestStarted;
  private final Map<Throwable, String> exceptions = new ConcurrentHashMap<>();

  @Override
  protected void starting(Description description) {
    System.err.println("Installing aggressive uncaught exception handler");
    oldDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(
        (thread, throwable) -> {
          StringWriter errorText = new StringWriter(256);
          errorText.append("Uncaught exception in RxDogTag thread \"");
          errorText.append(thread.getName());
          errorText.append("\"\n");
          throwable.printStackTrace(new PrintWriter(errorText));
          errorText.append("\n");
          if (lastTestStarted != null) {
            errorText.append("Last test to start was: ");
            errorText.append(lastTestStarted.getDisplayName());
            errorText.append("\n");
          }
          System.err.print(errorText.toString());

          exceptions.put(throwable, lastTestStarted.getDisplayName());
        });
  }

  @Override
  public Statement apply(Statement base, Description description) {
    lastTestStarted = description;
    return super.apply(base, description);
  }

  @Override
  protected void finished(Description description) {
    Thread.setDefaultUncaughtExceptionHandler(oldDefaultUncaughtExceptionHandler);
    System.err.println("Uninstalled aggressive uncaught exception handler");

    if (!exceptions.isEmpty()) {
      sneakyThrow(exceptions.keySet().iterator().next());
    }
  }

  private static <T extends Throwable> void sneakyThrow(Throwable t) throws T {
    //noinspection unchecked
    throw (T) t;
  }
}
