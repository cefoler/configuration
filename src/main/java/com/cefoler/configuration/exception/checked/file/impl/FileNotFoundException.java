package com.cefoler.configuration.exception.checked.file.impl;

import com.cefoler.configuration.exception.checked.file.FileException;

public class FileNotFoundException extends FileException {

  private static final long serialVersionUID = -7022560753640283364L;

  public FileNotFoundException() {
  }

  public FileNotFoundException(final String error) {
    super(error);
  }

  public FileNotFoundException(final Throwable cause) {
    super(cause);
  }

  public FileNotFoundException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
