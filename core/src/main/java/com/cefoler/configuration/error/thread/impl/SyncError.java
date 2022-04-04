package com.cefoler.configuration.error.thread.impl;

import com.cefoler.configuration.error.thread.ThreadError;

public class SyncError extends ThreadError {

  private static final long serialVersionUID = 1905657041929833311L;

  public SyncError() {
  }

  public SyncError(final String error) {
    super(error);
  }

  public SyncError(final Throwable cause) {
    super(cause);
  }

  public SyncError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
