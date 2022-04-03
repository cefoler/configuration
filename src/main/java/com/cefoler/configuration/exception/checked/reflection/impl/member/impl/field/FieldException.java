package com.cefoler.configuration.exception.checked.reflection.impl.member.impl.field;

import com.cefoler.configuration.exception.checked.reflection.impl.member.MemberException;

public abstract class FieldException extends MemberException {

  private static final long serialVersionUID = -2664904356900656728L;

  protected FieldException() {
  }

  protected FieldException(final String error) {
    super(error);
  }

  protected FieldException(final Throwable cause) {
    super(cause);
  }

  protected FieldException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
