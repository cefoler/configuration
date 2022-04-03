package com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection.impl.member;

import com.cefoler.configuration.exception.checked.reflection.impl.member.MemberException;
import com.cefoler.configuration.exception.unchecked.unchecked.impl.reflection.UncheckedReflectionException;

public class UncheckedMemberException extends UncheckedReflectionException {

  private static final long serialVersionUID = 4684512575922190118L;

  public UncheckedMemberException(final MemberException cause) {
    super(cause);
  }

  public UncheckedMemberException(final String error, final MemberException cause) {
    super(error, cause);
  }

}
