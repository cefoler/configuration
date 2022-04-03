package com.cefoler.configuration.exception.unchecked.unchecked.impl.server.impl;

import com.cefoler.configuration.exception.checked.server.impl.ServerEnableException;
import com.cefoler.configuration.exception.unchecked.unchecked.impl.server.UncheckedServerException;

public class UncheckedServerEnableException extends UncheckedServerException {

  private static final long serialVersionUID = 3958757986166665652L;

  public UncheckedServerEnableException(final ServerEnableException cause) {
    super(cause);
  }

  public UncheckedServerEnableException(final String error, final ServerEnableException cause) {
    super(error, cause);
  }

}
