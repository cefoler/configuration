package com.cefoler.configuration.core.exception.unchecked.file.impl.impl;

import com.cefoler.configuration.core.exception.unchecked.file.impl.FileRefusedException;

public class FileNotReadableException extends FileRefusedException {

  private static final long serialVersionUID = -6547820431305008033L;

  public FileNotReadableException() {
  }

  public FileNotReadableException(final String error) {
    super(error);
  }

  public FileNotReadableException(final Throwable cause) {
    super(cause);
  }

  public FileNotReadableException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
