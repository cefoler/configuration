package com.cefoler.configuration.core.exception.checked.data.impl.action;

import com.cefoler.configuration.core.exception.checked.data.DataException;

public class DataContainsException extends DataException {

  private static final long serialVersionUID = -8863367398486018354L;

  public DataContainsException() {
  }

  public DataContainsException(final String error) {
    super(error);
  }

  public DataContainsException(final Throwable cause) {
    super(cause);
  }

  public DataContainsException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
