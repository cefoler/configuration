package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.clazz;

import com.cefoler.configuration.core.exception.checked.reflection.impl.clazz.ClassException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.UncheckedReflectionException;

public class UncheckedClassException extends UncheckedReflectionException {

  private static final long serialVersionUID = -7454217485330458832L;

  public UncheckedClassException(final ClassException cause) {
    super(cause);
  }

  public UncheckedClassException(final String error, final ClassException cause) {
    super(error, cause);
  }

}
