package com.cefoler.configuration.exception.unchecked.data.impl.action;

import com.cefoler.configuration.exception.unchecked.data.DataException;

public class DataDeleteException extends DataException {

  private static final long serialVersionUID = 3407460085353203894L;

  public DataDeleteException() {
  }

  public DataDeleteException(final String error) {
    super(error);
  }

  public DataDeleteException(final Throwable cause) {
    super(cause);
  }

  public DataDeleteException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
