package com.cefoler.configuration.core.error.server.impl;

import com.cefoler.configuration.core.error.server.ServerError;

public class ServerLoadError extends ServerError {

  private static final long serialVersionUID = 6200146066940909419L;

  public ServerLoadError() {
  }

  public ServerLoadError(final String error) {
    super(error);
  }

  public ServerLoadError(final Throwable cause) {
    super(cause);
  }

  public ServerLoadError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
