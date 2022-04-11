package com.cefoler.configuration.core.exception.unchecked.unchecked.impl.other;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import javax.script.ScriptException;

public class UncheckedScriptException extends UncheckedException {

  private static final long serialVersionUID = 7305485369043319920L;

  public UncheckedScriptException(final ScriptException cause) {
    super(cause);
  }

  public UncheckedScriptException(final String error, final ScriptException cause) {
    super(error, cause);
  }

}
