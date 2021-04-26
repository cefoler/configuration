package com.celeste.configuration.model.exception;

import org.jetbrains.annotations.NotNull;

/**
 * Thrown when a checked exception occurred in the configuration.
 */
public class ConfigurationException extends Exception {

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   */
  public ConfigurationException(@NotNull final String error) {
    super(error);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param cause Throwable
   */
  public ConfigurationException(@NotNull final Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   * @param cause Throwable
   */
  public ConfigurationException(@NotNull final String error, @NotNull final Throwable cause) {
    super(error, cause);
  }

}
