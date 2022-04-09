package com.cefoler.configuration.core.exception.unchecked.connection;

public abstract class ConnectionException extends RuntimeException {

  private static final long serialVersionUID = 6198070365247475266L;

  protected ConnectionException() {
  }

  protected ConnectionException(final String error) {
    super(error);
  }

  protected ConnectionException(final Throwable cause) {
    super(cause);
  }

  protected ConnectionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
