package com.cefoler.configuration.error.reflection.impl.member.impl.executable.impl;

import com.cefoler.configuration.error.reflection.impl.member.impl.executable.ExecutableError;

public class ExecutableThrewError extends ExecutableError {

  private static final long serialVersionUID = 4230634302303230760L;

  public ExecutableThrewError() {
  }

  public ExecutableThrewError(final String error) {
    super(error);
  }

  public ExecutableThrewError(final Throwable cause) {
    super(cause);
  }

  public ExecutableThrewError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
