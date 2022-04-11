package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.data.impl;

import com.cefoler.configuration.core.exception.checked.data.impl.DataNotFoundException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.data.UncheckedDataException;

public class UncheckedDataNotFoundException extends UncheckedDataException {

  private static final long serialVersionUID = 5593752526684610480L;

  public UncheckedDataNotFoundException(final DataNotFoundException cause) {
    super(cause);
  }

  public UncheckedDataNotFoundException(final String error, final DataNotFoundException cause) {
    super(error, cause);
  }

}
