package com.cefoler.configuration.core.exception.unchecked.thread.impl;

import com.cefoler.configuration.core.exception.unchecked.thread.ThreadException;

public class SyncException extends ThreadException {

  private static final long serialVersionUID = -4969133927519564731L;

  public SyncException() {
  }

  public SyncException(final String error) {
    super(error);
  }

  public SyncException(final Throwable cause) {
    super(cause);
  }

  public SyncException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
