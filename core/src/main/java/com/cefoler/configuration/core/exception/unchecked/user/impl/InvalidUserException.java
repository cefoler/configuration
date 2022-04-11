package com.cefoler.configuration.core.exception.unchecked.user.impl;

import com.cefoler.configuration.core.exception.unchecked.user.UserException;

public class InvalidUserException extends UserException {

  private static final long serialVersionUID = 7983578470413458866L;

  public InvalidUserException() {
  }

  public InvalidUserException(final String error) {
    super(error);
  }

  public InvalidUserException(final Throwable cause) {
    super(cause);
  }

  public InvalidUserException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
