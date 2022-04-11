package com.cefoler.configuration.core.error.log.impl;

import com.cefoler.configuration.core.error.log.LogError;

public class LogGenerationError extends LogError {

  private static final long serialVersionUID = -4146885820017737857L;

  public LogGenerationError() {
  }

  public LogGenerationError(final String error) {
    super(error);
  }

  public LogGenerationError(final Throwable cause) {
    super(cause);
  }

  public LogGenerationError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
