package com.cefoler.configuration.exception.unchecked.unchecked.impl.io.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.impl.io.UncheckedIoException;
import java.nio.channels.FileLockInterruptionException;

public class UncheckedFileLockInterruptionException extends UncheckedIoException {

  private static final long serialVersionUID = 2951254638601571140L;

  public UncheckedFileLockInterruptionException(final FileLockInterruptionException cause) {
    super(cause);
  }

  public UncheckedFileLockInterruptionException(final String error,
      final FileLockInterruptionException cause) {
    super(error, cause);
  }

}
