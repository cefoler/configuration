package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.member.impl.field.impl;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.field.impl.FieldNotFoundException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.member.UncheckedMemberException;

public class UncheckedFieldNotFoundException extends UncheckedMemberException {

  private static final long serialVersionUID = -4008322490490267411L;

  public UncheckedFieldNotFoundException(final FieldNotFoundException cause) {
    super(cause);
  }

  public UncheckedFieldNotFoundException(final String error, final FieldNotFoundException cause) {
    super(error, cause);
  }

}
