package com.cefoler.configuration.exception;

/**
 * This class is subclass of the {@link ConfigurationException} checked exception which
 * indicates error in remote file loading.
 */
public class FailedLoadException extends ConfigurationException {

  /**
   * Create a new {@link FailedLoadException} is a checked exception that is created
   * when an error occurs when loading a remote file.
   */
  public FailedLoadException() {
    super();
  }

  /**
   * Create a new {@link FailedLoadException} is a checked exception that is created
   * when an error occurs when loading a remote file.
   *
   * @param error Error message.
   */
  public FailedLoadException(final String error) {
    super(error);
  }

  /**
   * Create a new {@link FailedLoadException} is a checked exception that is created
   * when an error occurs when loading a remote file.
   *
   * @param cause What caused the exception.
   */
  public FailedLoadException(final Throwable cause) {
    super(cause);
  }

  /**
   * Create a new {@link FailedLoadException} is a checked exception that is created
   * when an error occurs when loading a remote file.
   *
   * @param error Error message.
   * @param cause What caused the exception.
   */
  public FailedLoadException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
