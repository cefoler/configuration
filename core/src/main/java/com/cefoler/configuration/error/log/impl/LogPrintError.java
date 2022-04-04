package com.cefoler.configuration.error.log.impl;

import com.cefoler.configuration.error.log.LogError;

public class LogPrintError extends LogError {

  private static final long serialVersionUID = 8621203346053489750L;

  public LogPrintError() {
  }

  public LogPrintError(final String error) {
    super(error);
  }

  public LogPrintError(final Throwable cause) {
    super(cause);
  }

  public LogPrintError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
