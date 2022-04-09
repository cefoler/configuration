package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.sql.impl;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import java.sql.SQLTransientException;

public class UncheckedSqlTransientException extends UncheckedException {

  private static final long serialVersionUID = -7542960608904794082L;

  public UncheckedSqlTransientException(final SQLTransientException cause) {
    super(cause);
  }

  public UncheckedSqlTransientException(final String error, final SQLTransientException cause) {
    super(error, cause);
  }

}
