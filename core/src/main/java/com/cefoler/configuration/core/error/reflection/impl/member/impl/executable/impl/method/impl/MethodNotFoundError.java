package com.cefoler.configuration.core.error.reflection.impl.member.impl.executable.impl.method.impl;

import com.cefoler.configuration.core.error.reflection.impl.member.impl.executable.impl.method.MethodError;

public class MethodNotFoundError extends MethodError {

  private static final long serialVersionUID = -1348260587308199136L;

  public MethodNotFoundError() {
  }

  public MethodNotFoundError(final String error) {
    super(error);
  }

  public MethodNotFoundError(final Throwable cause) {
    super(cause);
  }

  public MethodNotFoundError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
