package com.cefoler.configuration.error.server.impl.impl;

import com.cefoler.configuration.error.server.impl.InvalidServerError;

public class InvalidServerNameError extends InvalidServerError {

  private static final long serialVersionUID = -7709375346713083778L;

  public InvalidServerNameError() {
  }

  public InvalidServerNameError(final String error) {
    super(error);
  }

  public InvalidServerNameError(final Throwable cause) {
    super(cause);
  }

  public InvalidServerNameError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
