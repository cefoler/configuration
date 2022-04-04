package com.cefoler.configuration.exception.unchecked.thread.impl.impl;

import com.cefoler.configuration.exception.unchecked.thread.impl.SyncException;

public class MainThreadException extends SyncException {

  private static final long serialVersionUID = 7573332306189651820L;

  public MainThreadException() {
  }

  public MainThreadException(final String error) {
    super(error);
  }

  public MainThreadException(final Throwable cause) {
    super(cause);
  }

  public MainThreadException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
