package com.cefoler.configuration.core.exception.unchecked.user.impl;

import com.cefoler.configuration.core.exception.unchecked.user.UserException;

public class UserAlreadyExistException extends UserException {

  private static final long serialVersionUID = -6518317881945136383L;

  public UserAlreadyExistException() {
  }

  public UserAlreadyExistException(final String error) {
    super(error);
  }

  public UserAlreadyExistException(final Throwable cause) {
    super(cause);
  }

  public UserAlreadyExistException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
