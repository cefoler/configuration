package com.cefoler.configuration.core.exception.checked.data.impl;

import com.cefoler.configuration.core.exception.checked.data.DataException;

public class DataNotFoundException extends DataException {

  private static final long serialVersionUID = -1623129295170945885L;

  public DataNotFoundException() {
  }

  public DataNotFoundException(final String error) {
    super(error);
  }

  public DataNotFoundException(final Throwable cause) {
    super(cause);
  }

  public DataNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
