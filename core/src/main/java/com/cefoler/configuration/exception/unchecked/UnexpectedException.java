package com.cefoler.configuration.exception.unchecked;

public class UnexpectedException extends RuntimeException {

  private static final long serialVersionUID = -5490912478091415429L;

  public UnexpectedException() {
  }

  public UnexpectedException(final String error) {
    super(error);
  }

  public UnexpectedException(final Throwable cause) {
    super(cause);
  }

  public UnexpectedException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
