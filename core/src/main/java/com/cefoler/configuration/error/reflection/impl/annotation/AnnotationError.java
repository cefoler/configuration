package com.cefoler.configuration.error.reflection.impl.annotation;

import com.cefoler.configuration.error.reflection.ReflectionError;

public abstract class AnnotationError extends ReflectionError {

  private static final long serialVersionUID = -1890956061096783029L;

  protected AnnotationError() {
  }

  protected AnnotationError(final String error) {
    super(error);
  }

  protected AnnotationError(final Throwable cause) {
    super(cause);
  }

  protected AnnotationError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
