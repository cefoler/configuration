package com.cefoler.configuration.error.server.impl;

import com.cefoler.configuration.error.server.ServerError;

public class ServerInterruptedError extends ServerError {

  private static final long serialVersionUID = 8011140776174617976L;

  public ServerInterruptedError() {
  }

  public ServerInterruptedError(final String error) {
    super(error);
  }

  public ServerInterruptedError(final Throwable cause) {
    super(cause);
  }

  public ServerInterruptedError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
