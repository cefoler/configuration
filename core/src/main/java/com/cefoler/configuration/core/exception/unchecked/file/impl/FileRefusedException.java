package com.cefoler.configuration.core.exception.unchecked.file.impl;

import com.cefoler.configuration.core.exception.unchecked.file.FileException;

public class FileRefusedException extends FileException {

  private static final long serialVersionUID = 7463362529041059644L;

  public FileRefusedException() {
  }

  public FileRefusedException(final String error) {
    super(error);
  }

  public FileRefusedException(final Throwable cause) {
    super(cause);
  }

  public FileRefusedException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
