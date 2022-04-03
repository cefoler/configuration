package com.cefoler.configuration.exception.unchecked.file;

public abstract class FileException extends RuntimeException {

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
