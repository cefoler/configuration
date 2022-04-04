package com.cefoler.configuration.exception.checked.file;

public abstract class FileException extends Exception {

  private static final long serialVersionUID = -5202649872461346846L;

  protected FileException() {
  }

  protected FileException(final String error) {
    super(error);
  }

  protected FileException(final Throwable cause) {
    super(cause);
  }

  protected FileException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
