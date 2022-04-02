package com.cefoler.configuration.util;

import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterator.OfDouble;
import java.util.Spliterator.OfInt;
import java.util.Spliterator.OfLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Streams {

  public static <T> Stream<T> toStream(final Collection<T> collection) {
    return toStream(collection, false);
  }

  public static <T> Stream<T> toStream(final Collection<T> collection, final boolean parallel) {
    return parallel ? collection.parallelStream() : collection.stream();
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public static <T> Stream<T> toStream(final T... values) {
    return toStream(values, false);
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public static <T> Stream<T> toStream(final boolean parallel, final T... values) {
    return toStream(values, parallel);
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public static <T> Stream<T> toStream(final int index, final int maximum, final T... values) {
    return toStream(values, index, maximum);
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public static <T> Stream<T> toStream(final int index, final int maximum, final boolean parallel,
      final T... values) {
    return toStream(values, index, maximum, parallel);
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public static <T> Stream<T> toStream(final int index, final int maximum, final int hexa,
      final T... values) {
    return toStream(values, index, maximum, hexa);
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public static <T> Stream<T> toStream(final int index, final int maximum, final int hexa,
      final boolean parallel, final T... values) {
    return toStream(values, index, maximum, hexa, parallel);
  }

  public static <T> Stream<T> toStream(final T[] values, final boolean parallel) {
    final int length = values.length;
    return toStream(values, 0, length, parallel);
  }

  public static <T> Stream<T> toStream(final T[] values, final int index, final int maximum) {
    return toStream(values, index, maximum, false);
  }

  public static <T> Stream<T> toStream(final T[] values, final int index, final int maximum,
      final boolean parallel) {
    final int hexa = Spliterator.ORDERED | Spliterator.IMMUTABLE;
    return toStream(values, index, maximum, hexa, parallel);
  }

  public static <T> Stream<T> toStream(final T[] values, final int index, final int maximum,
      final int hexa) {
    return toStream(values, index, maximum, hexa, false);
  }

  public static <T> Stream<T> toStream(final T[] values, final int index, final int maximum,
      final int hexa, final boolean parallel) {
    final Spliterator<T> spliterator = Spliterators.spliterator(values, index, maximum, hexa);
    return StreamSupport.stream(spliterator, parallel);
  }

  public static IntStream toStream(final int... values) {
    return toStream(values, false);
  }

  public static IntStream toStream(final boolean parallel, final int... values) {
    return toStream(values, parallel);
  }

  public static IntStream toStream(final int index, final int maximum, final int... values) {
    return toStream(values, index, maximum);
  }

  public static IntStream toStream(final int index, final int maximum, final boolean parallel,
      final int... values) {
    return toStream(values, index, maximum, parallel);
  }

  public static IntStream toStream(final int index, final int maximum, final int hexa,
      final int... values) {
    return toStream(values, index, maximum, hexa);
  }

  public static IntStream toStream(final int index, final int maximum, final int hexa,
      final boolean parallel, final int... values) {
    return toStream(values, index, maximum, hexa, parallel);
  }

  public static IntStream toStream(final int[] values, final boolean parallel) {
    final int length = values.length;
    return toStream(values, 0, length, parallel);
  }

  public static IntStream toStream(final int[] values, final int index, final int maximum) {
    return toStream(values, index, maximum, false);
  }

  public static IntStream toStream(final int[] values, final int index, final int maximum,
      final boolean parallel) {
    final int hexa = Spliterator.ORDERED | Spliterator.IMMUTABLE;
    return toStream(values, index, maximum, hexa, parallel);
  }

  public static IntStream toStream(final int[] values, final int index, final int maximum,
      final int hexa) {
    return toStream(values, index, maximum, hexa, false);
  }

  public static IntStream toStream(final int[] values, final int index, final int maximum,
      final int hexa, final boolean parallel) {
    final OfInt spliterator = Spliterators.spliterator(values, index, maximum, hexa);
    return StreamSupport.intStream(spliterator, parallel);
  }

  public static LongStream toStream(final long... values) {
    return toStream(values, false);
  }

  public static LongStream toStream(final boolean parallel, final long... values) {
    return toStream(values, parallel);
  }

  public static LongStream toStream(final int index, final int maximum, final long... values) {
    return toStream(values, index, maximum);
  }

  public static LongStream toStream(final int index, final int maximum, final boolean parallel,
      final long... values) {
    return toStream(values, index, maximum, parallel);
  }

  public static LongStream toStream(final int index, final int maximum, final int hexa,
      final long... values) {
    return toStream(values, index, maximum, hexa);
  }

  public static LongStream toStream(final int index, final int maximum, final int hexa,
      final boolean parallel, final long... values) {
    return toStream(values, index, maximum, hexa, parallel);
  }

  public static LongStream toStream(final long[] values, final boolean parallel) {
    final int length = values.length;
    return toStream(values, 0, length, parallel);
  }

  public static LongStream toStream(final long[] values, final int index, final int maximum) {
    return toStream(values, index, maximum, false);
  }

  public static LongStream toStream(final long[] values, final int index, final int maximum,
      final boolean parallel) {
    final int hexa = Spliterator.ORDERED | Spliterator.IMMUTABLE;
    return toStream(values, index, maximum, hexa, parallel);
  }

  public static LongStream toStream(final long[] values, final int index, final int maximum,
      final int hexa) {
    return toStream(values, index, maximum, hexa, false);
  }

  public static LongStream toStream(final long[] values, final int index, final int maximum,
      final int hexa, final boolean parallel) {
    final OfLong spliterator = Spliterators.spliterator(values, index, maximum, hexa);
    return StreamSupport.longStream(spliterator, parallel);
  }

  public static DoubleStream toStream(final double... values) {
    return toStream(values, false);
  }

  public static DoubleStream toStream(final boolean parallel, final double... values) {
    return toStream(values, parallel);
  }

  public static DoubleStream toStream(final int index, final int maximum, final double... values) {
    return toStream(values, index, maximum);
  }

  public static DoubleStream toStream(final int index, final int maximum, final boolean parallel,
      final double... values) {
    return toStream(values, index, maximum, parallel);
  }

  public static DoubleStream toStream(final int index, final int maximum, final int hexa,
      final double... values) {
    return toStream(values, index, maximum, hexa);
  }

  public static DoubleStream toStream(final int index, final int maximum, final int hexa,
      final boolean parallel, final double... values) {
    return toStream(values, index, maximum, hexa, parallel);
  }

  public static DoubleStream toStream(final double[] values, final boolean parallel) {
    final int length = values.length;
    return toStream(values, 0, length, parallel);
  }

  public static DoubleStream toStream(final double[] values, final int index, final int maximum) {
    return toStream(values, index, maximum, false);
  }

  public static DoubleStream toStream(final double[] values, final int index, final int maximum,
      final boolean parallel) {
    final int hexa = Spliterator.ORDERED | Spliterator.IMMUTABLE;
    return toStream(values, index, maximum, hexa, parallel);
  }

  public static DoubleStream toStream(final double[] values, final int index, final int maximum,
      final int hexa) {
    return toStream(values, index, maximum, hexa, false);
  }

  public static DoubleStream toStream(final double[] values, final int index, final int maximum,
      final int hexa, final boolean parallel) {
    final OfDouble spliterator = Spliterators.spliterator(values, index, maximum, hexa);
    return StreamSupport.doubleStream(spliterator, parallel);
  }

}
