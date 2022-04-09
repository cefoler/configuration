package com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.impl.constructor.impl;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.impl.constructor.ConstructorException;

public class ConstructorNotFoundException extends ConstructorException {

  private static final long serialVersionUID = -2522712309382902989L;

  public ConstructorNotFoundException() {
  }

  public ConstructorNotFoundException(final String error) {
    super(error);
  }

  public ConstructorNotFoundException(final Throwable cause) {
    super(cause);
  }

  public ConstructorNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
