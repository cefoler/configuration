package com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.MemberException;

public class MemberNotPermissionException extends MemberException {

  private static final long serialVersionUID = -8273999686187225059L;

  public MemberNotPermissionException() {
  }

  public MemberNotPermissionException(final String error) {
    super(error);
  }

  public MemberNotPermissionException(final Throwable cause) {
    super(cause);
  }

  public MemberNotPermissionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
