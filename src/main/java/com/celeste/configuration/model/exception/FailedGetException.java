package com.celeste.configuration.model.exception;

import org.jetbrains.annotations.NotNull;

public class FailedGetException extends RuntimeException {

  /**
   * @param error String
   */
  public FailedGetException(@NotNull final String error) {
    super(error);
  }

  /**
   * @param cause Throwable
   */
  public FailedGetException(@NotNull final Throwable cause) {
    super(cause);
  }

  /**
   * @param error String
   * @param cause Throwable
   */
  public FailedGetException(@NotNull final String error, @NotNull final Throwable cause) {
    super(error, cause);
  }

}
