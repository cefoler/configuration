package com.cefoler.configuration.core.error.encryption.impl;

import com.cefoler.configuration.core.error.encryption.EncryptionError;

public class FailedToDecryptError extends EncryptionError {

  private static final long serialVersionUID = 8044014539949099811L;

  public FailedToDecryptError() {
  }

  public FailedToDecryptError(final String error) {
    super(error);
  }

  public FailedToDecryptError(final Throwable cause) {
    super(cause);
  }

  public FailedToDecryptError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
