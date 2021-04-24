package com.celeste.configuration.model.exception;

import org.jetbrains.annotations.NotNull;

public class ConfigurationException extends Exception {

  /**
   * @param error String
   */
  public ConfigurationException(@NotNull final String error) {
    super(error);
  }

  /**
   * @param cause Throwable
   */
  public ConfigurationException(@NotNull final Throwable cause) {
    super(cause);
  }

  /**
   * @param error String
   * @param cause Throwable
   */
  public ConfigurationException(@NotNull final String error, @NotNull final Throwable cause) {
    super(error, cause);
  }

}
