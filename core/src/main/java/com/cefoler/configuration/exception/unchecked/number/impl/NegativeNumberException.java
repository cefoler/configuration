package com.cefoler.configuration.exception.unchecked.number.impl;

import com.cefoler.configuration.exception.unchecked.number.NumberException;

public class NegativeNumberException extends NumberException {

  private static final long serialVersionUID = 3098383144498835179L;

  public NegativeNumberException() {
  }

  public NegativeNumberException(final String error) {
    super(error);
  }

  public NegativeNumberException(final Throwable cause) {
    super(cause);
  }

  public NegativeNumberException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
