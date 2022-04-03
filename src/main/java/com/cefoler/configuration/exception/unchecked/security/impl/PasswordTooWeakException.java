package com.cefoler.configuration.exception.unchecked.security.impl;

public class PasswordTooWeakException extends SecurityException {

  private static final long serialVersionUID = 6969590643042433110L;

  public PasswordTooWeakException() {
  }

  public PasswordTooWeakException(final String error) {
    super(error);
  }

  public PasswordTooWeakException(final Throwable cause) {
    super(cause);
  }

  public PasswordTooWeakException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
