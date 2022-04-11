package com.cefoler.configuration.core.error.reflection.impl.member.impl.executable.impl;

import com.cefoler.configuration.core.error.reflection.impl.member.impl.executable.ExecutableError;

public class ExecutableInvalidArgumentError extends ExecutableError {

  private static final long serialVersionUID = 4379674706142490730L;

  public ExecutableInvalidArgumentError() {
  }

  public ExecutableInvalidArgumentError(final String error) {
    super(error);
  }

  public ExecutableInvalidArgumentError(final Throwable cause) {
    super(cause);
  }

  public ExecutableInvalidArgumentError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
