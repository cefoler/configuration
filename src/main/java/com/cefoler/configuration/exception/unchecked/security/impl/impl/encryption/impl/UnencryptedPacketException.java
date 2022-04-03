package com.cefoler.configuration.exception.unchecked.security.impl.impl.encryption.impl;

import com.cefoler.configuration.exception.unchecked.security.impl.impl.encryption.EncryptionVulnerabilityException;

public class UnencryptedPacketException extends EncryptionVulnerabilityException {

  private static final long serialVersionUID = -8657661257622609732L;

  public UnencryptedPacketException() {
  }

  public UnencryptedPacketException(final String error) {
    super(error);
  }

  public UnencryptedPacketException(final Throwable cause) {
    super(cause);
  }

  public UnencryptedPacketException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
