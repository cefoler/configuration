package com.cefoler.configuration.error.connection.impl;

import com.cefoler.configuration.error.connection.ConnectionError;

public class ConnectionTimeoutError extends ConnectionError {

  private static final long serialVersionUID = -3996496629771562510L;

  public ConnectionTimeoutError() {
  }

  public ConnectionTimeoutError(final String error) {
    super(error);
  }

  public ConnectionTimeoutError(final Throwable cause) {
    super(cause);
  }

  public ConnectionTimeoutError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
