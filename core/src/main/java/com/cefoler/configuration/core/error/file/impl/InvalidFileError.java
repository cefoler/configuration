package com.cefoler.configuration.core.error.file.impl;

import com.cefoler.configuration.core.error.file.FileError;

public class InvalidFileError extends FileError {

  private static final long serialVersionUID = 705025550618748588L;

  public InvalidFileError() {
  }

  public InvalidFileError(final String error) {
    super(error);
  }

  public InvalidFileError(final Throwable cause) {
    super(cause);
  }

  public InvalidFileError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
