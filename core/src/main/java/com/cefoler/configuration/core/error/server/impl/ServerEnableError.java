package com.cefoler.configuration.core.error.server.impl;

import com.cefoler.configuration.core.error.server.ServerError;

public class ServerEnableError extends ServerError {

  private static final long serialVersionUID = 3044800768814805225L;

  public ServerEnableError() {
  }

  public ServerEnableError(final String error) {
    super(error);
  }

  public ServerEnableError(final Throwable cause) {
    super(cause);
  }

  public ServerEnableError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
