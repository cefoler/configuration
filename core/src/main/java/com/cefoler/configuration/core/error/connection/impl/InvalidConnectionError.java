package com.cefoler.configuration.core.error.connection.impl;

import com.cefoler.configuration.core.error.connection.ConnectionError;

public class InvalidConnectionError extends ConnectionError {

  private static final long serialVersionUID = 7979429426738509205L;

  public InvalidConnectionError() {
  }

  public InvalidConnectionError(final String error) {
    super(error);
  }

  public InvalidConnectionError(final Throwable cause) {
    super(cause);
  }

  public InvalidConnectionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
