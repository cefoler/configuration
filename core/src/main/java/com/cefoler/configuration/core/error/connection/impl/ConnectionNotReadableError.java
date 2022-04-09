package com.cefoler.configuration.core.error.connection.impl;

import com.cefoler.configuration.core.error.connection.ConnectionError;

public class ConnectionNotReadableError extends ConnectionError {

  private static final long serialVersionUID = -5620886856988011331L;

  public ConnectionNotReadableError() {
  }

  public ConnectionNotReadableError(final String error) {
    super(error);
  }

  public ConnectionNotReadableError(final Throwable cause) {
    super(cause);
  }

  public ConnectionNotReadableError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
