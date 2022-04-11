package com.cefoler.configuration.core.exception.unchecked.time.impl;

import com.cefoler.configuration.core.exception.unchecked.time.TimeException;

public class InvalidTimeException extends TimeException {

  private static final long serialVersionUID = -4259655433151491901L;

  public InvalidTimeException() {
  }

  public InvalidTimeException(final String error) {
    super(error);
  }

  public InvalidTimeException(final Throwable cause) {
    super(cause);
  }

  public InvalidTimeException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
