package com.cefoler.configuration.core.exception.checked.time.impl;

import com.cefoler.configuration.core.exception.checked.time.TimeException;

public class UnsupportedTimeZoneException extends TimeException {

  private static final long serialVersionUID = -1037865604777994446L;

  public UnsupportedTimeZoneException() {
  }

  public UnsupportedTimeZoneException(final String error) {
    super(error);
  }

  public UnsupportedTimeZoneException(final Throwable cause) {
    super(cause);
  }

  public UnsupportedTimeZoneException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
