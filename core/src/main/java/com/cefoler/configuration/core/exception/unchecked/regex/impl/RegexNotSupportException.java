package com.cefoler.configuration.core.exception.unchecked.regex.impl;

import com.cefoler.configuration.core.exception.unchecked.regex.RegexException;

public class RegexNotSupportException extends RegexException {

  private static final long serialVersionUID = -654339888160561499L;

  public RegexNotSupportException() {
  }

  public RegexNotSupportException(final String error) {
    super(error);
  }

  public RegexNotSupportException(final Throwable cause) {
    super(cause);
  }

  public RegexNotSupportException(final String error, final Throwable cause) {
    super(error, cause);
  }

}
