package com.cefoler.configuration.exception.checked.server.impl;

import com.cefoler.configuration.exception.checked.server.ServerException;

public class ServerLoadException extends ServerException {

  private static final long serialVersionUID = 2361085713501352813L;

  public ServerLoadException() {
  }

  public ServerLoadException(final String error) {
    super(error);
  }

  public ServerLoadException(final Throwable cause) {
    super(cause);
  }

  public ServerLoadException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
