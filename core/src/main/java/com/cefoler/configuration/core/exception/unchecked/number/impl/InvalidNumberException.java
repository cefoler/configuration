package com.cefoler.configuration.core.exception.unchecked.number.impl;

import com.cefoler.configuration.core.exception.unchecked.number.NumberException;

public class InvalidNumberException extends NumberException {

  private static final long serialVersionUID = 2686602989219853121L;

  public InvalidNumberException() {
  }

  public InvalidNumberException(final String error) {
    super(error);
  }

  public InvalidNumberException(final Throwable cause) {
    super(cause);
  }

  public InvalidNumberException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
