package com.cefoler.configuration.exception.unchecked.data.impl;

import com.cefoler.configuration.exception.unchecked.data.DataException;

public class DataTooLongException extends DataException {

  private static final long serialVersionUID = 6028182189278774350L;

  public DataTooLongException() {
  }

  public DataTooLongException(final String error) {
    super(error);
  }

  public DataTooLongException(final Throwable cause) {
    super(cause);
  }

  public DataTooLongException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
