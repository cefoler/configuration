package com.cefoler.configuration.core.error.encryption;

public abstract class EncryptionError extends Error {

  private static final long serialVersionUID = 6647018465419529766L;

  protected EncryptionError() {
  }

  protected EncryptionError(final String error) {
    super(error);
  }

  protected EncryptionError(final Throwable cause) {
    super(cause);
  }

  protected EncryptionError(final String error, final Throwable cause) {
    super(error, cause);
  }

}
