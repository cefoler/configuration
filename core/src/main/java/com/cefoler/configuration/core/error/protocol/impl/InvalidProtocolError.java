package com.cefoler.configuration.core.error.protocol.impl;

import com.cefoler.configuration.core.error.protocol.ProtocolError;

public class InvalidProtocolError extends ProtocolError {

  private static final long serialVersionUID = 9090571530345790429L;

  public InvalidProtocolError() {
  }

  public InvalidProtocolError(final String error) {
    super(error);
  }

  public InvalidProtocolError(final Throwable cause) {
    super(cause);
  }

  public InvalidProtocolError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
