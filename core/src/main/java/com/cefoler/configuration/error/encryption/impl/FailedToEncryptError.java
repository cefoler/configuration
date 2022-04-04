package com.cefoler.configuration.error.encryption.impl;

import com.cefoler.configuration.error.encryption.EncryptionError;

public class FailedToEncryptError extends EncryptionError {

  private static final long serialVersionUID = 3036657357024384920L;

  public FailedToEncryptError() {
  }

  public FailedToEncryptError(final String error) {
    super(error);
  }

  public FailedToEncryptError(final Throwable cause) {
    super(cause);
  }

  public FailedToEncryptError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
