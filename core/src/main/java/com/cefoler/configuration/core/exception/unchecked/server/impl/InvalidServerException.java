package com.cefoler.configuration.core.exception.unchecked.server.impl;

import com.cefoler.configuration.core.exception.unchecked.server.ServerException;

public class InvalidServerException extends ServerException {

  private static final long serialVersionUID = 6203451930552607860L;

  public InvalidServerException() {
  }

  public InvalidServerException(final String error) {
    super(error);
  }

  public InvalidServerException(final Throwable cause) {
    super(cause);
  }

  public InvalidServerException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
