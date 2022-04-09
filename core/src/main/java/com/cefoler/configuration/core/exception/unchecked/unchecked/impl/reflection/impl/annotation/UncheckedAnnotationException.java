package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.annotation;

import com.cefoler.configuration.core.exception.checked.reflection.impl.annotation.AnnotationException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.UncheckedReflectionException;

public class UncheckedAnnotationException extends UncheckedReflectionException {

  private static final long serialVersionUID = -429648634924286165L;

  public UncheckedAnnotationException(final AnnotationException cause) {
    super(cause);
  }

  public UncheckedAnnotationException(final String error, final AnnotationException cause) {
    super(error, cause);
  }

}
