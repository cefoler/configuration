package com.celeste.configuration.model.exception;

import org.jetbrains.annotations.NotNull;

/**
 * Thrown when a checked exception occurred while loading the configuration.
 * <p></p>
 * It is usually thrown when the configuration is not found
 */
public class FailedLoadException extends ConfigurationException {

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   */
  public FailedLoadException(@NotNull final String error) {
    super(error);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param cause Throwable
   */
  public FailedLoadException(@NotNull final Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   * @param cause Throwable
   */
  public FailedLoadException(@NotNull final String error, @NotNull final Throwable cause) {
    super(error, cause);
  }

}
