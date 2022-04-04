package com.cefoler.configuration.exception.checked.reflection.impl.clazz;

import com.cefoler.configuration.exception.checked.reflection.ReflectionException;

public abstract class ClassException extends ReflectionException {

  private static final long serialVersionUID = -5272084613485105170L;

  protected ClassException() {
  }

  protected ClassException(final String error) {
    super(error);
  }

  protected ClassException(final Throwable cause) {
    super(cause);
  }

  protected ClassException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
