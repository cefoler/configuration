package com.cefoler.configuration.core.error.compression.impl;

import com.cefoler.configuration.core.error.compression.CompressionError;

public class FailedToCompressionError extends CompressionError {

  private static final long serialVersionUID = 8878376790260899761L;

  public FailedToCompressionError() {
  }

  public FailedToCompressionError(final String error) {
    super(error);
  }

  public FailedToCompressionError(final Throwable cause) {
    super(cause);
  }

  public FailedToCompressionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
