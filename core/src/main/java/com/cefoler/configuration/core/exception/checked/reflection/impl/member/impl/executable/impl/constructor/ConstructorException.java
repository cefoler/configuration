package com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.impl.constructor;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.ExecutableException;

public abstract class ConstructorException extends ExecutableException {

  private static final long serialVersionUID = 5149511772222452820L;

  protected ConstructorException() {
  }

  protected ConstructorException(final String error) {
    super(error);
  }

  protected ConstructorException(final Throwable cause) {
    super(cause);
  }

  protected ConstructorException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
