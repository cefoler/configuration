package com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection.impl.member.executable;

import com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection.UncheckedReflectiveOperationException;

public class UncheckedNoSuchMethodException extends UncheckedReflectiveOperationException {

  private static final long serialVersionUID = -8897528142814166921L;

  public UncheckedNoSuchMethodException(final NoSuchMethodException cause) {
    super(cause);
  }

  public UncheckedNoSuchMethodException(final String error, final NoSuchMethodException cause) {
    super(error, cause);
  }

}
