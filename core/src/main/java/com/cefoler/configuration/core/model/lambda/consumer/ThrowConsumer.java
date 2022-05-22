package com.cefoler.configuration.core.model.lambda.consumer;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import java.util.Map.Entry;
import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowConsumer<T, U extends Exception> {

  void accept(final T key) throws U;

  default ThrowConsumer<T, U> before(final ThrowConsumer<? super T, ? extends U> before) {
    return key -> {
      before.accept(key);
      accept(key);
    };
  }

  default ThrowConsumer<T, U> after(final ThrowConsumer<? super T, ? extends U> after) {
    return key -> {
      accept(key);
      after.accept(key);
    };
  }

  static <T> Consumer<T> convert(final ThrowConsumer<? super T, ?> consumer) {
    return key -> {
      try {
        consumer.accept(key);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T> Consumer<Entry<T, ?>> convertToKey(final ThrowConsumer<? super T, ?> consumer) {
    return entry -> {
      try {
        final T key = entry.getKey();
        consumer.accept(key);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T> Consumer<Entry<?, T>> convertToValue(final ThrowConsumer<? super T, ?> consumer) {
    return entry -> {
      try {
        final T value = entry.getValue();
        consumer.accept(value);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T, U> Consumer<Entry<T, U>> convertToBi(final ThrowBiConsumer<? super T, ? super U,
      ?> consumer) {
    return entry -> {
      try {
        final T key = entry.getKey();
        final U value = entry.getValue();

        consumer.accept(key, value);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

}
