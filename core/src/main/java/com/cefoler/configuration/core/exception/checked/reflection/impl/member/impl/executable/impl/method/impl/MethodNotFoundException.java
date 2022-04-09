package com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.impl.method.impl;

import com.cefoler.configuration.core.exception.checked.reflection.impl.member.impl.executable.impl.method.MethodException;

public class MethodNotFoundException extends MethodException {

  private static final long serialVersionUID = 882879029663153352L;

  public MethodNotFoundException() {
  }

  public MethodNotFoundException(final String error) {
    super(error);
  }

  public MethodNotFoundException(final Throwable cause) {
    super(cause);
  }

  public MethodNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
