/*
 * Copyright (C) 2019. Uber Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
