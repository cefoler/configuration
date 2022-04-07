package com.cefoler.configuration.model.lambda.runnable;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;

@FunctionalInterface
public interface ThrowRunnable<T extends Exception> {

  void run() throws T;

  static Runnable convert(final ThrowRunnable<?> runnable) {
    return () -> {
      try {
        runnable.run();
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

}
