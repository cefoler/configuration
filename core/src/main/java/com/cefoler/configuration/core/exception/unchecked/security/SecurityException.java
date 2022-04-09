package com.cefoler.configuration.core.exception.unchecked.security;

public abstract class SecurityException extends RuntimeException {

  private static final long serialVersionUID = 5760089638664120547L;

  protected SecurityException() {
  }

  protected SecurityException(final String error) {
    super(error);
  }

  protected SecurityException(final Throwable cause) {
    super(cause);
  }

  protected SecurityException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
