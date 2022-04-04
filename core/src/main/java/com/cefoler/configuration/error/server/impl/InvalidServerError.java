package com.cefoler.configuration.error.server.impl;

import com.cefoler.configuration.error.server.ServerError;

public class InvalidServerError extends ServerError {

  private static final long serialVersionUID = 4488625883285329858L;

  public InvalidServerError() {
  }

  public InvalidServerError(final String error) {
    super(error);
  }

  public InvalidServerError(final Throwable cause) {
    super(cause);
  }

  public InvalidServerError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
