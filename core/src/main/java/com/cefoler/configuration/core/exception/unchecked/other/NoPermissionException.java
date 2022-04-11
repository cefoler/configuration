package com.cefoler.configuration.core.exception.unchecked.other;

public class NoPermissionException extends RuntimeException {

  private static final long serialVersionUID = 2955302714427102908L;

  public NoPermissionException() {
  }

  public NoPermissionException(final String error) {
    super(error);
  }

  public NoPermissionException(final Throwable cause) {
    super(cause);
  }

  public NoPermissionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
