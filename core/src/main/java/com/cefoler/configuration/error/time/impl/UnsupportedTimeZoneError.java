package com.cefoler.configuration.error.time.impl;

import com.cefoler.configuration.error.time.TimeError;

public class UnsupportedTimeZoneError extends TimeError {

  private static final long serialVersionUID = 1338921612052027875L;

  public UnsupportedTimeZoneError() {
  }

  public UnsupportedTimeZoneError(final String error) {
    super(error);
  }

  public UnsupportedTimeZoneError(final Throwable cause) {
    super(cause);
  }

  public UnsupportedTimeZoneError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
