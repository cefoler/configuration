package com.cefoler.configuration.core.exception.unchecked.data;

public abstract class DataException extends RuntimeException {

  private static final long serialVersionUID = 5618245855925016456L;

  protected DataException() {
  }

  protected DataException(final String error) {
    super(error);
  }

  protected DataException(final Throwable cause) {
    super(cause);
  }

  protected DataException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
