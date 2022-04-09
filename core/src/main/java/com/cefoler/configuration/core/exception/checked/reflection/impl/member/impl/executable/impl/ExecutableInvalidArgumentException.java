package com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.impl;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.ExecutableException;

public class ExecutableInvalidArgumentException extends ExecutableException {

  private static final long serialVersionUID = -3086670343821874168L;

  public ExecutableInvalidArgumentException() {
  }

  public ExecutableInvalidArgumentException(final String error) {
    super(error);
  }

  public ExecutableInvalidArgumentException(final Throwable cause) {
    super(cause);
  }

  public ExecutableInvalidArgumentException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
