package com.cefoler.configuration.exception.unchecked.unchecked.impl.other;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;

public class UncheckedCloneNotSupportedException extends UncheckedException {

  private static final long serialVersionUID = 884768660760573686L;

  public UncheckedCloneNotSupportedException(final CloneNotSupportedException cause) {
    super(cause);
  }

  public UncheckedCloneNotSupportedException(final String error,
      final CloneNotSupportedException cause) {
    super(error, cause);
  }

}
