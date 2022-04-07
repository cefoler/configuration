package com.cefoler.configuration.model.lambda.supplier;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ThrowSupplier<T, U extends Exception> {

  T get() throws U;

  static <T> Supplier<T> convert(final ThrowSupplier<? extends T, ?> supplier) {
    return () -> {
      try {
        return supplier.get();
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T> Supplier<T> convert(final ThrowSupplier<? extends T, ?> supplier,
      @Nullable final T orElse) {
    return () -> {
      try {
        return supplier.get();
      } catch (final Exception exception) {
        return orElse;
      }
    };
  }

}
