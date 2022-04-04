package com.cefoler.configuration.exception.checked.reflection.impl.member.impl.field.impl;

import com.cefoler.configuration.exception.checked.reflection.impl.member.impl.field.FieldException;

public class FieldNotFoundException extends FieldException {

  private static final long serialVersionUID = 1305833016410581215L;

  public FieldNotFoundException() {
  }

  public FieldNotFoundException(final String error) {
    super(error);
  }

  public FieldNotFoundException(final Throwable cause) {
    super(cause);
  }

  public FieldNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
