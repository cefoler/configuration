package com.celeste.configuration.model.exception;

/**
 * Thrown when a checked exception occurred in the configuration.
 */
public class ConfigurationException extends Exception {

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   */
  public ConfigurationException(final String error) {
    super(error);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param cause Throwable
   */
  public ConfigurationException(final Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   * @param cause Throwable
   */
  public ConfigurationException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
