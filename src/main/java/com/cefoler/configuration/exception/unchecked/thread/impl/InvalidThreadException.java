package com.cefoler.configuration.exception.unchecked.thread.impl;

import com.cefoler.configuration.exception.unchecked.thread.ThreadException;

public class InvalidThreadException extends ThreadException {

  private static final long serialVersionUID = -6529560379056182419L;

  public InvalidThreadException() {
  }

  public InvalidThreadException(final String error) {
    super(error);
  }

  public InvalidThreadException(final Throwable cause) {
    super(cause);
  }

  public InvalidThreadException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
