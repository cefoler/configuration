package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.annotation.impl;

import com.cefoler.configuration.core.exception.checked.reflection.impl.annotation.impl.AnnotationNotFoundException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.annotation.UncheckedAnnotationException;

public class UncheckedAnnotationNotFoundException extends UncheckedAnnotationException {

  private static final long serialVersionUID = -1084974965681413670L;

  public UncheckedAnnotationNotFoundException(final AnnotationNotFoundException cause) {
    super(cause);
  }

  public UncheckedAnnotationNotFoundException(final String error,
      final AnnotationNotFoundException cause) {
    super(error, cause);
  }

}
