package com.cefoler.configuration.exception.unchecked.data.impl;

import com.cefoler.configuration.exception.unchecked.data.DataException;

public class InvalidDataException extends DataException {

  private static final long serialVersionUID = -4916873739012121019L;

  public InvalidDataException() {
  }

  public InvalidDataException(final String error) {
    super(error);
  }

  public InvalidDataException(final Throwable cause) {
    super(cause);
  }

  public InvalidDataException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
