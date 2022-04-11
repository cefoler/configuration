package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.io;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import java.io.IOException;

public class UncheckedIoException extends UncheckedException {

  private static final long serialVersionUID = 5472993338985048509L;

  public UncheckedIoException(final IOException cause) {
    super(cause);
  }

  public UncheckedIoException(final String error, final IOException cause) {
    super(error, cause);
  }

}
