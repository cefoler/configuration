package com.cefoler.configuration.error.reflection.impl.member.impl;

import com.cefoler.configuration.error.reflection.impl.member.MemberError;

public class MemberNotPermissionError extends MemberError {

  private static final long serialVersionUID = -149258602468580831L;

  public MemberNotPermissionError() {
  }

  public MemberNotPermissionError(final String error) {
    super(error);
  }

  public MemberNotPermissionError(final Throwable cause) {
    super(cause);
  }

  public MemberNotPermissionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
