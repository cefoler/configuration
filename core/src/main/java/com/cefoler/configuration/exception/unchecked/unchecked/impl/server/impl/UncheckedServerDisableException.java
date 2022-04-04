package com.cefoler.configuration.exception.unchecked.unchecked.impl.server.impl;

import com.cefoler.configuration.exception.checked.server.impl.ServerDisableException;
import com.cefoler.configuration.exception.unchecked.unchecked.impl.server.UncheckedServerException;

public class UncheckedServerDisableException extends UncheckedServerException {

  private static final long serialVersionUID = 2704929855530510767L;

  public UncheckedServerDisableException(final ServerDisableException cause) {
    super(cause);
  }

  public UncheckedServerDisableException(final String error, final ServerDisableException cause) {
    super(error, cause);
  }

}
