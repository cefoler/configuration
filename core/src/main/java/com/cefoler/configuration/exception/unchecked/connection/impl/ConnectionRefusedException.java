package com.cefoler.configuration.exception.unchecked.connection.impl;

import com.cefoler.configuration.exception.unchecked.connection.ConnectionException;

public class ConnectionRefusedException extends ConnectionException {

  private static final long serialVersionUID = 2811446547289320825L;

  public ConnectionRefusedException() {
  }

  public ConnectionRefusedException(final String error) {
    super(error);
  }

  public ConnectionRefusedException(final Throwable cause) {
    super(cause);
  }

  public ConnectionRefusedException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
