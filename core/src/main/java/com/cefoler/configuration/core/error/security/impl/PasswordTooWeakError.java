package com.cefoler.configuration.core.error.security.impl;

import com.cefoler.configuration.core.error.security.SecurityError;

public class PasswordTooWeakError extends SecurityError {

  private static final long serialVersionUID = 6969590643042433110L;

  public PasswordTooWeakError() {
  }

  public PasswordTooWeakError(final String error) {
    super(error);
  }

  public PasswordTooWeakError(final Throwable cause) {
    super(cause);
  }

  public PasswordTooWeakError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
