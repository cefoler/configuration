package com.cefoler.configuration.core.exception.unchecked.encryption.impl;

import com.cefoler.configuration.core.exception.unchecked.encryption.EncryptionException;

public class FailedToDecryptException extends EncryptionException {

  private static final long serialVersionUID = 3822535819845776253L;

  public FailedToDecryptException() {
  }

  public FailedToDecryptException(final String error) {
    super(error);
  }

  public FailedToDecryptException(final Throwable cause) {
    super(cause);
  }

  public FailedToDecryptException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
