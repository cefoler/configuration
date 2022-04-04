package com.cefoler.configuration.exception.unchecked.dependency.impl;

import com.cefoler.configuration.exception.unchecked.dependency.DependencyException;

public class InvalidDependencyException extends DependencyException {

  private static final long serialVersionUID = -6955648702463961310L;

  public InvalidDependencyException() {
  }

  public InvalidDependencyException(final String error) {
    super(error);
  }

  public InvalidDependencyException(final Throwable cause) {
    super(cause);
  }

  public InvalidDependencyException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
