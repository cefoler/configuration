package com.cefoler.configuration.model.lambda.function.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import com.cefoler.configuration.model.lambda.function.ThrowFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ThrowUnaryOperator<T, U extends Exception> extends ThrowFunction<T, T, U> {

  static <T> UnaryOperator<T> identity() {
    return key -> key;
  }

  static <T> UnaryOperator<T> convert(final ThrowUnaryOperator<T, ?> operator) {
    return key -> {
      try {
        return operator.apply(key);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T> UnaryOperator<T> convert(final ThrowUnaryOperator<T, ?> operator,
      @Nullable final T orElse) {
    return key -> {
      try {
        return operator.apply(key);
      } catch (final Exception exception) {
        return orElse;
      }
    };
  }

  static <T> UnaryOperator<T> convert(final ThrowUnaryOperator<T, ?> operator,
      final Supplier<? extends T> orElse) {
    return key -> {
      try {
        return operator.apply(key);
      } catch (final Exception exception) {
        return orElse.get();
      }
    };
  }

}
