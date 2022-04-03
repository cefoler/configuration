package com.cefoler.configuration.exception.unchecked.unchecked.impl.sql.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import javax.sql.rowset.spi.SyncProviderException;

public class UncheckedSyncProviderException extends UncheckedException {

  private static final long serialVersionUID = 292122295174467524L;

  public UncheckedSyncProviderException(final SyncProviderException cause) {
    super(cause);
  }

  public UncheckedSyncProviderException(final String error, final SyncProviderException cause) {
    super(error, cause);
  }

}
