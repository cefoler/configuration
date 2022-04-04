package com.cefoler.configuration.exception.unchecked.unchecked.impl.protocol;

import com.cefoler.configuration.exception.checked.protocol.ProtocolException;
import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;

public class UncheckedProtocolException extends UncheckedException {

  private static final long serialVersionUID = -3831506721505374201L;

  public UncheckedProtocolException(final ProtocolException cause) {
    super(cause);
  }

  public UncheckedProtocolException(final String error, final ProtocolException cause) {
    super(error, cause);
  }

}
