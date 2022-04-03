package com.cefoler.configuration.exception.unchecked.unchecked.impl.dependency;

import com.cefoler.configuration.exception.checked.dependency.DependencyException;
import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;

public class UncheckedDependencyException extends UncheckedException {

  private static final long serialVersionUID = 2201047884176620543L;

  public UncheckedDependencyException(final DependencyException cause) {
    super(cause);
  }

  public UncheckedDependencyException(final String error, final DependencyException cause) {
    super(error, cause);
  }

}
