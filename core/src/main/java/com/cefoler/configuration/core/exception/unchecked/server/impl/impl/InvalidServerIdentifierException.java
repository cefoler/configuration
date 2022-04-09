package com.cefoler.configuration.core.exception.unchecked.server.impl.impl;

import com.cefoler.configuration.core.exception.unchecked.server.impl.InvalidServerException;

public class InvalidServerIdentifierException extends InvalidServerException {

  private static final long serialVersionUID = -4416104372498155403L;

  public InvalidServerIdentifierException() {
  }

  public InvalidServerIdentifierException(final String error) {
    super(error);
  }

  public InvalidServerIdentifierException(final Throwable cause) {
    super(cause);
  }

  public InvalidServerIdentifierException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
