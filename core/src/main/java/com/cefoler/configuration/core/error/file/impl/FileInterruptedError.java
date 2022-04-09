package com.cefoler.configuration.core.error.file.impl;

import com.cefoler.configuration.core.error.file.FileError;

public class FileInterruptedError extends FileError {

  private static final long serialVersionUID = -6752324090456669077L;

  public FileInterruptedError() {
  }

  public FileInterruptedError(final String error) {
    super(error);
  }

  public FileInterruptedError(final Throwable cause) {
    super(cause);
  }

  public FileInterruptedError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
