package com.cefoler.configuration.core.exception.checked.server;

public abstract class ServerException extends Exception {

  private static final long serialVersionUID = 2869051327029114158L;

  protected ServerException() {
  }

  protected ServerException(final String error) {
    super(error);
  }

  protected ServerException(final Throwable cause) {
    super(cause);
  }

  protected ServerException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
