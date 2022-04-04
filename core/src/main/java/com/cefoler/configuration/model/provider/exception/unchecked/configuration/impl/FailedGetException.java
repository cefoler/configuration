package com.cefoler.configuration.model.provider.exception.unchecked.configuration.impl;

import com.cefoler.configuration.model.provider.exception.unchecked.configuration.ConfigurationException;

public class FailedGetException extends ConfigurationException {

  private static final long serialVersionUID = 1734886666846652091L;

  public FailedGetException() {
  }

  public FailedGetException(final String error) {
    super(error);
  }

  public FailedGetException(final Throwable cause) {
    super(cause);
  }

  public FailedGetException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
