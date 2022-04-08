package com.cefoler.configuration.model.lambda.function;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ThrowBiFunction<T, U, V, W extends Exception> {

  V apply(final T key1, final U key2) throws W;

  default <X> ThrowBiFunction<T, U, X, W> after(final ThrowFunction<? super V, ? extends X,
        ? extends W> after) {
    return (key1, key2) -> {
      final V value = apply(key1, key2);
      return after.apply(value);
    };
  }

  static <T, U, V> BiFunction<T, U, V> convert(final ThrowBiFunction<? super T, ? super U,
      ? extends V, ?> function) {
    return (key1, key2) -> {
      try {
        return function.apply(key1, key2);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T, U, V> BiFunction<T, U, V> convert(final ThrowBiFunction<? super T, ? super U,
      ? extends V, ?> function, @Nullable final V orElse) {
    return (key1, key2) -> {
      try {
        return function.apply(key1, key2);
      } catch (final Exception exception) {
        return orElse;
      }
    };
  }

  static <T, U, V> BiFunction<T, U, V> convert(final ThrowBiFunction<? super T, ? super U,
      ? extends V, ?> function, final Supplier<? extends V> orElse) {
    return (key1, key2) -> {
      try {
        return function.apply(key1, key2);
      } catch (final Exception exception) {
        return orElse.get();
      }
    };
  }

}
