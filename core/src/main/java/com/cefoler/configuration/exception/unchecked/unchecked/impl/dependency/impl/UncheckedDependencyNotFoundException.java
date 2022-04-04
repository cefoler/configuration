package com.cefoler.configuration.exception.unchecked.unchecked.impl.dependency.impl;

import com.cefoler.configuration.exception.checked.dependency.impl.DependencyNotFoundException;
import com.cefoler.configuration.exception.unchecked.unchecked.impl.dependency.UncheckedDependencyException;

public class UncheckedDependencyNotFoundException extends UncheckedDependencyException {

  private static final long serialVersionUID = 6065971447802096596L;

  public UncheckedDependencyNotFoundException(final DependencyNotFoundException cause) {
    super(cause);
  }

  public UncheckedDependencyNotFoundException(final String error,
      final DependencyNotFoundException cause) {
    super(error, cause);
  }

}
