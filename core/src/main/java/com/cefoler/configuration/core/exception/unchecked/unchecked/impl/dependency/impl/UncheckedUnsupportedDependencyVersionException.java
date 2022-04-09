package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.dependency.impl;

import com.cefoler.configuration.core.exception.checked.dependency.impl.UnsupportedDependencyVersionException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.dependency.UncheckedDependencyException;

public class UncheckedUnsupportedDependencyVersionException extends UncheckedDependencyException {

  private static final long serialVersionUID = -1278253050742613957L;

  public UncheckedUnsupportedDependencyVersionException(
      final UnsupportedDependencyVersionException cause) {
    super(cause);
  }

  public UncheckedUnsupportedDependencyVersionException(final String error,
      final UnsupportedDependencyVersionException cause) {
    super(error, cause);
  }

}
