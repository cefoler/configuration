package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.dependency;

import com.cefoler.configuration.core.exception.checked.dependency.DependencyException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;

public class UncheckedDependencyException extends UncheckedException {

  private static final long serialVersionUID = 2201047884176620543L;

  public UncheckedDependencyException(final DependencyException cause) {
    super(cause);
  }

  public UncheckedDependencyException(final String error, final DependencyException cause) {
    super(error, cause);
  }

}
