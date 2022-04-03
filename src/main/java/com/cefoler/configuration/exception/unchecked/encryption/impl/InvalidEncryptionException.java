package com.cefoler.configuration.exception.unchecked.encryption.impl;

import com.cefoler.configuration.exception.unchecked.encryption.EncryptionException;

public class InvalidEncryptionException extends EncryptionException {

  private static final long serialVersionUID = 3683885158152583837L;

  public InvalidEncryptionException() {
  }

  public InvalidEncryptionException(final String error) {
    super(error);
  }

  public InvalidEncryptionException(final Throwable cause) {
    super(cause);
  }

  public InvalidEncryptionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
