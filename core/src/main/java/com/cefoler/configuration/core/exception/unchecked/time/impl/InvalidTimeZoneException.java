package com.cefoler.configuration.core.exception.unchecked.time.impl;

import com.cefoler.configuration.core.exception.unchecked.time.TimeException;

public class InvalidTimeZoneException extends TimeException {

  private static final long serialVersionUID = -8850976001578363686L;

  public InvalidTimeZoneException() {
  }

  public InvalidTimeZoneException(final String error) {
    super(error);
  }

  public InvalidTimeZoneException(final Throwable cause) {
    super(cause);
  }

  public InvalidTimeZoneException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
