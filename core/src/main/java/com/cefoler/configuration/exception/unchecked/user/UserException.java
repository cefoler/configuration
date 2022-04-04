package com.cefoler.configuration.exception.unchecked.user;

public abstract class UserException extends RuntimeException {

  private static final long serialVersionUID = -3843150856363454563L;

  protected UserException() {
  }

  protected UserException(final String error) {
    super(error);
  }

  protected UserException(final Throwable cause) {
    super(cause);
  }

  protected UserException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
