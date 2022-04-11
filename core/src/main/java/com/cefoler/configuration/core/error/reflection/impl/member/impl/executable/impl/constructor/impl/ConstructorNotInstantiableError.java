package com.cefoler.configuration.core.error.reflection.impl.member.impl.executable.impl.constructor.impl;

import com.cefoler.configuration.core.error.reflection.impl.member.impl.executable.impl.constructor.ConstructorError;

public class ConstructorNotInstantiableError extends ConstructorError {

  private static final long serialVersionUID = 7235313817307322022L;

  public ConstructorNotInstantiableError() {
  }

  public ConstructorNotInstantiableError(final String error) {
    super(error);
  }

  public ConstructorNotInstantiableError(final Throwable cause) {
    super(cause);
  }

  public ConstructorNotInstantiableError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
