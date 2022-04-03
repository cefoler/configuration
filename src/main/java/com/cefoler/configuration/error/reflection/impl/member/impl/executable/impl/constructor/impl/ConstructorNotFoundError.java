package com.cefoler.configuration.error.reflection.impl.member.impl.executable.impl.constructor.impl;

import com.cefoler.configuration.error.reflection.impl.member.impl.executable.impl.constructor.ConstructorError;

public class ConstructorNotFoundError extends ConstructorError {

  private static final long serialVersionUID = 560307525364153343L;

  public ConstructorNotFoundError() {
  }

  public ConstructorNotFoundError(final String error) {
    super(error);
  }

  public ConstructorNotFoundError(final Throwable cause) {
    super(cause);
  }

  public ConstructorNotFoundError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
