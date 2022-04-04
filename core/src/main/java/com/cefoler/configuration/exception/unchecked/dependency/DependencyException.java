package com.cefoler.configuration.exception.unchecked.dependency;

public abstract class DependencyException extends RuntimeException {

  private static final long serialVersionUID = 2602328224595045978L;

  protected DependencyException() {
  }

  protected DependencyException(final String error) {
    super(error);
  }

  protected DependencyException(final Throwable cause) {
    super(cause);
  }

  protected DependencyException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
