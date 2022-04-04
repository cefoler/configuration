package com.cefoler.configuration.exception.checked.data;

public abstract class DataException extends Exception {

  private static final long serialVersionUID = 5143138378768203585L;

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
