package com.cefoler.configuration.exception.unchecked.regex.impl;

import com.cefoler.configuration.exception.unchecked.regex.RegexException;

public class InvalidRegexException extends RegexException {

  private static final long serialVersionUID = -5067958932341442183L;

  public InvalidRegexException() {
  }

  public InvalidRegexException(final String error) {
    super(error);
  }

  public InvalidRegexException(final Throwable cause) {
    super(cause);
  }

  public InvalidRegexException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
