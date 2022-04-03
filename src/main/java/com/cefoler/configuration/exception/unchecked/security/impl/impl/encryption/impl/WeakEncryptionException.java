package com.cefoler.configuration.exception.unchecked.security.impl.impl.encryption.impl;

import com.cefoler.configuration.exception.unchecked.security.impl.impl.encryption.EncryptionVulnerabilityException;

public class WeakEncryptionException extends EncryptionVulnerabilityException {

  private static final long serialVersionUID = -8657661257622609732L;

  public WeakEncryptionException() {
  }

  public WeakEncryptionException(final String error) {
    super(error);
  }

  public WeakEncryptionException(final Throwable cause) {
    super(cause);
  }

  public WeakEncryptionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
