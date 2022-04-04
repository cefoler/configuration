package com.cefoler.configuration.exception.unchecked.unchecked.impl.io.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.impl.io.UncheckedIoException;
import java.io.FileNotFoundException;

public class UncheckedFileNotFoundException extends UncheckedIoException {

  private static final long serialVersionUID = -435281806988080967L;

  public UncheckedFileNotFoundException(final FileNotFoundException cause) {
    super(cause);
  }

  public UncheckedFileNotFoundException(final String error, final FileNotFoundException cause) {
    super(error, cause);
  }

}
