package com.cefoler.configuration.exception.unchecked.connection.impl;

import com.cefoler.configuration.exception.unchecked.connection.ConnectionException;

public class ConnectionNotReadableException extends ConnectionException {

  private static final long serialVersionUID = 976885638472437209L;

  public ConnectionNotReadableException() {
  }

  public ConnectionNotReadableException(final String error) {
    super(error);
  }

  public ConnectionNotReadableException(final Throwable cause) {
    super(cause);
  }

  public ConnectionNotReadableException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
