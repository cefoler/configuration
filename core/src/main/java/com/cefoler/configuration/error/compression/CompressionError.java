package com.cefoler.configuration.error.compression;

public abstract class CompressionError extends Error {

  private static final long serialVersionUID = 7472920785950007683L;

  protected CompressionError() {
  }

  protected CompressionError(final String error) {
    super(error);
  }

  protected CompressionError(final Throwable cause) {
    super(cause);
  }

  protected CompressionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
