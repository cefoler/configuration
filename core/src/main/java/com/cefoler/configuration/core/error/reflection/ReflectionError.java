package com.cefoler.configuration.core.error.reflection;

public abstract class ReflectionError extends Error {

  private static final long serialVersionUID = -2148828503296513390L;

  protected ReflectionError() {
  }

  protected ReflectionError(final String error) {
    super(error);
  }

  protected ReflectionError(final Throwable cause) {
    super(cause);
  }

  protected ReflectionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
