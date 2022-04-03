package com.cefoler.configuration.exception.unchecked.data.impl.action;

import com.cefoler.configuration.exception.unchecked.data.DataException;

public class DataSaveException extends DataException {

  private static final long serialVersionUID = -2630924630845980978L;

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
