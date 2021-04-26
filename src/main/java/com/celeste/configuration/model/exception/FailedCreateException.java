package com.celeste.configuration.model.exception;

import org.jetbrains.annotations.NotNull;

/**
 * Thrown when a checked exception occurred when creating the configuration.
 */
public class FailedCreateException extends ConfigurationException {

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   */
  public FailedCreateException(@NotNull final String error) {
    super(error);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param cause Throwable
   */
  public FailedCreateException(@NotNull final Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   * @param cause Throwable
   */
  public FailedCreateException(@NotNull final String error, @NotNull final Throwable cause) {
    super(error, cause);
  }

}
