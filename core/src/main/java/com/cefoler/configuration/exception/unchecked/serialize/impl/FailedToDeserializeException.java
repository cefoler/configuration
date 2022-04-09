package com.cefoler.configuration.exception.unchecked.serialize.impl;

import com.cefoler.configuration.exception.unchecked.serialize.SerializationException;

public class FailedToDeserializeException extends SerializationException {

  private static final long serialVersionUID = 2072750213473731433L;

  public FailedToDeserializeException() {
  }

  public FailedToDeserializeException(final String error) {
    super(error);
  }

  public FailedToDeserializeException(final Throwable cause) {
    super(cause);
  }

  public FailedToDeserializeException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
