package com.cefoler.configuration.exception.checked.data.impl.action;

import com.cefoler.configuration.exception.checked.data.DataException;

public class DataDeleteException extends DataException {

  private static final long serialVersionUID = 6295578878096554131L;

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
