package com.cefoler.configuration.exception.unchecked.thread.impl;

import com.cefoler.configuration.exception.unchecked.thread.ThreadException;

public class ThreadInterruptedException extends ThreadException {

  private static final long serialVersionUID = 5788065197057141966L;

  public ThreadInterruptedException() {
  }

  public ThreadInterruptedException(final String error) {
    super(error);
  }

  public ThreadInterruptedException(final Throwable cause) {
    super(cause);
  }

  public ThreadInterruptedException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
