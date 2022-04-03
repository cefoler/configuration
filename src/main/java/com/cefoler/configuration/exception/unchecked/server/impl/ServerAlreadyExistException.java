package com.cefoler.configuration.exception.unchecked.server.impl;

import com.cefoler.configuration.exception.unchecked.server.ServerException;

public class ServerAlreadyExistException extends ServerException {

  private static final long serialVersionUID = -4405318384292203194L;

  public ServerAlreadyExistException() {
  }

  public ServerAlreadyExistException(final String error) {
    super(error);
  }

  public ServerAlreadyExistException(final Throwable cause) {
    super(cause);
  }

  public ServerAlreadyExistException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
