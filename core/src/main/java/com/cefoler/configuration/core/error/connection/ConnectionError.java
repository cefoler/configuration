package com.cefoler.configuration.core.error.connection;

public abstract class ConnectionError extends Error {

  private static final long serialVersionUID = 761218366046168806L;

  protected ConnectionError() {
  }

  protected ConnectionError(final String error) {
    super(error);
  }

  protected ConnectionError(final Throwable cause) {
    super(cause);
  }

  protected ConnectionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
