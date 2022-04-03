package com.cefoler.configuration.exception.unchecked.unchecked.impl.sql.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import javax.sql.rowset.serial.SerialException;

public class UncheckedSerialException extends UncheckedException {

  private static final long serialVersionUID = 6033372537805081152L;

  public UncheckedSerialException(final SerialException cause) {
    super(cause);
  }

  public UncheckedSerialException(final String error, final SerialException cause) {
    super(error, cause);
  }

}
