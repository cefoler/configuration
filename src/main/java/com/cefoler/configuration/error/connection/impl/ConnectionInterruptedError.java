package com.cefoler.configuration.error.connection.impl;

import com.cefoler.configuration.error.connection.ConnectionError;

public class ConnectionInterruptedError extends ConnectionError {

  private static final long serialVersionUID = 7635472277875524768L;

  public ConnectionInterruptedError() {
  }

  public ConnectionInterruptedError(final String error) {
    super(error);
  }

  public ConnectionInterruptedError(final Throwable cause) {
    super(cause);
  }

  public ConnectionInterruptedError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
