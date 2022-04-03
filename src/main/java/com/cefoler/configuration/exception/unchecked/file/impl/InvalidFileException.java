package com.cefoler.configuration.exception.unchecked.file.impl;

import com.cefoler.configuration.exception.unchecked.file.FileException;

public class InvalidFileException extends FileException {

  private static final long serialVersionUID = 2599559318506047088L;

  public InvalidFileException() {
  }

  public InvalidFileException(final String error) {
    super(error);
  }

  public InvalidFileException(final Throwable cause) {
    super(cause);
  }

  public InvalidFileException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
