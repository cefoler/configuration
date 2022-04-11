package com.cefoler.configuration.core.exception.unchecked.thread;

public abstract class ThreadException extends RuntimeException {

  private static final long serialVersionUID = -3340807704708326562L;

  protected ThreadException() {
  }

  protected ThreadException(final String error) {
    super(error);
  }

  protected ThreadException(final Throwable cause) {
    super(cause);
  }

  protected ThreadException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
