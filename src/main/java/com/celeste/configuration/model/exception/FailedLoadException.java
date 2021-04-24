package com.celeste.configuration.model.exception;

import org.jetbrains.annotations.NotNull;

public class FailedLoadException extends ConfigurationException {

  /**
   * @param error String
   */
  public FailedLoadException(@NotNull final String error) {
    super(error);
  }

  /**
   * @param cause Throwable
   */
  public FailedLoadException(@NotNull final Throwable cause) {
    super(cause);
  }

  /**
   * @param error String
   * @param cause Throwable
   */
  public FailedLoadException(@NotNull final String error, @NotNull final Throwable cause) {
    super(error, cause);
  }

}
