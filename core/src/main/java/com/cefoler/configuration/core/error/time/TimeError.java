package com.cefoler.configuration.core.error.time;

public abstract class TimeError extends Error {

  private static final long serialVersionUID = -4945958580121158979L;

  protected TimeError() {
  }

  protected TimeError(final String error) {
    super(error);
  }

  protected TimeError(final Throwable cause) {
    super(cause);
  }

  protected TimeError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
