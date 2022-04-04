package com.cefoler.configuration.exception.unchecked.unchecked.impl.file;

import com.cefoler.configuration.exception.checked.file.FileException;
import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;

public class UncheckedFileException extends UncheckedException {

  private static final long serialVersionUID = 2234894293208220630L;

  public UncheckedFileException(final FileException cause) {
    super(cause);
  }

  public UncheckedFileException(final String error, final FileException cause) {
    super(error, cause);
  }

}
