package com.cefoler.configuration.core.exception.unchecked.log;

public abstract class LogException extends RuntimeException {

  private static final long serialVersionUID = -5427647236194651738L;

  protected LogException() {
  }

  protected LogException(final String error) {
    super(error);
  }

  protected LogException(final Throwable cause) {
    super(cause);
  }

  protected LogException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
