package com.cefoler.configuration.exception.checked.reflection.impl.annotation;

import com.cefoler.configuration.exception.checked.reflection.ReflectionException;

public abstract class AnnotationException extends ReflectionException {

  private static final long serialVersionUID = -3784990223171706028L;

  protected AnnotationException() {
  }

  protected AnnotationException(final String error) {
    super(error);
  }

  protected AnnotationException(final Throwable cause) {
    super(cause);
  }

  protected AnnotationException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
