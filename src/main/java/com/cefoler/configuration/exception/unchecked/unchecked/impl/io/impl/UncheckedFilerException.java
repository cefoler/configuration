package com.cefoler.configuration.exception.unchecked.unchecked.impl.io.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.impl.io.UncheckedIoException;
import javax.annotation.processing.FilerException;

public class UncheckedFilerException extends UncheckedIoException {

  private static final long serialVersionUID = 2920811267780688658L;

  public UncheckedFilerException(final FilerException cause) {
    super(cause);
  }

  public UncheckedFilerException(final String error, final FilerException cause) {
    super(error, cause);
  }

}
