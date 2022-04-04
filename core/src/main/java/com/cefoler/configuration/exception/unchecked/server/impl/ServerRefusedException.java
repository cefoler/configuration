package com.cefoler.configuration.exception.unchecked.server.impl;

import com.cefoler.configuration.exception.unchecked.server.ServerException;

public class ServerRefusedException extends ServerException {

  private static final long serialVersionUID = 8544492117108351217L;

  public ServerRefusedException() {
  }

  public ServerRefusedException(final String error) {
    super(error);
  }

  public ServerRefusedException(final Throwable cause) {
    super(cause);
  }

  public ServerRefusedException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
