package com.cefoler.configuration.exception.unchecked.server.impl;

import com.cefoler.configuration.exception.unchecked.server.ServerException;

public class ServerEnableException extends ServerException {

  private static final long serialVersionUID = -2211427533780986231L;

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
