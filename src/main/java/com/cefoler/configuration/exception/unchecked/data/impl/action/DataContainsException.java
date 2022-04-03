package com.cefoler.configuration.exception.unchecked.data.impl.action;

import com.cefoler.configuration.exception.unchecked.data.DataException;

public class DataContainsException extends DataException {

  private static final long serialVersionUID = 4458179945863015305L;

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
