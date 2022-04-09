package com.cefoler.configuration.core.exception.unchecked.compression.impl;

import com.cefoler.configuration.core.exception.unchecked.compression.CompressionException;

public class FailedToDecompressionException extends CompressionException {

  private static final long serialVersionUID = -971613230659542139L;

  public FailedToDecompressionException() {
  }

  public FailedToDecompressionException(final String error) {
    super(error);
  }

  public FailedToDecompressionException(final Throwable cause) {
    super(cause);
  }

  public FailedToDecompressionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
