package com.cefoler.configuration.error.reflection.impl.annotation.impl;

import com.cefoler.configuration.error.reflection.impl.annotation.AnnotationError;

public class AnnotationNotFoundError extends AnnotationError {

  private static final long serialVersionUID = -6823825424799352349L;

  public AnnotationNotFoundError() {
  }

  public AnnotationNotFoundError(final String error) {
    super(error);
  }

  public AnnotationNotFoundError(final Throwable cause) {
    super(cause);
  }

  public AnnotationNotFoundError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
