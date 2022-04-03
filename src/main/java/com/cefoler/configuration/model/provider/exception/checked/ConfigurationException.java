package com.cefoler.configuration.model.provider.exception.checked;

import com.cefoler.configuration.exception.checked.file.FileException;

public abstract class ConfigurationException extends FileException {

  private static final long serialVersionUID = 5963892945275318232L;

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
