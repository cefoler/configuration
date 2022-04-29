package com.cefoler.configuration.core.model.lambda.predicate;

import com.cefoler.configuration.core.exception.unchecked.unchecked.UncheckedException;
import java.util.Map.Entry;
import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ThrowPredicate<T, U extends Exception> {

  boolean test(final T key) throws U;

  default ThrowPredicate<T, ?> and(final ThrowPredicate<? super T, ?> predicate) {
    return key -> test(key) && predicate.test(key);
  }

  default ThrowPredicate<T, ?> or(final ThrowPredicate<? super T, ?> predicate) {
    return key -> test(key) || predicate.test(key);
  }

  default ThrowPredicate<T, ?> negate() {
    return key -> !test(key);
  }

  static <T> Predicate<T> convert(final ThrowPredicate<? super T, ?> predicate) {
    return key -> {
      try {
        return predicate.test(key);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T> Predicate<T> convert(final ThrowPredicate<? super T, ?> predicate,
      @Nullable final Boolean orElse) {
    return key -> {
      try {
        return predicate.test(key);
      } catch (final Exception exception) {
        return orElse;
      }
    };
  }

  static <T, U> Predicate<Entry<T, U>> convertToBi(final ThrowBiPredicate<? super T, ? super U,
      ?> predicate) {
    return entry -> {
      try {
        final T key = entry.getKey();
        final U value = entry.getValue();

        return predicate.test(key, value);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

}
