package com.cefoler.configuration.core.exception.unchecked.connection.impl;

import com.cefoler.configuration.core.exception.unchecked.connection.ConnectionException;

public class ConnectionTimeoutException extends ConnectionException {

  private static final long serialVersionUID = 1526108356715235197L;

  public ConnectionTimeoutException() {
  }

  public ConnectionTimeoutException(final String error) {
    super(error);
  }

  public ConnectionTimeoutException(final Throwable cause) {
    super(cause);
  }

  public ConnectionTimeoutException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
