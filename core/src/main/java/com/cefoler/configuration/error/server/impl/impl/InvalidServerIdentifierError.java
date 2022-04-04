package com.cefoler.configuration.error.server.impl.impl;

import com.cefoler.configuration.error.server.impl.InvalidServerError;

public class InvalidServerIdentifierError extends InvalidServerError {

  private static final long serialVersionUID = -5038512825261943045L;

  public InvalidServerIdentifierError() {
  }

  public InvalidServerIdentifierError(final String error) {
    super(error);
  }

  public InvalidServerIdentifierError(final Throwable cause) {
    super(cause);
  }

  public InvalidServerIdentifierError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
