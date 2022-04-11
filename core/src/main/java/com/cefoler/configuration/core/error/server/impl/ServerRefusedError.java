package com.cefoler.configuration.core.error.server.impl;

import com.cefoler.configuration.core.error.server.ServerError;

public class ServerRefusedError extends ServerError {

  private static final long serialVersionUID = -8792577419256146000L;

  public ServerRefusedError() {
  }

  public ServerRefusedError(final String error) {
    super(error);
  }

  public ServerRefusedError(final Throwable cause) {
    super(cause);
  }

  public ServerRefusedError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
