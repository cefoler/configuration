package com.cefoler.configuration.core.exception.checked.protocol.impl;

import com.cefoler.configuration.core.exception.checked.protocol.ProtocolException;

public class ProtocolNotSupportException extends ProtocolException {

  private static final long serialVersionUID = -2315399887956133888L;

  public ProtocolNotSupportException() {
  }

  public ProtocolNotSupportException(final String error) {
    super(error);
  }

  public ProtocolNotSupportException(final Throwable cause) {
    super(cause);
  }

  public ProtocolNotSupportException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
