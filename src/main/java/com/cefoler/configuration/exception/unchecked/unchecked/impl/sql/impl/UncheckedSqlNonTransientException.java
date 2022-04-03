package com.cefoler.configuration.exception.unchecked.unchecked.impl.sql.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import java.sql.SQLNonTransientException;

public class UncheckedSqlNonTransientException extends UncheckedException {

  private static final long serialVersionUID = 1788847511577208845L;

  public UncheckedSqlNonTransientException(final SQLNonTransientException cause) {
    super(cause);
  }

  public UncheckedSqlNonTransientException(final String error,
      final SQLNonTransientException cause) {
    super(error, cause);
  }

}
