package com.cefoler.configuration.core.exception.checked.server.impl;

import com.cefoler.configuration.core.exception.checked.server.ServerException;

public class ServerNotFoundException extends ServerException {

  private static final long serialVersionUID = 5785295028871453981L;

  public ServerNotFoundException() {
  }

  public ServerNotFoundException(final String error) {
    super(error);
  }

  public ServerNotFoundException(final Throwable cause) {
    super(cause);
  }

  public ServerNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
