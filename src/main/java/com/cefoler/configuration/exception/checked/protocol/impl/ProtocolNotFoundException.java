package com.cefoler.configuration.exception.checked.protocol.impl;

import com.cefoler.configuration.exception.checked.protocol.ProtocolException;

public class ProtocolNotFoundException extends ProtocolException {

  private static final long serialVersionUID = 4974670651402510369L;

  public ProtocolNotFoundException() {
  }

  public ProtocolNotFoundException(final String error) {
    super(error);
  }

  public ProtocolNotFoundException(final Throwable cause) {
    super(cause);
  }

  public ProtocolNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
