package com.cefoler.configuration.core.exception.unchecked.protocol.impl;

import com.cefoler.configuration.core.exception.unchecked.protocol.ProtocolException;

public class ProtocolNotReadableException extends ProtocolException {

  private static final long serialVersionUID = -7339361677363502198L;

  public ProtocolNotReadableException() {
  }

  public ProtocolNotReadableException(final String error) {
    super(error);
  }

  public ProtocolNotReadableException(final Throwable cause) {
    super(cause);
  }

  public ProtocolNotReadableException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
