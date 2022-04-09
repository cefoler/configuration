package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.clazz;

import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.UncheckedReflectiveOperationException;

public class UncheckedClassNotFoundException extends UncheckedReflectiveOperationException {

  private static final long serialVersionUID = -1523386848520246277L;

  public UncheckedClassNotFoundException(final ClassNotFoundException cause) {
    super(cause);
  }

  public UncheckedClassNotFoundException(final String error, final ClassNotFoundException cause) {
    super(error, cause);
  }

}
