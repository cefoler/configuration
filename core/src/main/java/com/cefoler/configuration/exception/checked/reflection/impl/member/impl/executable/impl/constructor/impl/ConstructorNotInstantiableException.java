package com.cefoler.configuration.exception.checked.reflection.impl.member.impl.executable.impl.constructor.impl;

import com.cefoler.configuration.exception.checked.reflection.impl.member.impl.executable.impl.constructor.ConstructorException;

public class ConstructorNotInstantiableException extends ConstructorException {

  private static final long serialVersionUID = 2905267878183683086L;

  public ConstructorNotInstantiableException() {
  }

  public ConstructorNotInstantiableException(final String error) {
    super(error);
  }

  public ConstructorNotInstantiableException(final Throwable cause) {
    super(cause);
  }

  public ConstructorNotInstantiableException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
