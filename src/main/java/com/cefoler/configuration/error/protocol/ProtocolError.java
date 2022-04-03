package com.cefoler.configuration.error.protocol;

public abstract class ProtocolError extends Error {

  private static final long serialVersionUID = -16282803279587771L;

  protected ProtocolError() {
  }

  protected ProtocolError(final String error) {
    super(error);
  }

  protected ProtocolError(final Throwable cause) {
    super(cause);
  }

  protected ProtocolError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
