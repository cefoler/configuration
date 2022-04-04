package com.cefoler.configuration.exception.unchecked.unchecked.impl.server.impl;

import com.cefoler.configuration.exception.checked.server.impl.ServerNotFoundException;
import com.cefoler.configuration.exception.unchecked.unchecked.impl.server.UncheckedServerException;

public class UncheckedServerNotFoundException extends UncheckedServerException {

  private static final long serialVersionUID = -7703366253767076854L;

  public UncheckedServerNotFoundException(final ServerNotFoundException cause) {
    super(cause);
  }

  public UncheckedServerNotFoundException(final String error, final ServerNotFoundException cause) {
    super(error, cause);
  }

}
