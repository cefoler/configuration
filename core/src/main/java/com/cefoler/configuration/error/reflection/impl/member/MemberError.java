package com.cefoler.configuration.error.reflection.impl.member;

import com.cefoler.configuration.error.reflection.ReflectionError;

public abstract class MemberError extends ReflectionError {

  private static final long serialVersionUID = 4066302016889941610L;

  protected MemberError() {
  }

  protected MemberError(final String error) {
    super(error);
  }

  protected MemberError(final Throwable cause) {
    super(cause);
  }

  protected MemberError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
