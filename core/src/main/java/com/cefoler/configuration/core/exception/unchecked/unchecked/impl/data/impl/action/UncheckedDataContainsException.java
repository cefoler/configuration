package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.data.impl.action;

import com.cefoler.configuration.core.exception.checked.data.impl.action.DataContainsException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.data.UncheckedDataException;

public class UncheckedDataContainsException extends UncheckedDataException {

  private static final long serialVersionUID = 1659693163652520643L;

  public UncheckedDataContainsException(final DataContainsException cause) {
    super(cause);
  }

  public UncheckedDataContainsException(final String error, final DataContainsException cause) {
    super(error, cause);
  }

}
