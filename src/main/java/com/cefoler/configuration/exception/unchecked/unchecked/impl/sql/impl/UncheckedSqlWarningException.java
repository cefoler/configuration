package com.cefoler.configuration.exception.unchecked.unchecked.impl.sql.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import java.sql.SQLWarning;

public class UncheckedSqlWarningException extends UncheckedException {

  private static final long serialVersionUID = 4908405101801215878L;

  public UncheckedSqlWarningException(final SQLWarning cause) {
    super(cause);
  }

  public UncheckedSqlWarningException(final String error, final SQLWarning cause) {
    super(error, cause);
  }

}
