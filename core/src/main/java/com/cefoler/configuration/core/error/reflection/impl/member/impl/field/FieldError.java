package com.cefoler.configuration.core.error.reflection.impl.member.impl.field;

import com.cefoler.configuration.core.error.reflection.impl.member.MemberError;

public abstract class FieldError extends MemberError {

  private static final long serialVersionUID = 3777287115649631638L;

  protected FieldError() {
  }

  protected FieldError(final String error) {
    super(error);
  }

  protected FieldError(final Throwable cause) {
    super(cause);
  }

  protected FieldError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
