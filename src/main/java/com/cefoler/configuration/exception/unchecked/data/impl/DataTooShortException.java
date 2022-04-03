package com.cefoler.configuration.exception.unchecked.data.impl;

import com.cefoler.configuration.exception.unchecked.data.DataException;

public class DataTooShortException extends DataException {

  private static final long serialVersionUID = -4008888453279101956L;

  public DataTooShortException() {
  }

  public DataTooShortException(final String error) {
    super(error);
  }

  public DataTooShortException(final Throwable cause) {
    super(cause);
  }

  public DataTooShortException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
