package com.cefoler.configuration.core.exception.unchecked.unchecked;

public class UncheckedException extends RuntimeException {

  private static final long serialVersionUID = 3130442049179596029L;

  public UncheckedException(final Exception cause) {
    super(cause);
  }

  public UncheckedException(final String error, final Exception cause) {
    super(error, cause);
  }

}
