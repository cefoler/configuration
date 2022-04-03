package com.cefoler.configuration.exception.unchecked.connection.impl;

import com.cefoler.configuration.exception.unchecked.connection.ConnectionException;

public class InvalidConnectionException extends ConnectionException {

  private static final long serialVersionUID = 174550506668091499L;

  public InvalidConnectionException() {
  }

  public InvalidConnectionException(final String error) {
    super(error);
  }

  public InvalidConnectionException(final Throwable cause) {
    super(cause);
  }

  public InvalidConnectionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
