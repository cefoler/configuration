package com.cefoler.configuration.core.error.file.impl;

import com.cefoler.configuration.core.error.file.FileError;

public class FileAlreadyExistError extends FileError {

  private static final long serialVersionUID = -3851194959802017845L;

  public FileAlreadyExistError() {
  }

  public FileAlreadyExistError(final String error) {
    super(error);
  }

  public FileAlreadyExistError(final Throwable cause) {
    super(cause);
  }

  public FileAlreadyExistError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
