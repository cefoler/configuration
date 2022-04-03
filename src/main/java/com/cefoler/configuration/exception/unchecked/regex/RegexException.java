package com.cefoler.configuration.exception.unchecked.regex;

public abstract class RegexException extends RuntimeException {

  private static final long serialVersionUID = -865731038385231220L;

  protected RegexException() {
  }

  protected RegexException(final String error) {
    super(error);
  }

  protected RegexException(final Throwable cause) {
    super(cause);
  }

  protected RegexException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
