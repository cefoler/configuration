package com.cefoler.configuration.core.exception.unchecked.other;

public class ArrayFullException extends RuntimeException {

  private static final long serialVersionUID = 1256159369185700410L;

  public ArrayFullException() {
  }

  public ArrayFullException(final String error) {
    super(error);
  }

  public ArrayFullException(final Throwable cause) {
    super(cause);
  }

  public ArrayFullException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
