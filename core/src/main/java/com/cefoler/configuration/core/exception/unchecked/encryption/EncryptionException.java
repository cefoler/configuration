package com.cefoler.configuration.core.exception.unchecked.encryption;

public abstract class EncryptionException extends RuntimeException {

  private static final long serialVersionUID = 4246900230653119314L;

  protected EncryptionException() {
  }

  protected EncryptionException(final String error) {
    super(error);
  }

  protected EncryptionException(final Throwable cause) {
    super(cause);
  }

  protected EncryptionException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
