package com.cefoler.configuration.core.exception.unchecked.server.impl;

import com.cefoler.configuration.core.exception.unchecked.server.ServerException;

public class ServerLoadException extends ServerException {

  private static final long serialVersionUID = 1259080252009756238L;

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
