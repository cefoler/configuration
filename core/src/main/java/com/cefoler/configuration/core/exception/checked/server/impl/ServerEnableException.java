package com.cefoler.configuration.core.exception.checked.server.impl;

import com.cefoler.configuration.core.exception.checked.server.ServerException;

public class ServerEnableException extends ServerException {

  private static final long serialVersionUID = -6623934314388550936L;

  public ServerEnableException() {
  }

  public ServerEnableException(final String error) {
    super(error);
  }

  public ServerEnableException(final Throwable cause) {
    super(cause);
  }

  public ServerEnableException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
