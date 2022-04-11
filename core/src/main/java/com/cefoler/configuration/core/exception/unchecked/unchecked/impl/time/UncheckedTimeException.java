package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.time;

import com.cefoler.configuration.core.exception.checked.time.TimeException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;

public class UncheckedTimeException extends UncheckedException {

  private static final long serialVersionUID = -1325171031409534024L;

  public UncheckedTimeException(final TimeException cause) {
    super(cause);
  }

  public UncheckedTimeException(final String error, final TimeException cause) {
    super(error, cause);
  }

}
