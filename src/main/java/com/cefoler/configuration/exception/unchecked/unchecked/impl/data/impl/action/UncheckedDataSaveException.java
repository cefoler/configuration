package com.cefoler.configuration.exception.unchecked.unchecked.impl.data.impl.action;

import com.cefoler.configuration.exception.checked.data.impl.action.DataSaveException;
import com.cefoler.configuration.exception.unchecked.unchecked.impl.data.UncheckedDataException;

public class UncheckedDataSaveException extends UncheckedDataException {

  private static final long serialVersionUID = 488032973577392989L;

  public UncheckedDataSaveException(final DataSaveException cause) {
    super(cause);
  }

  public UncheckedDataSaveException(final String error, final DataSaveException cause) {
    super(error, cause);
  }

}
