package com.cefoler.configuration.core.exception.unchecked.serialize;

public abstract class SerializationException extends RuntimeException {

  private static final long serialVersionUID = -2759173607201112186L;

  protected SerializationException() {
  }

  protected SerializationException(final String error) {
    super(error);
  }

  protected SerializationException(final Throwable cause) {
    super(cause);
  }

  protected SerializationException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
