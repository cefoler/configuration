package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.clazz.impl;

import com.cefoler.configuration.core.exception.checked.reflection.impl.clazz.impl.ClassNotFoundException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.clazz.UncheckedClassException;

public class UncheckedClassNotFoundException extends UncheckedClassException {

  private static final long serialVersionUID = -8979574553641683771L;

  public UncheckedClassNotFoundException(final ClassNotFoundException cause) {
    super(cause);
  }

  public UncheckedClassNotFoundException(final String error, final ClassNotFoundException cause) {
    super(error, cause);
  }

}
