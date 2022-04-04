package com.cefoler.configuration.error.reflection.impl.member.impl.executable;

import com.cefoler.configuration.error.reflection.impl.member.MemberError;

public abstract class ExecutableError extends MemberError {

  private static final long serialVersionUID = 6122762182921381964L;

  protected ExecutableError() {
  }

  protected ExecutableError(final String error) {
    super(error);
  }

  protected ExecutableError(final Throwable cause) {
    super(cause);
  }

  protected ExecutableError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
