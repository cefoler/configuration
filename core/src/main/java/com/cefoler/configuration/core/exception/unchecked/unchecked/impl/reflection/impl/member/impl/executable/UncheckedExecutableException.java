package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.member.impl.executable;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.ExecutableException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.reflection.impl.member.UncheckedMemberException;

public class UncheckedExecutableException extends UncheckedMemberException {

  private static final long serialVersionUID = 778187107196259634L;

  public UncheckedExecutableException(final ExecutableException cause) {
    super(cause);
  }

  public UncheckedExecutableException(final String error, final ExecutableException cause) {
    super(error, cause);
  }

}
