package com.cefoler.configuration.exception.unchecked.server;

public abstract class ServerException extends RuntimeException {

  private static final long serialVersionUID = 6433996533768350813L;

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
