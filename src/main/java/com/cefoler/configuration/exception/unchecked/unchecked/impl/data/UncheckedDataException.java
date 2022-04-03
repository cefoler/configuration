package com.cefoler.configuration.exception.unchecked.unchecked.impl.data;

import com.cefoler.configuration.exception.checked.data.DataException;
import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;

public class UncheckedDataException extends UncheckedException {

  private static final long serialVersionUID = -4407087877996662698L;

  public UncheckedDataException(final DataException cause) {
    super(cause);
  }

  public UncheckedDataException(final String error, final DataException cause) {
    super(error, cause);
  }

}
