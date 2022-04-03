package com.cefoler.configuration.exception.unchecked.encryption.impl;

import com.cefoler.configuration.exception.unchecked.encryption.EncryptionException;

public class FailedToEncryptException extends EncryptionException {

  private static final long serialVersionUID = 4731336660288395546L;

  public FailedToEncryptException() {
  }

  public FailedToEncryptException(final String error) {
    super(error);
  }

  public FailedToEncryptException(final Throwable cause) {
    super(cause);
  }

  public FailedToEncryptException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
