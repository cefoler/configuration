package com.cefoler.configuration.core.error.file.impl;

import com.cefoler.configuration.core.error.file.FileError;

public class FileNotFoundError extends FileError {

  private static final long serialVersionUID = 1478718787828552455L;

  public FileNotFoundError() {
  }

  public FileNotFoundError(final String error) {
    super(error);
  }

  public FileNotFoundError(final Throwable cause) {
    super(cause);
  }

  public FileNotFoundError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
