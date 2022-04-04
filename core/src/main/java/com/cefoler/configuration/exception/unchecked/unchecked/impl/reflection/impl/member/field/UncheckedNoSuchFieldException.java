package com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection.impl.member.field;

import com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection.UncheckedReflectiveOperationException;

public class UncheckedNoSuchFieldException extends UncheckedReflectiveOperationException {

  private static final long serialVersionUID = -5651656475406845154L;

  public UncheckedNoSuchFieldException(final NoSuchFieldException cause) {
    super(cause);
  }

  public UncheckedNoSuchFieldException(final String error, final NoSuchFieldException cause) {
    super(error, cause);
  }

}
