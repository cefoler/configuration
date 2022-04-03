package com.cefoler.configuration.exception.unchecked.unchecked.impl.sql.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import javax.sql.rowset.RowSetWarning;

public class UncheckedRowSetWarningException extends UncheckedException {

  private static final long serialVersionUID = 5440918063829105694L;

  public UncheckedRowSetWarningException(final RowSetWarning cause) {
    super(cause);
  }

  public UncheckedRowSetWarningException(final String error, final RowSetWarning cause) {
    super(error, cause);
  }

}
