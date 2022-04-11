package com.cefoler.configuration.core.model.lambda.consumer;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import java.util.function.BiConsumer;

@FunctionalInterface
public interface ThrowBiConsumer<T, U, V extends Exception> {

  void accept(final T key1, U key2) throws V;

  default ThrowBiConsumer<T, U, V> before(final ThrowBiConsumer<? super T, ? super U,
      ? extends V> before) {
    return (key1, key2) -> {
      before.accept(key1, key2);
      accept(key1, key2);
    };
  }

  default ThrowBiConsumer<T, U, V> after(final ThrowBiConsumer<? super T, ? super U,
      ? extends V> after) {
    return (key1, key2) -> {
      accept(key1, key2);
      after.accept(key1, key2);
    };
  }

  static <T, U> BiConsumer<T, U> convert(final ThrowBiConsumer<? super T, ? super U, ?> consumer) {
    return (key1, key2) -> {
      try {
        consumer.accept(key1, key2);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

}
