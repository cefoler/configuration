package com.cefoler.configuration.core.exception.unchecked.time;

public abstract class TimeException extends RuntimeException {

  private static final long serialVersionUID = 7381064349343580256L;

  protected TimeException() {
  }

  protected TimeException(final String error) {
    super(error);
  }

  protected TimeException(final Throwable cause) {
    super(cause);
  }

  protected TimeException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
