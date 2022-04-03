package com.cefoler.configuration.exception.unchecked.unchecked.impl.server.impl;

import com.cefoler.configuration.exception.checked.server.impl.ServerLoadException;
import com.cefoler.configuration.exception.unchecked.unchecked.impl.server.UncheckedServerException;

public class UncheckedServerLoadException extends UncheckedServerException {

  private static final long serialVersionUID = 5171406841973609885L;

  public UncheckedServerLoadException(final ServerLoadException cause) {
    super(cause);
  }

  public UncheckedServerLoadException(final String error, final ServerLoadException cause) {
    super(error, cause);
  }

}
