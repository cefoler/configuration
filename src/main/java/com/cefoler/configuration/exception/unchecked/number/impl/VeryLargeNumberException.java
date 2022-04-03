package com.cefoler.configuration.exception.unchecked.number.impl;

import com.cefoler.configuration.exception.unchecked.number.NumberException;

public class VeryLargeNumberException extends NumberException {

  private static final long serialVersionUID = -6877734408829966557L;

  public VeryLargeNumberException() {
  }

  public VeryLargeNumberException(final String error) {
    super(error);
  }

  public VeryLargeNumberException(final Throwable cause) {
    super(cause);
  }

  public VeryLargeNumberException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
