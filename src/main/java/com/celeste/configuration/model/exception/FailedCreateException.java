package com.celeste.configuration.model.exception;

import org.jetbrains.annotations.NotNull;

public class FailedCreateException extends ConfigurationException {

  /**
   * @param error String
   */
  public FailedCreateException(@NotNull final String error) {
    super(error);
  }

  /**
   * @param cause Throwable
   */
  public FailedCreateException(@NotNull final Throwable cause) {
    super(cause);
  }

  /**
   * @param error String
   * @param cause Throwable
   */
  public FailedCreateException(@NotNull final String error, @NotNull final Throwable cause) {
    super(error, cause);
  }

}
