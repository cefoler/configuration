package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.data.impl.action;

import com.cefoler.configuration.core.exception.checked.data.impl.action.DataFindException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.data.UncheckedDataException;

public class UncheckedDataFindException extends UncheckedDataException {

  private static final long serialVersionUID = 6735173665111470257L;

  public UncheckedDataFindException(final DataFindException cause) {
    super(cause);
  }

  public UncheckedDataFindException(final String error, final DataFindException cause) {
    super(error, cause);
  }

}
