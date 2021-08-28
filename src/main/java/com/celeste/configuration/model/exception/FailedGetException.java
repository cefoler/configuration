package com.celeste.configuration.model.exception;

import com.celeste.configuration.model.provider.Configuration;

/**
 * This class is subclass of the {@link RuntimeException} unchecked exception which
 * indicates error in getting {@link Configuration} data.
 *
 * @see Configuration
 * @see RuntimeException
 */
public class FailedGetException extends RuntimeException {

  /**
   * Creating a new {@link FailedGetException} is an unchecked exception created when it occurs
   * while getting {@link Configuration} data.
   */
  public FailedGetException() {
    super();
  }

  /**
   * Creating a new {@link FailedGetException} is an unchecked exception created when it occurs
   * while getting {@link Configuration} data.
   *
   * @param error Error message.
   */
  public FailedGetException(final String error) {
    super(error);
  }

  /**
   * Creating a new {@link FailedGetException} is an unchecked exception created when it occurs
   * while getting {@link Configuration} data.
   *
   * @param cause What caused the exception.
   */
  public FailedGetException(final Throwable cause) {
    super(cause);
  }

  /**
   * Creating a new {@link FailedGetException} is an unchecked exception created when it occurs
   * while getting {@link Configuration} data.
   *
   * @param error Error message.
   * @param cause What caused the exception.
   */
  public FailedGetException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
