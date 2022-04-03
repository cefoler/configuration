package com.cefoler.configuration.model.provider.exception.unchecked.unchecked;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import com.cefoler.configuration.model.provider.exception.checked.ConfigurationException;

public class UncheckedConfigurationException extends UncheckedException {

  private static final long serialVersionUID = -7991830697995239307L;

  public UncheckedConfigurationException(final ConfigurationException cause) {
    super(cause);
  }

  public UncheckedConfigurationException(final String error, final ConfigurationException cause) {
    super(error, cause);
  }

}
