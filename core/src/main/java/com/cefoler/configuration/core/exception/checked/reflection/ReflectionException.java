package com.cefoler.configuration.core.exception.checked.reflection;

public abstract class ReflectionException extends Exception {

  private static final long serialVersionUID = -4253279523759428968L;

  protected ReflectionException() {
  }

  protected ReflectionException(final String error) {
    super(error);
  }

  protected ReflectionException(final Throwable cause) {
    super(cause);
  }

  protected ReflectionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
