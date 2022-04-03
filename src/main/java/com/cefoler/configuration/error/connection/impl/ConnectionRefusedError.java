package com.cefoler.configuration.error.connection.impl;

import com.cefoler.configuration.error.connection.ConnectionError;

public class ConnectionRefusedError extends ConnectionError {

  private static final long serialVersionUID = 7986458015993179557L;

  public ConnectionRefusedError() {
  }

  public ConnectionRefusedError(final String error) {
    super(error);
  }

  public ConnectionRefusedError(final Throwable cause) {
    super(cause);
  }

  public ConnectionRefusedError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
