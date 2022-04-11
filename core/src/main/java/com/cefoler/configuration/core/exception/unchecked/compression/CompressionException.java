package com.cefoler.configuration.core.exception.unchecked.compression;

public abstract class CompressionException extends RuntimeException {

  private static final long serialVersionUID = -8333992574034615084L;

  protected CompressionException() {
  }

  protected CompressionException(final String error) {
    super(error);
  }

  protected CompressionException(final Throwable cause) {
    super(cause);
  }

  protected CompressionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
