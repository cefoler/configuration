package com.cefoler.configuration.core.exception.unchecked.number.impl;

import com.cefoler.configuration.core.exception.unchecked.number.NumberException;

public class PositiveNumberException extends NumberException {

  private static final long serialVersionUID = -1518148814158770446L;

  public PositiveNumberException() {
  }

  public PositiveNumberException(final String error) {
    super(error);
  }

  public PositiveNumberException(final Throwable cause) {
    super(cause);
  }

  public PositiveNumberException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
