package com.celeste.configuration.model.exception;

import com.celeste.configuration.model.provider.Configuration;

/**
 * This class is a checked Exception which indicates some error from everything
 * related to {@link Configuration}.
 *
 * @see Configuration
 * @see Exception
 */
public class ConfigurationException extends Exception {

  /**
   * Create a new {@link ConfigurationException} is a checked exception that is created
   * when an error occurs in the configuration.
   */
  public ConfigurationException() {
    super();
  }

  /**
   * Create a new {@link ConfigurationException} is a checked exception that is created
   * when an error occurs in the configuration.
   *
   * @param error Error message.
   */
  public ConfigurationException(final String error) {
    super(error);
  }

  /**
   * Create a new {@link ConfigurationException} is a checked exception that is created
   * when an error occurs in the configuration.
   *
   * @param cause What caused the exception.
   */
  public ConfigurationException(final Throwable cause) {
    super(cause);
  }

  /**
   * Create a new {@link ConfigurationException} is a checked exception that is created
   * when an error occurs in the configuration.
   *
   * @param error Error message.
   * @param cause What caused the exception.
   */
  public ConfigurationException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
