package com.cefoler.configuration.error.reflection.impl.clazz;

import com.cefoler.configuration.error.reflection.ReflectionError;

public abstract class ClassError extends ReflectionError {

  private static final long serialVersionUID = 9172234941905981028L;

  protected ClassError() {
  }

  protected ClassError(final String error) {
    super(error);
  }

  protected ClassError(final Throwable cause) {
    super(cause);
  }

  protected ClassError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
