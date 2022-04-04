package com.cefoler.configuration.error.thread.impl;

import com.cefoler.configuration.error.thread.ThreadError;

public class InvalidThreadError extends ThreadError {

  private static final long serialVersionUID = -3448014345804249844L;

  public InvalidThreadError() {
  }

  public InvalidThreadError(final String error) {
    super(error);
  }

  public InvalidThreadError(final Throwable cause) {
    super(cause);
  }

  public InvalidThreadError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
