package com.cefoler.configuration.model.lambda.function.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import com.cefoler.configuration.model.lambda.function.ThrowFunction;
import java.util.function.UnaryOperator;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ThrowingUnaryOperator<T, U extends Exception> extends ThrowFunction<T, T, U> {

  static <T> UnaryOperator<T> identity() {
    return key -> key;
  }

  static <T> UnaryOperator<T> convert(final ThrowingUnaryOperator<T, ?> operator) {
    return key -> {
      try {
        return operator.apply(key);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T> UnaryOperator<T> convert(final ThrowingUnaryOperator<T, ?> operator,
      @Nullable final T orElse) {
    return key -> {
      try {
        return operator.apply(key);
      } catch (final Exception exception) {
        return orElse;
      }
    };
  }

}
