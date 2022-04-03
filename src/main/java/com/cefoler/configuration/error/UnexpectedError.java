package com.cefoler.configuration.error;

public class UnexpectedError extends Error {

  private static final long serialVersionUID = 3957890885497587056L;

  public UnexpectedError() {
  }

  public UnexpectedError(final String error) {
    super(error);
  }

  public UnexpectedError(final Throwable cause) {
    super(cause);
  }

  public UnexpectedError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
