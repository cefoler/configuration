package com.cefoler.configuration.error.protocol.impl;

import com.cefoler.configuration.error.protocol.ProtocolError;

public class ProtocolNotFoundError extends ProtocolError {

  private static final long serialVersionUID = -5373884582848705906L;

  public ProtocolNotFoundError() {
  }

  public ProtocolNotFoundError(final String error) {
    super(error);
  }

  public ProtocolNotFoundError(final Throwable cause) {
    super(cause);
  }

  public ProtocolNotFoundError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
