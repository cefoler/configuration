package com.cefoler.configuration.model.provider.exception.unchecked.unchecked.impl;

import com.cefoler.configuration.model.provider.exception.checked.impl.FailedLoadException;
import com.cefoler.configuration.model.provider.exception.unchecked.unchecked.UncheckedConfigurationException;

public class UncheckedFailedLoadException extends UncheckedConfigurationException {

  private static final long serialVersionUID = 10068512342271531L;

  public UncheckedFailedLoadException(final FailedLoadException cause) {
    super(cause);
  }

  public UncheckedFailedLoadException(final String error, final FailedLoadException cause) {
    super(error, cause);
  }

}
