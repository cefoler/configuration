package com.cefoler.configuration.exception;

/**
 * This class is subclass of the {@link ConfigurationException} checked exception which
 * indicates error in remote file saving.
 */
public class FailedSaveException extends ConfigurationException {

  /**
   * Create a new {@link FailedSaveException} is a checked exception that is created
   * when an error occurs when saving a remote file.
   */
  public FailedSaveException() {
    super();
  }

  /**
   * Create a new {@link FailedSaveException} is a checked exception that is created
   * when an error occurs when saving a remote file.
   *
   * @param error Error message.
   */
  public FailedSaveException(final String error) {
    super(error);
  }

  /**
   * Create a new {@link FailedSaveException} is a checked exception that is created
   * when an error occurs when saving a remote file.
   *
   * @param cause What caused the exception.
   */
  public FailedSaveException(final Throwable cause) {
    super(cause);
  }

  /**
   * Create a new {@link FailedSaveException} is a checked exception that is created
   * when an error occurs when saving a remote file.
   *
   * @param error Error message.
   * @param cause What caused the exception.
   */
  public FailedSaveException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
