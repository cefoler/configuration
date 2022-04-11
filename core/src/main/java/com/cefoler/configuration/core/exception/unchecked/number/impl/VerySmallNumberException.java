package com.cefoler.configuration.core.exception.unchecked.number.impl;

import com.cefoler.configuration.core.exception.unchecked.number.NumberException;

public class VerySmallNumberException extends NumberException {

  private static final long serialVersionUID = -4089527252332258206L;

  public VerySmallNumberException() {
  }

  public VerySmallNumberException(final String error) {
    super(error);
  }

  public VerySmallNumberException(final Throwable cause) {
    super(cause);
  }

  public VerySmallNumberException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
