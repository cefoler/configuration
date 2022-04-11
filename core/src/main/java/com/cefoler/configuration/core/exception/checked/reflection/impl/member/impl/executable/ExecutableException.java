package com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.MemberException;

public abstract class ExecutableException extends MemberException {

  private static final long serialVersionUID = -7620186479656023118L;

  protected ExecutableException() {
  }

  protected ExecutableException(final String error) {
    super(error);
  }

  protected ExecutableException(final Throwable cause) {
    super(cause);
  }

  protected ExecutableException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
