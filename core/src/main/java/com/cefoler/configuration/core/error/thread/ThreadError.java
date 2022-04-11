package com.cefoler.configuration.core.error.thread;

public abstract class ThreadError extends Error {

  private static final long serialVersionUID = -4583928190930717301L;

  protected ThreadError() {
  }

  protected ThreadError(final String error) {
    super(error);
  }

  protected ThreadError(final Throwable cause) {
    super(cause);
  }

  protected ThreadError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
