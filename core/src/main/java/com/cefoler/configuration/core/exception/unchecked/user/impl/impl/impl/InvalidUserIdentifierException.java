package com.cefoler.configuration.core.exception.unchecked.user.impl.impl.impl;

import com.cefoler.configuration.core.exception.unchecked.user.impl.impl.InvalidUserParameterException;

public class InvalidUserIdentifierException extends InvalidUserParameterException {

  private static final long serialVersionUID = -8272380982185718433L;

  public InvalidUserIdentifierException() {
  }

  public InvalidUserIdentifierException(final String error) {
    super(error);
  }

  public InvalidUserIdentifierException(final Throwable cause) {
    super(cause);
  }

  public InvalidUserIdentifierException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
