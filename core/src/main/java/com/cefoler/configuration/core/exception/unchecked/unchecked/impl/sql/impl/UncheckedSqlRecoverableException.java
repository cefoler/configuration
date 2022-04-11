package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.sql.impl;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import java.sql.SQLRecoverableException;

public class UncheckedSqlRecoverableException extends UncheckedException {

  private static final long serialVersionUID = -4648361895641808554L;

  public UncheckedSqlRecoverableException(final SQLRecoverableException cause) {
    super(cause);
  }

  public UncheckedSqlRecoverableException(final String error, final SQLRecoverableException cause) {
    super(error, cause);
  }

}
