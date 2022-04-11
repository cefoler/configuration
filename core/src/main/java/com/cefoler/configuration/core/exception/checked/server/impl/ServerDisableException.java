package com.cefoler.configuration.core.exception.checked.server.impl;

import com.cefoler.configuration.core.exception.checked.server.ServerException;

public class ServerDisableException extends ServerException {

  private static final long serialVersionUID = 5235186826644844055L;

  public ServerDisableException() {
  }

  public ServerDisableException(final String error) {
    super(error);
  }

  public ServerDisableException(final Throwable cause) {
    super(cause);
  }

  public ServerDisableException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
