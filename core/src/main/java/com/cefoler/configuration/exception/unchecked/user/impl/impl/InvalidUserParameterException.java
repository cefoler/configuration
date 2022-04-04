package com.cefoler.configuration.exception.unchecked.user.impl.impl;

import com.cefoler.configuration.exception.unchecked.user.impl.InvalidUserException;

public class InvalidUserParameterException extends InvalidUserException {

  private static final long serialVersionUID = -1980351545224753365L;

  public InvalidUserParameterException() {
  }

  public InvalidUserParameterException(final String error) {
    super(error);
  }

  public InvalidUserParameterException(final Throwable cause) {
    super(cause);
  }

  public InvalidUserParameterException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
