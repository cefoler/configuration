package com.cefoler.configuration.core.exception.checked.data.impl.action;

import com.cefoler.configuration.core.exception.checked.data.DataException;

public class DataSaveException extends DataException {

  private static final long serialVersionUID = 6088864013200602920L;

  public DataSaveException() {
  }

  public DataSaveException(final String error) {
    super(error);
  }

  public DataSaveException(final Throwable cause) {
    super(cause);
  }

  public DataSaveException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
