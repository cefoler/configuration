package com.cefoler.configuration.core.error.server;

public abstract class ServerError extends Error {

  private static final long serialVersionUID = 4879140605675336802L;

  protected ServerError() {
  }

  protected ServerError(final String error) {
    super(error);
  }

  protected ServerError(final Throwable cause) {
    super(cause);
  }

  protected ServerError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
