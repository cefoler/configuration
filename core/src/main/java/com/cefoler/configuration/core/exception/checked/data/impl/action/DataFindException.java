package com.cefoler.configuration.core.exception.checked.data.impl.action;

import com.cefoler.configuration.core.exception.checked.data.DataException;

public class DataFindException extends DataException {

  private static final long serialVersionUID = -6300287855350008750L;

  public DataFindException() {
  }

  public DataFindException(final String error) {
    super(error);
  }

  public DataFindException(final Throwable cause) {
    super(cause);
  }

  public DataFindException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
