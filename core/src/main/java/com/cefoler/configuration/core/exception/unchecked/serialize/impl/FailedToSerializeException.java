package com.cefoler.configuration.core.exception.unchecked.serialize.impl;

import com.cefoler.configuration.core.exception.unchecked.serialize.SerializationException;

public class FailedToSerializeException extends SerializationException {

  private static final long serialVersionUID = -4448857971813000595L;

  public FailedToSerializeException() {
  }

  public FailedToSerializeException(final String error) {
    super(error);
  }

  public FailedToSerializeException(final Throwable cause) {
    super(cause);
  }

  public FailedToSerializeException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
