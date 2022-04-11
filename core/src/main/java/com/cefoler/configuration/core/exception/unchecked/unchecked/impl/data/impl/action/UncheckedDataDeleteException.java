package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.data.impl.action;

import com.cefoler.configuration.core.exception.checked.data.impl.action.DataDeleteException;
import com.cefoler.configuration.core.exception.unchecked.unchecked.impl.data.UncheckedDataException;

public class UncheckedDataDeleteException extends UncheckedDataException {

  private static final long serialVersionUID = 8079682102490898053L;

  public UncheckedDataDeleteException(final DataDeleteException cause) {
    super(cause);
  }

  public UncheckedDataDeleteException(final String error, final DataDeleteException cause) {
    super(error, cause);
  }

}
