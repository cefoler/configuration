package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;

public class UncheckedReflectiveOperationException extends UncheckedException {

  private static final long serialVersionUID = -3521899217715836331L;

  public UncheckedReflectiveOperationException(final ReflectiveOperationException cause) {
    super(cause);
  }

  public UncheckedReflectiveOperationException(final String error,
      final ReflectiveOperationException cause) {
    super(error, cause);
  }

}
