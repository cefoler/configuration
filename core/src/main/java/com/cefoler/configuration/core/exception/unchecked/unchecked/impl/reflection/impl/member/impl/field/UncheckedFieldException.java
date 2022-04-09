package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.member.impl.field;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.field.FieldException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.member.UncheckedMemberException;

public class UncheckedFieldException extends UncheckedMemberException {

  private static final long serialVersionUID = -2638539558390797059L;

  public UncheckedFieldException(final FieldException cause) {
    super(cause);
  }

  public UncheckedFieldException(final String error, final FieldException cause) {
    super(error, cause);
  }

}
