package com.cefoler.configuration.exception.checked.time;

public abstract class TimeException extends Exception {

  private static final long serialVersionUID = 5061544128029336551L;

  protected TimeException() {
  }

  protected TimeException(final String error) {
    super(error);
  }

  protected TimeException(final Throwable cause) {
    super(cause);
  }

  protected TimeException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
