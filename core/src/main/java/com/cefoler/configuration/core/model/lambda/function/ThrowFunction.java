package com.cefoler.configuration.core.model.lambda.function;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import java.util.function.Function;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ThrowFunction<T, U, V extends Exception> {

  U apply(final T key) throws V;

  default <W> ThrowFunction<W, U, V> before(final ThrowFunction<? super W, ? extends T,
      ? extends V> before) {
    return key -> {
      final T value = before.apply(key);
      return apply(value);
    };
  }

  default <W> ThrowFunction<T, W, V> after(final ThrowFunction<? super U, ? extends W,
      ? extends V> after) {
    return key -> {
      final U value = apply(key);
      return after.apply(value);
    };
  }

  static <T, U> Function<T, U> convert(final ThrowFunction<? super T, ? extends U, ?> function) {
    return key -> {
      try {
        return function.apply(key);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T, U> Function<T, U> convert(final ThrowFunction<? super T, ? extends U, ?> function,
      @Nullable final U orElse) {
    return key -> {
      try {
        return function.apply(key);
      } catch (final Exception exception) {
        return orElse;
      }
    };
  }

  static <T, U> Function<T, U> convert(final ThrowFunction<? super T, ? extends U, ?> function,
      final Supplier<? extends U> orElse) {
    return key -> {
      try {
        return function.apply(key);
      } catch (final Exception exception) {
        return orElse.get();
      }
    };
  }

}
