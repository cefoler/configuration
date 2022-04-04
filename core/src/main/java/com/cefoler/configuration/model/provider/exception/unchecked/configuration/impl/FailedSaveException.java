package com.cefoler.configuration.model.provider.exception.unchecked.configuration.impl;

import com.cefoler.configuration.model.provider.exception.unchecked.configuration.ConfigurationException;

public class FailedSaveException extends ConfigurationException {

  private static final long serialVersionUID = -7321310553633992099L;

  public FailedSaveException() {
  }

  public FailedSaveException(final String error) {
    super(error);
  }

  public FailedSaveException(final Throwable cause) {
    super(cause);
  }

  public FailedSaveException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
