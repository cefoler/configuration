package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.member.impl.executable.impl;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.impl.ExecutableThrewException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.member.impl.executable.UncheckedExecutableException;

public class UncheckedExecutableThrewException extends UncheckedExecutableException {

  private static final long serialVersionUID = -5226253156088363137L;

  public UncheckedExecutableThrewException(final ExecutableThrewException cause) {
    super(cause);
  }

  public UncheckedExecutableThrewException(final String error,
      final ExecutableThrewException cause) {
    super(error, cause);
  }

}
