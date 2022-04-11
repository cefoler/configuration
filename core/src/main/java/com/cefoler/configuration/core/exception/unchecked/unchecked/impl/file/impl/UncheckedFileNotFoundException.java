package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.file.impl;

import com.cefoler.configuration.core.exception.checked.file.impl.FileNotFoundException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.file.UncheckedFileException;

public class UncheckedFileNotFoundException extends UncheckedFileException {

  private static final long serialVersionUID = -4793932757296534493L;

  public UncheckedFileNotFoundException(final FileNotFoundException cause) {
    super(cause);
  }

  public UncheckedFileNotFoundException(final String error, final FileNotFoundException cause) {
    super(error, cause);
  }

}
