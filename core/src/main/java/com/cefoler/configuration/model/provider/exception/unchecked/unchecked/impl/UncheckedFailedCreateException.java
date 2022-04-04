package com.cefoler.configuration.model.provider.exception.unchecked.unchecked.impl;

import com.cefoler.configuration.model.provider.exception.checked.impl.FailedCreateException;
import com.cefoler.configuration.model.provider.exception.unchecked.unchecked.UncheckedConfigurationException;

public class UncheckedFailedCreateException extends UncheckedConfigurationException {

  private static final long serialVersionUID = 6263035395717809751L;

  public UncheckedFailedCreateException(final FailedCreateException cause) {
    super(cause);
  }

  public UncheckedFailedCreateException(final String error, final FailedCreateException cause) {
    super(error, cause);
  }

}
