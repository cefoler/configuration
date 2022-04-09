package com.cefoler.configuration.core.error.reflection.impl.member.impl.executable.impl.constructor;

import com.cefoler.configuration.core.error.reflection.impl.member.impl.executable.ExecutableError;

public abstract class ConstructorError extends ExecutableError {

  private static final long serialVersionUID = -7995969725459091854L;

  protected ConstructorError() {
  }

  protected ConstructorError(final String error) {
    super(error);
  }

  protected ConstructorError(final Throwable cause) {
    super(cause);
  }

  protected ConstructorError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
