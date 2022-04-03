package com.cefoler.configuration.exception.unchecked.data.impl;

import com.cefoler.configuration.exception.unchecked.data.DataException;

public class DataEmptyException extends DataException {

  private static final long serialVersionUID = -216315502568613043L;

  public DataEmptyException() {
  }

  public DataEmptyException(final String error) {
    super(error);
  }

  public DataEmptyException(final Throwable cause) {
    super(cause);
  }

  public DataEmptyException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
