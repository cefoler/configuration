package com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.impl.method;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.ExecutableException;

public abstract class MethodException extends ExecutableException {

  private static final long serialVersionUID = -2703955952797570141L;

  protected MethodException() {
  }

  protected MethodException(final String error) {
    super(error);
  }

  protected MethodException(final Throwable cause) {
    super(cause);
  }

  protected MethodException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
