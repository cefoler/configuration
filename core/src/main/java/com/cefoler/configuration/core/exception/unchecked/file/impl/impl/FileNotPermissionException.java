package com.cefoler.configuration.core.exception.unchecked.file.impl.impl;

import com.cefoler.configuration.core.exception.unchecked.file.impl.FileRefusedException;

public class FileNotPermissionException extends FileRefusedException {

  private static final long serialVersionUID = 8772219358854519765L;

  public FileNotPermissionException() {
  }

  public FileNotPermissionException(final String error) {
    super(error);
  }

  public FileNotPermissionException(final Throwable cause) {
    super(cause);
  }

  public FileNotPermissionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
