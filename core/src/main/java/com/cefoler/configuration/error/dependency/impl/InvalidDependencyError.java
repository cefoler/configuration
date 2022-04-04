package com.cefoler.configuration.error.dependency.impl;

import com.cefoler.configuration.error.dependency.DependencyError;

public class InvalidDependencyError extends DependencyError {

  private static final long serialVersionUID = -6342744410958025103L;

  public InvalidDependencyError() {
  }

  public InvalidDependencyError(final String error) {
    super(error);
  }

  public InvalidDependencyError(final Throwable cause) {
    super(cause);
  }

  public InvalidDependencyError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
