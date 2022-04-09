package com.cefoler.configuration.core.error.thread.impl;

import com.cefoler.configuration.core.error.thread.ThreadError;

public class ThreadInterruptedError extends ThreadError {

  private static final long serialVersionUID = 3164826821086643373L;

  public ThreadInterruptedError() {
  }

  public ThreadInterruptedError(final String error) {
    super(error);
  }

  public ThreadInterruptedError(final Throwable cause) {
    super(cause);
  }

  public ThreadInterruptedError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
