package com.cefoler.configuration.core.exception.unchecked.file.impl;

import com.cefoler.configuration.core.exception.unchecked.file.FileException;

public class FileAlreadyExistException extends FileException {

  private static final long serialVersionUID = -864022735298513979L;

  public FileAlreadyExistException() {
  }

  public FileAlreadyExistException(final String error) {
    super(error);
  }

  public FileAlreadyExistException(final Throwable cause) {
    super(cause);
  }

  public FileAlreadyExistException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
