package com.cefoler.configuration.error.dependency.impl;

import com.cefoler.configuration.error.dependency.DependencyError;

public class UnsupportedDependencyVersionError extends DependencyError {

  private static final long serialVersionUID = 4704430179594970143L;

  public UnsupportedDependencyVersionError() {
  }

  public UnsupportedDependencyVersionError(final String error) {
    super(error);
  }

  public UnsupportedDependencyVersionError(final Throwable cause) {
    super(cause);
  }

  public UnsupportedDependencyVersionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
