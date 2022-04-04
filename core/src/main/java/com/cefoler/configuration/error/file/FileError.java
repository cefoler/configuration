package com.cefoler.configuration.error.file;

public abstract class FileError extends Error {

  private static final long serialVersionUID = -4914917534134791145L;

  protected FileError() {
  }

  protected FileError(final String error) {
    super(error);
  }

  protected FileError(final Throwable cause) {
    super(cause);
  }

  protected FileError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
