package com.cefoler.configuration.error.server.impl;

import com.cefoler.configuration.error.server.ServerError;

public class ServerDisableError extends ServerError {

  private static final long serialVersionUID = 3447963309488413114L;

  public ServerDisableError() {
  }

  public ServerDisableError(final String error) {
    super(error);
  }

  public ServerDisableError(final Throwable cause) {
    super(cause);
  }

  public ServerDisableError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
