package com.cefoler.configuration.exception.unchecked.unchecked.impl.user;

import com.cefoler.configuration.exception.checked.user.UserException;
import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;

public class UncheckedUserException extends UncheckedException {

  private static final long serialVersionUID = 5011483048015650291L;

  public UncheckedUserException(final UserException cause) {
    super(cause);
  }

  public UncheckedUserException(final String error, final UserException cause) {
    super(error, cause);
  }

}
