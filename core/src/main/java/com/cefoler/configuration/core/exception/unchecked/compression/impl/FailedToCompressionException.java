package com.cefoler.configuration.core.exception.unchecked.compression.impl;

import com.cefoler.configuration.core.exception.unchecked.compression.CompressionException;

public class FailedToCompressionException extends CompressionException {

  private static final long serialVersionUID = 4594165481189045641L;

  public FailedToCompressionException() {
  }

  public FailedToCompressionException(final String error) {
    super(error);
  }

  public FailedToCompressionException(final Throwable cause) {
    super(cause);
  }

  public FailedToCompressionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
