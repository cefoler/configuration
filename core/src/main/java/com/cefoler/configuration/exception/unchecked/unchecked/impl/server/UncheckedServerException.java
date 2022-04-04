package com.cefoler.configuration.exception.unchecked.unchecked.impl.server;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import com.cefoler.configuration.exception.checked.server.ServerException;

public class UncheckedServerException extends UncheckedException {

  private static final long serialVersionUID = 4881674484880967748L;

  public UncheckedServerException(final ServerException cause) {
    super(cause);
  }

  public UncheckedServerException(final String error, final ServerException cause) {
    super(error, cause);
  }

}
