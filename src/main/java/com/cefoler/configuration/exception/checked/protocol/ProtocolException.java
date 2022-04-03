package com.cefoler.configuration.exception.checked.protocol;

public abstract class ProtocolException extends Exception {

  private static final long serialVersionUID = 293820273286369970L;

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
