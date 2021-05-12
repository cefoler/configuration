package com.celeste.configuration.model.exception;

/**
 * Thrown when an unchecked exception occurred while getting some configuration data.
 * <p></p>
 * It is usually thrown when a data is not found.
 */
public class FailedGetException extends RuntimeException {

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   */
  public FailedGetException(final String error) {
    super(error);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param cause Throwable
   */
  public FailedGetException(final Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   * @param cause Throwable
   */
  public FailedGetException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
