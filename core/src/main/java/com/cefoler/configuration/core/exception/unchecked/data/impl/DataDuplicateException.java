package com.cefoler.configuration.core.exception.unchecked.data.impl;

import com.cefoler.configuration.core.exception.unchecked.data.DataException;

public class DataDuplicateException extends DataException {

  private static final long serialVersionUID = -4076863440612986504L;

  public DataDuplicateException() {
  }

  public DataDuplicateException(final String error) {
    super(error);
  }

  public DataDuplicateException(final Throwable cause) {
    super(cause);
  }

  public DataDuplicateException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
