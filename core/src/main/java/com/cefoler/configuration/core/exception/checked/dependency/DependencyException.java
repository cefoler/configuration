package com.cefoler.configuration.core.exception.checked.dependency;

public abstract class DependencyException extends Exception {

  private static final long serialVersionUID = -2228135832412737451L;

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
