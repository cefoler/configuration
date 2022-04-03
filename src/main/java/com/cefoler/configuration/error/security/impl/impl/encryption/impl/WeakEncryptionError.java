package com.cefoler.configuration.error.security.impl.impl.encryption.impl;

import com.cefoler.configuration.error.security.impl.impl.encryption.EncryptionVulnerabilityError;

public class WeakEncryptionError extends EncryptionVulnerabilityError {

  private static final long serialVersionUID = -8657661257622609732L;

  public WeakEncryptionError() {
  }

  public WeakEncryptionError(final String error) {
    super(error);
  }

  public WeakEncryptionError(final Throwable cause) {
    super(cause);
  }

  public WeakEncryptionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
