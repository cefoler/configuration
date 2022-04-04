package com.cefoler.configuration.error.log;

public abstract class LogError extends Error {

  private static final long serialVersionUID = 1973602452596831962L;

  protected LogError() {
  }

  protected LogError(final String error) {
    super(error);
  }

  protected LogError(final Throwable cause) {
    super(cause);
  }

  protected LogError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
