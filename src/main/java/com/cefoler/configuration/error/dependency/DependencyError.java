package com.cefoler.configuration.error.dependency;

public abstract class DependencyError extends Error {

  private static final long serialVersionUID = 160256112256423510L;

  protected DependencyError() {
  }

  protected DependencyError(final String error) {
    super(error);
  }

  protected DependencyError(final Throwable cause) {
    super(cause);
  }

  protected DependencyError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
