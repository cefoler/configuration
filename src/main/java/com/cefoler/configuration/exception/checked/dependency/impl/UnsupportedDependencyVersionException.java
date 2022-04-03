package com.cefoler.configuration.exception.checked.dependency.impl;

import com.cefoler.configuration.exception.checked.dependency.DependencyException;

public class UnsupportedDependencyVersionException extends DependencyException {

  private static final long serialVersionUID = -7818646221636760042L;

  public UnsupportedDependencyVersionException() {
  }

  public UnsupportedDependencyVersionException(final String error) {
    super(error);
  }

  public UnsupportedDependencyVersionException(final Throwable cause) {
    super(cause);
  }

  public UnsupportedDependencyVersionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
