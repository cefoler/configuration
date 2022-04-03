package com.cefoler.configuration.exception.unchecked.log.impl;

import com.cefoler.configuration.exception.unchecked.log.LogException;

public class LogPrintException extends LogException {

  private static final long serialVersionUID = -7659705335201480677L;

  public LogPrintException() {
  }

  public LogPrintException(final String error) {
    super(error);
  }

  public LogPrintException(final Throwable cause) {
    super(cause);
  }

  public LogPrintException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
