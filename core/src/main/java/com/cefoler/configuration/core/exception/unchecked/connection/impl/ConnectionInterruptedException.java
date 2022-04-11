package com.cefoler.configuration.core.exception.unchecked.connection.impl;

import com.cefoler.configuration.core.exception.unchecked.connection.ConnectionException;

public class ConnectionInterruptedException extends ConnectionException {

  private static final long serialVersionUID = -3544454002170319213L;

  public ConnectionInterruptedException() {
  }

  public ConnectionInterruptedException(final String error) {
    super(error);
  }

  public ConnectionInterruptedException(final Throwable cause) {
    super(cause);
  }

  public ConnectionInterruptedException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
