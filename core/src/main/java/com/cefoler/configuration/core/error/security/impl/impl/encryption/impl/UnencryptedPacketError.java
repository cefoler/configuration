package com.cefoler.configuration.core.error.security.impl.impl.encryption.impl;

import com.cefoler.configuration.core.error.security.impl.impl.encryption.EncryptionVulnerabilityError;

public class UnencryptedPacketError extends EncryptionVulnerabilityError {

  private static final long serialVersionUID = -8657661257622609732L;

  public UnencryptedPacketError() {
  }

  public UnencryptedPacketError(final String error) {
    super(error);
  }

  public UnencryptedPacketError(final Throwable cause) {
    super(cause);
  }

  public UnencryptedPacketError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
