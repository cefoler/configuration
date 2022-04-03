package com.cefoler.configuration.error.compression.impl;

import com.cefoler.configuration.error.compression.CompressionError;

public class FailedToDecompressionError extends CompressionError {

  private static final long serialVersionUID = -2506125845925746735L;

  public FailedToDecompressionError() {
  }

  public FailedToDecompressionError(final String error) {
    super(error);
  }

  public FailedToDecompressionError(final Throwable cause) {
    super(cause);
  }

  public FailedToDecompressionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
