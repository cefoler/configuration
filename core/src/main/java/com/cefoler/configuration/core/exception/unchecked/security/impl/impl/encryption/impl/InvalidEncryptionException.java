package com.cefoler.configuration.core.exception.unchecked.security.impl.impl.encryption.impl;

import com.cefoler.configuration.core.exception.unchecked.security.impl.impl.encryption.EncryptionVulnerabilityException;

public class InvalidEncryptionException extends EncryptionVulnerabilityException {

  private static final long serialVersionUID = -1086151821670434843L;

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
