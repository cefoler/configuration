package com.cefoler.configuration.core.exception.unchecked.protocol;

public abstract class ProtocolException extends RuntimeException {

  private static final long serialVersionUID = 3517867537986133454L;

  protected ProtocolException() {
  }

  protected ProtocolException(final String error) {
    super(error);
  }

  protected ProtocolException(final Throwable cause) {
    super(cause);
  }

  protected ProtocolException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
