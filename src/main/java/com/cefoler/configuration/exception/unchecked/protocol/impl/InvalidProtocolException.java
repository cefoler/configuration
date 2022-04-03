package com.cefoler.configuration.exception.unchecked.protocol.impl;

import com.cefoler.configuration.exception.unchecked.protocol.ProtocolException;

public class InvalidProtocolException extends ProtocolException {

  private static final long serialVersionUID = 5733296436552531750L;

  public InvalidProtocolException() {
  }

  public InvalidProtocolException(final String error) {
    super(error);
  }

  public InvalidProtocolException(final Throwable cause) {
    super(cause);
  }

  public InvalidProtocolException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
