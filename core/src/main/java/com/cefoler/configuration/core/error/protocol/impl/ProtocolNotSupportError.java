package com.cefoler.configuration.core.error.protocol.impl;

import com.cefoler.configuration.core.error.protocol.ProtocolError;

public class ProtocolNotSupportError extends ProtocolError {

  private static final long serialVersionUID = 8450783740807487312L;

  public ProtocolNotSupportError() {
  }

  public ProtocolNotSupportError(final String error) {
    super(error);
  }

  public ProtocolNotSupportError(final Throwable cause) {
    super(cause);
  }

  public ProtocolNotSupportError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
