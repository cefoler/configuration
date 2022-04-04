package com.cefoler.configuration.exception.unchecked.compression.impl;

import com.cefoler.configuration.exception.unchecked.compression.CompressionException;

public class InvalidCompressionException extends CompressionException {

  private static final long serialVersionUID = -8780416780496666759L;

  public InvalidCompressionException() {
  }

  public InvalidCompressionException(final String error) {
    super(error);
  }

  public InvalidCompressionException(final Throwable cause) {
    super(cause);
  }

  public InvalidCompressionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
