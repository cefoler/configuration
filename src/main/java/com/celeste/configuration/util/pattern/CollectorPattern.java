package com.celeste.configuration.util.pattern;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CollectorPattern {

  public static <T> Collector<T, ?, List<T>> toList() {
    return Collectors.toList();
  }

  public static <T> Collector<T, ?, Set<T>> toSet() {
    return Collectors.toSet();
  }

  public static <T, V extends Collection<T>> Collector<T, ?, V> toCollection(
      final Supplier<V> supplier) {
    return Collectors.toCollection(supplier);
  }

  public static <T, U, V> Collector<T, ?, Map<U, V>> toMap(final Function<T, U> key,
      final Function<T, V> value) {
    return Collectors.toMap(key, value, (value1, value2) -> value1, ConcurrentHashMap::new);
  }

  public static <T, U, V, W extends Map<U, V>> Collector<T, ?, W> toMap(final Function<T, U> key,
      final Function<T, V> value, final Supplier<W> map) {
    return Collectors.toMap(key, value, (value1, value2) -> value1, map);
  }

  public static <T, U, V> Collector<T, ?, Map<U, V>> toMap(final Function<T, U> key,
      final Function<T, V> value, final BinaryOperator<V> merge) {
    return Collectors.toMap(key, value, merge, ConcurrentHashMap::new);
  }

  public static <T, U, V, W extends Map<U, V>> Collector<T, ?, W> toMap(final Function<T, U> key,
      final Function<T, V> value, final BinaryOperator<V> merge, final Supplier<W> map) {
    return Collectors.toMap(key, value, merge, map);
  }

  public static <T, U, V> Collector<T, ?, Map<U, V>> toMapException(final Function<T, U> key,
      final Function<T, V> value) {
    return Collectors.toMap(key, value, (value1, value2) -> {
      throw new IllegalStateException(value1 + " value is duplicated");
    }, ConcurrentHashMap::new);
  }

  public static <T, U, V, W extends Map<U, V>> Collector<T, ?, W> toMapException(
      final Function<T, U> key, final Function<T, V> value, final Supplier<W> map) {
    return Collectors.toMap(key, value, (value1, value2) -> {
      throw new IllegalStateException(value1 + " value is duplicated");
    }, map);
  }

}
