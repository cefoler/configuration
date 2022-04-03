package com.cefoler.configuration.exception.checked.user.impl;

import com.cefoler.configuration.exception.checked.user.UserException;

public class UserNotFoundException extends UserException {

  private static final long serialVersionUID = -5398835890907418727L;

  public UserNotFoundException() {
  }

  public UserNotFoundException(final String error) {
    super(error);
  }

  public UserNotFoundException(final Throwable cause) {
    super(cause);
  }

  public UserNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
