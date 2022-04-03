package com.cefoler.configuration.exception.checked.user;

public abstract class UserException extends Exception {

  private static final long serialVersionUID = 7095030323998540451L;

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
