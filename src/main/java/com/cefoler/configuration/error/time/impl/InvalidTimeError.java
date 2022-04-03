package com.cefoler.configuration.error.time.impl;

import com.cefoler.configuration.error.time.TimeError;

public class InvalidTimeError extends TimeError {

  private static final long serialVersionUID = 7717592583437924219L;

  public InvalidTimeError() {
  }

  public InvalidTimeError(final String error) {
    super(error);
  }

  public InvalidTimeError(final Throwable cause) {
    super(cause);
  }

  public InvalidTimeError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
