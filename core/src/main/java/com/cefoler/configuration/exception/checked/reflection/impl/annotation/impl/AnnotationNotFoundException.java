package com.cefoler.configuration.exception.checked.reflection.impl.annotation.impl;

import com.cefoler.configuration.exception.checked.reflection.impl.annotation.AnnotationException;

public class AnnotationNotFoundException extends AnnotationException {

  private static final long serialVersionUID = -3692834941044891833L;

  public AnnotationNotFoundException() {
  }

  public AnnotationNotFoundException(final String error) {
    super(error);
  }

  public AnnotationNotFoundException(final Throwable cause) {
    super(cause);
  }

  public AnnotationNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
