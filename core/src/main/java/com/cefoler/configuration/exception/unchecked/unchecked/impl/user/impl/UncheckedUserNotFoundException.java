package com.cefoler.configuration.exception.unchecked.unchecked.impl.user.impl;

import com.cefoler.configuration.exception.checked.user.impl.UserNotFoundException;
import com.cefoler.configuration.exception.unchecked.unchecked.impl.user.UncheckedUserException;

public class UncheckedUserNotFoundException extends UncheckedUserException {

  private static final long serialVersionUID = -9175540644005685073L;

  public UncheckedUserNotFoundException(final UserNotFoundException cause) {
    super(cause);
  }

  public UncheckedUserNotFoundException(final String error, final UserNotFoundException cause) {
    super(error, cause);
  }

}
