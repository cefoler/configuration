package com.cefoler.configuration.exception.unchecked.file.impl;

import com.cefoler.configuration.exception.unchecked.file.FileException;

public class FileInterruptedException extends FileException {

  private static final long serialVersionUID = 4064969938395507639L;

  public FileInterruptedException() {
  }

  public FileInterruptedException(final String error) {
    super(error);
  }

  public FileInterruptedException(final Throwable cause) {
    super(cause);
  }

  public FileInterruptedException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
