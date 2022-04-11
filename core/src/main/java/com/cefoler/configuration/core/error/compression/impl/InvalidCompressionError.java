package com.cefoler.configuration.core.error.compression.impl;

import com.cefoler.configuration.core.error.compression.CompressionError;

public class InvalidCompressionError extends CompressionError {

  private static final long serialVersionUID = -1122320182550918105L;

  public InvalidCompressionError() {
  }

  public InvalidCompressionError(final String error) {
    super(error);
  }

  public InvalidCompressionError(final Throwable cause) {
    super(cause);
  }

  public InvalidCompressionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
