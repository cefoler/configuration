package com.cefoler.configuration.model.provider.exception.checked.impl;

import com.cefoler.configuration.model.provider.exception.checked.ConfigurationException;

public class FailedLoadException extends ConfigurationException {

  private static final long serialVersionUID = -4826482816455094999L;

  public FailedLoadException() {
  }

  public FailedLoadException(final String error) {
    super(error);
  }

  public FailedLoadException(final Throwable cause) {
    super(cause);
  }

  public FailedLoadException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
