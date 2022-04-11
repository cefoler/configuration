package com.cefoler.configuration.core.exception.unchecked.number.impl;

import com.cefoler.configuration.core.exception.unchecked.number.NumberException;

public class InfinityNumberException extends NumberException {

  private static final long serialVersionUID = 2017661907487096553L;

  public InfinityNumberException() {
  }

  public InfinityNumberException(final String error) {
    super(error);
  }

  public InfinityNumberException(final Throwable cause) {
    super(cause);
  }

  public InfinityNumberException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
