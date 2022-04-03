package com.cefoler.configuration.exception.unchecked.unchecked.impl.sql.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import javax.sql.rowset.spi.SyncFactoryException;

public class UncheckedSyncFactoryException extends UncheckedException {

  private static final long serialVersionUID = 8641784935959227767L;

  public UncheckedSyncFactoryException(final SyncFactoryException cause) {
    super(cause);
  }

  public UncheckedSyncFactoryException(final String error, final SyncFactoryException cause) {
    super(error, cause);
  }

}
