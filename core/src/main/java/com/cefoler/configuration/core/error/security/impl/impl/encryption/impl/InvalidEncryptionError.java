package com.cefoler.configuration.core.error.security.impl.impl.encryption.impl;

import com.cefoler.configuration.core.error.security.impl.impl.encryption.EncryptionVulnerabilityError;

public class InvalidEncryptionError extends EncryptionVulnerabilityError {

  private static final long serialVersionUID = -1086151821670434843L;

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
