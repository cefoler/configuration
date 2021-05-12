package com.celeste.configuration.model.exception;

/**
 * Thrown when a checked exception occurred when creating the configuration.
 */
public class FailedCreateException extends ConfigurationException {

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   */
  public FailedCreateException(final String error) {
    super(error);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param cause Throwable
   */
  public FailedCreateException(final Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   * @param cause Throwable
   */
  public FailedCreateException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
