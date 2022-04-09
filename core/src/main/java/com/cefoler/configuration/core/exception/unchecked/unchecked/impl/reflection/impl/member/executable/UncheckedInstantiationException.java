package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.member.executable;

import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.UncheckedReflectiveOperationException;

public class UncheckedInstantiationException extends UncheckedReflectiveOperationException {

  private static final long serialVersionUID = -324304651351763451L;

  public UncheckedInstantiationException(final InstantiationException cause) {
    super(cause);
  }

  public UncheckedInstantiationException(final String error, final InstantiationException cause) {
    super(error, cause);
  }

}
