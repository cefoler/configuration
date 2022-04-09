package com.cefoler.configuration.core.exception.unchecked.server.impl.impl;

import com.cefoler.configuration.core.exception.unchecked.server.impl.InvalidServerException;

public class InvalidServerNameException extends InvalidServerException {

  private static final long serialVersionUID = 9111342686937664094L;

  public InvalidServerNameException() {
  }

  public InvalidServerNameException(final String error) {
    super(error);
  }

  public InvalidServerNameException(final Throwable cause) {
    super(cause);
  }

  public InvalidServerNameException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
