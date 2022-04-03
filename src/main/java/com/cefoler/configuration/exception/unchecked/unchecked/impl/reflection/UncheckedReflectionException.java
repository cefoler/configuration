package com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection;

import com.cefoler.configuration.exception.checked.reflection.ReflectionException;
import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;

public class UncheckedReflectionException extends UncheckedException {

  private static final long serialVersionUID = -5195541641647309577L;

  public UncheckedReflectionException(final ReflectionException cause) {
    super(cause);
  }

  public UncheckedReflectionException(final String error, final ReflectionException cause) {
    super(error, cause);
  }

}
