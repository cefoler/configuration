package com.cefoler.configuration.exception.unchecked.log.impl;

import com.cefoler.configuration.exception.unchecked.log.LogException;

public class LogGenerationException extends LogException {

  private static final long serialVersionUID = -1726924848503995159L;

  public LogGenerationException() {
  }

  public LogGenerationException(final String error) {
    super(error);
  }

  public LogGenerationException(final Throwable cause) {
    super(cause);
  }

  public LogGenerationException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
