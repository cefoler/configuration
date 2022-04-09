package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.sql.impl;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import java.sql.SQLClientInfoException;

public class UncheckedSqlClientInfoException extends UncheckedException {

  private static final long serialVersionUID = -2043820773424373142L;

  public UncheckedSqlClientInfoException(final SQLClientInfoException cause) {
    super(cause);
  }

  public UncheckedSqlClientInfoException(final String error, final SQLClientInfoException cause) {
    super(error, cause);
  }

}
