package com.cefoler.configuration.model.lambda.predicate;

import com.cefoler.configuration.exception.unchecked.unchecked.UncheckedException;
import java.util.function.BiPredicate;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ThrowBiPredicate<T, U, V extends Exception> {

  boolean test(final T key1, final U key2) throws V;

  default ThrowBiPredicate<T, U, ?> and(final ThrowBiPredicate<? super T, ? super U, ?> predicate) {
    return (key1, key2) -> test(key1, key2) && predicate.test(key1, key2);
  }

  default ThrowBiPredicate<T, U, ?> or(final ThrowBiPredicate<? super T, ? super U, ?> predicate) {
    return (key1, key2) -> test(key1, key2) || predicate.test(key1, key2);
  }

  default ThrowBiPredicate<T, U, ?> negate() {
    return (key1, key2) -> !test(key1, key2);
  }

  static <T, U> BiPredicate<T, U> convert(final ThrowBiPredicate<? super T, ? super U,
      ?> predicate) {
    return (key1, key2) -> {
      try {
        return predicate.test(key1, key2);
      } catch (final Exception exception) {
        throw new UncheckedException(exception);
      }
    };
  }

  static <T, U> BiPredicate<T, U> convert(final ThrowBiPredicate<? super T, ? super U, ?> predicate,
      @Nullable final Boolean orElse) {
    return (key1, key2) -> {
      try {
        return predicate.test(key1, key2);
      } catch (final Exception exception) {
        return orElse;
      }
    };
  }

}
