package com.cefoler.configuration.core.exception.unchecked.thread.impl;

import com.cefoler.configuration.core.exception.unchecked.thread.ThreadException;

public class AsyncException extends ThreadException {

  private static final long serialVersionUID = 8532361912174275217L;

  public AsyncException() {
  }

  public AsyncException(final String error) {
    super(error);
  }

  public AsyncException(final Throwable cause) {
    super(cause);
  }

  public AsyncException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
