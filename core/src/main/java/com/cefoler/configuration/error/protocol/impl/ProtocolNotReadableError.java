package com.cefoler.configuration.error.protocol.impl;

import com.cefoler.configuration.error.protocol.ProtocolError;

public class ProtocolNotReadableError extends ProtocolError {

  private static final long serialVersionUID = -8448868122288609600L;

  public ProtocolNotReadableError() {
  }

  public ProtocolNotReadableError(final String error) {
    super(error);
  }

  public ProtocolNotReadableError(final Throwable cause) {
    super(cause);
  }

  public ProtocolNotReadableError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
