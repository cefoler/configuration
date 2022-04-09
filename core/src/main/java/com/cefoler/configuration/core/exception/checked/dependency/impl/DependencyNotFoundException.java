package com.cefoler.configuration.core.exception.checked.dependency.impl;

import com.cefoler.configuration.core.exception.checked.dependency.DependencyException;

public class DependencyNotFoundException extends DependencyException {

  private static final long serialVersionUID = -4440074277469432972L;

  public DependencyNotFoundException() {
  }

  public DependencyNotFoundException(final String error) {
    super(error);
  }

  public DependencyNotFoundException(final Throwable cause) {
    super(cause);
  }

  public DependencyNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
