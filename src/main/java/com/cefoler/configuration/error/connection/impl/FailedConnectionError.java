package com.cefoler.configuration.error.connection.impl;

import com.cefoler.configuration.error.connection.ConnectionError;

public class FailedConnectionError extends ConnectionError {

  private static final long serialVersionUID = 6985494149408870004L;

  public FailedConnectionError() {
  }

  public FailedConnectionError(final String error) {
    super(error);
  }

  public FailedConnectionError(final Throwable cause) {
    super(cause);
  }

  public FailedConnectionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
