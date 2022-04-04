package com.cefoler.configuration.exception.checked.reflection.impl.clazz.impl;

import com.cefoler.configuration.exception.checked.reflection.impl.clazz.ClassException;

public class ClassNotFoundException extends ClassException {

  private static final long serialVersionUID = -2628447195023709241L;

  public ClassNotFoundException() {
  }

  public ClassNotFoundException(final String error) {
    super(error);
  }

  public ClassNotFoundException(final Throwable cause) {
    super(cause);
  }

  public ClassNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
