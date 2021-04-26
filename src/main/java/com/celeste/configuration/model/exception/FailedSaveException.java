package com.celeste.configuration.model.exception;

import org.jetbrains.annotations.NotNull;

/**
 * Thrown when a checked exception occurred while saving the configuration.
 * <p></p>
 * It is usually thrown when the configuration is not found
 */
public class FailedSaveException extends ConfigurationException {

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   */
  public FailedSaveException(@NotNull final String error) {
    super(error);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param cause Throwable
   */
  public FailedSaveException(@NotNull final Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new ConfigurationException.
   *
   * @param error String
   * @param cause Throwable
   */
  public FailedSaveException(@NotNull final String error, @NotNull final Throwable cause) {
    super(error, cause);
  }

}
