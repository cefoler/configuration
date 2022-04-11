package com.cefoler.configuration.core.error.encryption.impl;

import com.cefoler.configuration.core.error.encryption.EncryptionError;

public class InvalidEncryptionError extends EncryptionError {

  private static final long serialVersionUID = -7217615132648365908L;

  public InvalidEncryptionError() {
  }

  public InvalidEncryptionError(final String error) {
    super(error);
  }

  public InvalidEncryptionError(final Throwable cause) {
    super(cause);
  }

  public InvalidEncryptionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
