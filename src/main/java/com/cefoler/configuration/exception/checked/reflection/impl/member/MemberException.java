package com.cefoler.configuration.exception.checked.reflection.impl.member;

import com.cefoler.configuration.exception.checked.reflection.ReflectionException;

public abstract class MemberException extends ReflectionException {

  private static final long serialVersionUID = 5512587619188743771L;

  protected MemberException() {
  }

  protected MemberException(final String error) {
    super(error);
  }

  protected MemberException(final Throwable cause) {
    super(cause);
  }

  protected MemberException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
