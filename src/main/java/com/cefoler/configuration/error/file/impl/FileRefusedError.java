package com.cefoler.configuration.error.file.impl;

import com.cefoler.configuration.error.file.FileError;

public class FileRefusedError extends FileError {

  private static final long serialVersionUID = -4818091594695565811L;

  public FileRefusedError() {
  }

  public FileRefusedError(final String error) {
    super(error);
  }

  public FileRefusedError(final Throwable cause) {
    super(cause);
  }

  public FileRefusedError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
