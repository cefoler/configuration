package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.sql.impl;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import java.sql.BatchUpdateException;

public class UncheckedBatchUpdateException extends UncheckedException {

  private static final long serialVersionUID = -3495577980602837594L;

  public UncheckedBatchUpdateException(final BatchUpdateException cause) {
    super(cause);
  }

  public UncheckedBatchUpdateException(final String error, final BatchUpdateException cause) {
    super(error, cause);
  }

}
