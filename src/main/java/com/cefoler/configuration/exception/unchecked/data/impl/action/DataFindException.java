package com.cefoler.configuration.exception.unchecked.data.impl.action;

import com.cefoler.configuration.exception.unchecked.data.DataException;

public class DataFindException extends DataException {

  private static final long serialVersionUID = 1667390804588902071L;

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
