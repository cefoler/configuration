package com.cefoler.configuration.exception.unchecked.unchecked.impl.io.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.impl.io.UncheckedIoException;
import java.nio.file.FileSystemException;

public class UncheckedFileSystemException extends UncheckedIoException {

  private static final long serialVersionUID = -1468204074680508603L;

  public UncheckedFileSystemException(final FileSystemException cause) {
    super(cause);
  }

  public UncheckedFileSystemException(final String error, final FileSystemException cause) {
    super(error, cause);
  }

}
