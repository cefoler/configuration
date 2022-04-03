package com.cefoler.configuration.error.reflection.impl.member.impl.field.impl;

import com.cefoler.configuration.error.reflection.impl.member.impl.field.FieldError;

public class FieldNotFoundError extends FieldError {

  private static final long serialVersionUID = -180547641500728760L;

  public FieldNotFoundError() {
  }

  public FieldNotFoundError(final String error) {
    super(error);
  }

  public FieldNotFoundError(final Throwable cause) {
    super(cause);
  }

  public FieldNotFoundError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
