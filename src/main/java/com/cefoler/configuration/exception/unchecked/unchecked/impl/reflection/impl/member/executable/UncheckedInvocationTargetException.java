package com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection.impl.member.executable;

import com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection.UncheckedReflectiveOperationException;
import java.lang.reflect.InvocationTargetException;

public class UncheckedInvocationTargetException extends UncheckedReflectiveOperationException {

  private static final long serialVersionUID = -4852090284904215858L;

  public UncheckedInvocationTargetException(final InvocationTargetException cause) {
    super(cause);
  }

  public UncheckedInvocationTargetException(final String error,
      final InvocationTargetException cause) {
    super(error, cause);
  }

}
