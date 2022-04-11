package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.time.impl;

import com.cefoler.configuration.core.exception.checked.time.impl.UnsupportedTimeZoneException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.time.UncheckedTimeException;

public class UncheckedUnsupportedTimeZoneException extends UncheckedTimeException {

  private static final long serialVersionUID = 8805037190956978111L;

  public UncheckedUnsupportedTimeZoneException(final UnsupportedTimeZoneException cause) {
    super(cause);
  }

  public UncheckedUnsupportedTimeZoneException(final String error,
      final UnsupportedTimeZoneException cause) {
    super(error, cause);
  }

}
