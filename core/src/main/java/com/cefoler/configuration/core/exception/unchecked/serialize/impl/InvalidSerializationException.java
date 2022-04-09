package com.cefoler.configuration.core.exception.unchecked.serialize.impl;

import com.cefoler.configuration.core.exception.unchecked.serialize.SerializationException;

public class InvalidSerializationException extends SerializationException {

  private static final long serialVersionUID = -2467138680649881125L;

  public InvalidSerializationException() {
  }

  public InvalidSerializationException(final String error) {
    super(error);
  }

  public InvalidSerializationException(final Throwable cause) {
    super(cause);
  }

  public InvalidSerializationException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
