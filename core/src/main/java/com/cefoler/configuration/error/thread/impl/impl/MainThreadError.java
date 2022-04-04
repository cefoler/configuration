package com.cefoler.configuration.error.thread.impl.impl;

import com.cefoler.configuration.error.thread.impl.SyncError;

public class MainThreadError extends SyncError {

  private static final long serialVersionUID = -531430328719056240L;

  public MainThreadError() {
  }

  public MainThreadError(final String error) {
    super(error);
  }

  public MainThreadError(final Throwable cause) {
    super(cause);
  }

  public MainThreadError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
