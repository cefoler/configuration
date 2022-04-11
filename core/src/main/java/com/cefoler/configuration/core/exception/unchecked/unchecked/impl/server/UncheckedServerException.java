package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.server;

import com.cefoler.configuration.core.exception.checked.server.ServerException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;

public class UncheckedServerException extends UncheckedException {

  private static final long serialVersionUID = 4881674484880967748L;

  public UncheckedServerException(final ServerException cause) {
    super(cause);
  }

  public UncheckedServerException(final String error, final ServerException cause) {
    super(error, cause);
  }

}
