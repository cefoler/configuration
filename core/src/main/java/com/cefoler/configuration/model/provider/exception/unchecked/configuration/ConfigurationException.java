package com.cefoler.configuration.model.provider.exception.unchecked.configuration;

import com.cefoler.configuration.exception.unchecked.file.FileException;

public abstract class ConfigurationException extends FileException {

  private static final long serialVersionUID = -275181546127009839L;

  protected ConfigurationException() {
  }

  protected ConfigurationException(final String error) {
    super(error);
  }

  protected ConfigurationException(final Throwable cause) {
    super(cause);
  }

  protected ConfigurationException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
