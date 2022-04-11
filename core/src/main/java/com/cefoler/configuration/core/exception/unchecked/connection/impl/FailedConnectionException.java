package com.cefoler.configuration.core.exception.unchecked.connection.impl;

import com.cefoler.configuration.core.exception.unchecked.connection.ConnectionException;

public class FailedConnectionException extends ConnectionException {

  private static final long serialVersionUID = 3653413495943896374L;

  public FailedConnectionException() {
  }

  public FailedConnectionException(final String error) {
    super(error);
  }

  public FailedConnectionException(final Throwable cause) {
    super(cause);
  }

  public FailedConnectionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
