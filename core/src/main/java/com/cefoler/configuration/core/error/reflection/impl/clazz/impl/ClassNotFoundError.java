package com.cefoler.configuration.core.error.reflection.impl.clazz.impl;

import com.cefoler.configuration.core.error.reflection.impl.clazz.ClassError;

public class ClassNotFoundError extends ClassError {

  private static final long serialVersionUID = 6144603875105584065L;

  public ClassNotFoundError() {
  }

  public ClassNotFoundError(final String error) {
    super(error);
  }

  public ClassNotFoundError(final Throwable cause) {
    super(cause);
  }

  public ClassNotFoundError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
