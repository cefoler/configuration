package com.cefoler.configuration.error.reflection.impl.member.impl.executable.impl.method;

import com.cefoler.configuration.error.reflection.impl.member.impl.executable.ExecutableError;

public abstract class MethodError extends ExecutableError {

  private static final long serialVersionUID = -2432607155493414971L;

  protected MethodError() {
  }

  protected MethodError(final String error) {
    super(error);
  }

  protected MethodError(final Throwable cause) {
    super(cause);
  }

  protected MethodError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
