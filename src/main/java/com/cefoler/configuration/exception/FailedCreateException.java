package com.cefoler.configuration.exception;

/**
 * This class is subclass of the {@link ConfigurationException} checked exception which
 * indicates error in remote file creation.
 *
 * @see ConfigurationException
 */
public class FailedCreateException extends ConfigurationException {

  /**
   * Create a new {@link FailedCreateException} is a checked exception that is created
   * when an error occurs when creating a remote file.
   */
  public FailedCreateException() {
    super();
  }

  /**
   * Create a new {@link FailedCreateException} is a checked exception that is created
   * when an error occurs when creating a remote file.
   *
   * @param error Error message.
   */
  public FailedCreateException(final String error) {
    super(error);
  }

  /**
   * Create a new {@link FailedCreateException} is a checked exception that is created
   * when an error occurs when creating a remote file.
   *
   * @param cause What caused the exception.
   */
  public FailedCreateException(final Throwable cause) {
    super(cause);
  }

  /**
   * Create a new {@link FailedCreateException} is a checked exception that is created
   * when an error occurs when creating a remote file.
   *
   * @param error Error message.
   * @param cause What caused the exception.
   */
  public FailedCreateException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
