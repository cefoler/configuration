package com.cefoler.configuration.core.exception.unchecked.data.impl;

import com.cefoler.configuration.core.exception.unchecked.data.DataException;

public class DataNotReadableException extends DataException {

  private static final long serialVersionUID = -5936187110658076535L;

  public DataNotReadableException() {
  }

  public DataNotReadableException(final String error) {
    super(error);
  }

  public DataNotReadableException(final Throwable cause) {
    super(cause);
  }

  public DataNotReadableException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
