package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.protocol.impl;

import com.cefoler.configuration.core.exception.checked.protocol.impl.ProtocolNotFoundException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.protocol.UncheckedProtocolException;

public class UncheckedProtocolNotFoundException extends UncheckedProtocolException {

  private static final long serialVersionUID = -8072923516640182210L;

  public UncheckedProtocolNotFoundException(final ProtocolNotFoundException cause) {
    super(cause);
  }

  public UncheckedProtocolNotFoundException(final String error,
      final ProtocolNotFoundException cause) {
    super(error, cause);
  }

}
