package com.cefoler.configuration.core.error.security;

public abstract class SecurityError extends Error {

  private static final long serialVersionUID = 5760089638664120547L;

  protected SecurityError() {
  }

  protected SecurityError(final String error) {
    super(error);
  }

  protected SecurityError(final Throwable cause) {
    super(cause);
  }

  protected SecurityError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
