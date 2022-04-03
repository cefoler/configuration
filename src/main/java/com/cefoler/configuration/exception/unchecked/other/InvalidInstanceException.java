package com.cefoler.configuration.exception.unchecked.other;

public class InvalidInstanceException extends RuntimeException {

  private static final long serialVersionUID = -4456272236276612416L;

  public InvalidInstanceException() {
  }

  public InvalidInstanceException(final String error) {
    super(error);
  }

  public InvalidInstanceException(final Throwable cause) {
    super(cause);
  }

  public InvalidInstanceException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
