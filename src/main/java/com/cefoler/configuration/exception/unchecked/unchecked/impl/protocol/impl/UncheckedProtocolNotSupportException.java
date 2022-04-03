package com.cefoler.configuration.exception.unchecked.unchecked.impl.protocol.impl;

import com.cefoler.configuration.exception.checked.protocol.impl.ProtocolNotSupportException;
import com.cefoler.configuration.exception.unchecked.unchecked.impl.protocol.UncheckedProtocolException;

public class UncheckedProtocolNotSupportException extends UncheckedProtocolException {

  private static final long serialVersionUID = 4653109059090510379L;

  public UncheckedProtocolNotSupportException(final ProtocolNotSupportException cause) {
    super(cause);
  }

  public UncheckedProtocolNotSupportException(final String error,
      final ProtocolNotSupportException cause) {
    super(error, cause);
  }

}
