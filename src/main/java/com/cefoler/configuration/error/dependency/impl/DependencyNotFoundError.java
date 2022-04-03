package com.cefoler.configuration.error.dependency.impl;

import com.cefoler.configuration.error.dependency.DependencyError;

public class DependencyNotFoundError extends DependencyError {

  private static final long serialVersionUID = 3337722235585108062L;

  public DependencyNotFoundError() {
  }

  public DependencyNotFoundError(final String error) {
    super(error);
  }

  public DependencyNotFoundError(final Throwable cause) {
    super(cause);
  }

  public DependencyNotFoundError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
