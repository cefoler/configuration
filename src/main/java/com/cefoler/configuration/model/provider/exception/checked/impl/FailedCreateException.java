package com.cefoler.configuration.model.provider.exception.checked.impl;

import com.cefoler.configuration.model.provider.exception.checked.ConfigurationException;

public class FailedCreateException extends ConfigurationException {

  private static final long serialVersionUID = 7895715137033778074L;

  public FailedCreateException() {
  }

  public FailedCreateException(final String error) {
    super(error);
  }

  public FailedCreateException(final Throwable cause) {
    super(cause);
  }

  public FailedCreateException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
