package com.cefoler.configuration.model.lambda.function.impl;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import com.cefoler.configuration.model.lambda.function.ThrowBiFunction;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ThrowBinaryOperator<T, U extends Exception> extends ThrowBiFunction<T, T, T, U> {

  static <T> BinaryOperator<T> minimum(final Comparator<? super T> comparator) {
    return (key1, key2) -> comparator.compare(key1, key2) <= 0 ? key1 : key2;
  }

  static <T> BinaryOperator<T> maximum(final Comparator<? super T> comparator) {
    return (key1, key2) -> comparator.compare(key1, key2) >= 0 ? key1 : key2;
  }

  static <T> BinaryOperator<T> convert(final ThrowBinaryOperator<T, ?> operator) {
    return (key1, key2) -> {
      try {
        return operator.apply(key1, key2);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T> BinaryOperator<T> convert(final ThrowBinaryOperator<T, ?> operator,
      @Nullable final T orElse) {
    return (key1, key2) -> {
      try {
        return operator.apply(key1, key2);
      } catch (final Exception exception) {
        return orElse;
      }
    };
  }

}
