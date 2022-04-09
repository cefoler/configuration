package com.cefoler.configuration.core.error.time.impl;

import com.cefoler.configuration.core.error.time.TimeError;

public class InvalidTimeZoneError extends TimeError {

  private static final long serialVersionUID = 1146314856604701105L;

  public InvalidTimeZoneError() {
  }

  public InvalidTimeZoneError(final String error) {
    super(error);
  }

  public InvalidTimeZoneError(final Throwable cause) {
    super(cause);
  }

  public InvalidTimeZoneError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
