package com.cefoler.configuration.error.thread.impl;

import com.cefoler.configuration.error.thread.ThreadError;

public class AsyncError extends ThreadError {

  private static final long serialVersionUID = -5062236526580018580L;

  public AsyncError() {
  }

  public AsyncError(final String error) {
    super(error);
  }

  public AsyncError(final Throwable cause) {
    super(cause);
  }

  public AsyncError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
