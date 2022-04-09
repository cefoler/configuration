package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.member;

import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.UncheckedReflectiveOperationException;

public class UncheckedIllegalAccessException extends UncheckedReflectiveOperationException {

  private static final long serialVersionUID = -2163192061596331707L;

  public UncheckedIllegalAccessException(final IllegalAccessException cause) {
    super(cause);
  }

  public UncheckedIllegalAccessException(final String error, final IllegalAccessException cause) {
    super(error, cause);
  }

}
