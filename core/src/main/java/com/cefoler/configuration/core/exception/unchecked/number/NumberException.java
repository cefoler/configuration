package com.cefoler.configuration.core.exception.unchecked.number;

public abstract class NumberException extends RuntimeException {

  private static final long serialVersionUID = 8203998358223665609L;

  protected NumberException() {
  }

  protected NumberException(final String error) {
    super(error);
  }

  protected NumberException(final Throwable cause) {
    super(cause);
  }

  protected NumberException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
