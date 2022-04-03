package com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection.impl.member.impl.executable.impl;

import com.cefoler.configuration.exception.checked.reflection.impl.member.impl.executable.impl.ExecutableInvalidArgumentException;
import com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection.impl.member.impl.executable.UncheckedExecutableException;

public class UncheckedExecutableInvalidArgumentException extends UncheckedExecutableException {

  private static final long serialVersionUID = 119175617359808131L;

  public UncheckedExecutableInvalidArgumentException(
      final ExecutableInvalidArgumentException cause) {
    super(cause);
  }

  public UncheckedExecutableInvalidArgumentException(final String error,
      final ExecutableInvalidArgumentException cause) {
    super(error, cause);
  }

}
