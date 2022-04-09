package com.cefoler.configuration.core.exception.unchecked.server.impl;

import com.cefoler.configuration.core.exception.unchecked.server.ServerException;

public class ServerDisableException extends ServerException {

  private static final long serialVersionUID = -7129686752679461704L;

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
