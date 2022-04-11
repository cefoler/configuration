package com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.impl;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.ExecutableException;

public class ExecutableThrewException extends ExecutableException {

  private static final long serialVersionUID = 7063608241239112487L;

  public ExecutableThrewException() {
  }

  public ExecutableThrewException(final String error) {
    super(error);
  }

  public ExecutableThrewException(final Throwable cause) {
    super(cause);
  }

  public ExecutableThrewException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
