package com.cefoler.configuration.exception.unchecked.server.impl;

import com.cefoler.configuration.exception.unchecked.server.ServerException;

public class ServerInterruptedException extends ServerException {

  private static final long serialVersionUID = -3700209233554657016L;

  public ServerInterruptedException() {
  }

  public ServerInterruptedException(final String error) {
    super(error);
  }

  public ServerInterruptedException(final Throwable cause) {
    super(cause);
  }

  public ServerInterruptedException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
