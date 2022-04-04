package com.cefoler.configuration.exception.unchecked.user.impl.impl.impl;

import com.cefoler.configuration.exception.unchecked.user.impl.impl.InvalidUserParameterException;

public class InvalidUserNameException extends InvalidUserParameterException {

  private static final long serialVersionUID = 6208939815993823456L;

  public InvalidUserNameException() {
  }

  public InvalidUserNameException(final String error) {
    super(error);
  }

  public InvalidUserNameException(final Throwable cause) {
    super(cause);
  }

  public InvalidUserNameException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
