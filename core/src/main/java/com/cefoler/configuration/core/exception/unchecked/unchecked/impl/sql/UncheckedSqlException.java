package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.sql;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import java.sql.SQLException;

public class UncheckedSqlException extends UncheckedException {

  private static final long serialVersionUID = -6049085626946940695L;

  public UncheckedSqlException(final SQLException cause) {
    super(cause);
  }

  public UncheckedSqlException(final String error, final SQLException cause) {
    super(error, cause);
  }

}
