package com.cefoler.configuration.util;

import com.cefoler.configuration.adapter.IteratorAdapter;
import com.cefoler.configuration.adapter.IteratorDoubleAdapter;
import com.cefoler.configuration.adapter.IteratorIntAdapter;
import com.cefoler.configuration.adapter.IteratorLongAdapter;
import com.cefoler.configuration.model.spliterator.ArrayDoubleSpliterator;
import com.cefoler.configuration.model.spliterator.ArrayIntSpliterator;
import com.cefoler.configuration.model.spliterator.ArraySpliterator;
import com.cefoler.configuration.model.spliterator.IteratorDoubleSpliterator;
import com.cefoler.configuration.model.spliterator.IteratorIntSpliterator;
import com.cefoler.configuration.model.spliterator.IteratorLongSpliterator;
import com.cefoler.configuration.model.spliterator.IteratorSpliterator;
import com.cefoler.configuration.model.spliterator.impl.EmptySpliteratorOfInt;
import com.cefoler.configuration.model.spliterator.ArrayLongSpliterator;
import com.cefoler.configuration.model.spliterator.impl.EmptySpliteratorOfDouble;
import com.cefoler.configuration.model.spliterator.impl.EmptySpliteratorOfLong;
import com.cefoler.configuration.model.spliterator.impl.EmptySpliteratorOfRef;
import java.util.Collection;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterator.OfDouble;
import java.util.Spliterator.OfInt;
import java.util.Spliterator.OfLong;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Spliterators {

  private static final Spliterator<?> EMPTY_SPLITERATOR;
  private static final OfInt EMPTY_INT_SPLITERATOR;

  private static final OfLong EMPTY_LONG_SPLITERATOR;
  private static final OfDouble EMPTY_DOUBLE_SPLITERATOR;

  static {
    EMPTY_SPLITERATOR = EmptySpliteratorOfRef.getInstance();
    EMPTY_INT_SPLITERATOR = EmptySpliteratorOfInt.getInstance();

    EMPTY_LONG_SPLITERATOR = EmptySpliteratorOfLong.getInstance();
    EMPTY_DOUBLE_SPLITERATOR = EmptySpliteratorOfDouble.getInstance();
  }

  public static <T> Spliterator<T> spliterator(final Object[] values, final int characteristic) {
    return new ArraySpliterator<>(values, characteristic);
  }

  public static <T> Spliterator<T> spliterator(final Object[] values, final int index,
      final int maximum, final int characteristic) {
    final int length = values.length;
    verify(length, index, maximum);

    return new ArraySpliterator<>(values, index, maximum, characteristic);
  }

  public static OfInt spliterator(final int[] values, final int characteristic) {
    return new ArrayIntSpliterator(values, characteristic);
  }

  public static OfInt spliterator(final int[] values, final int index, final int maximum,
      final int characteristic) {
    final int length = values.length;
    verify(length, index, maximum);

    return new ArrayIntSpliterator(values, index, maximum, characteristic);
  }

  public static OfLong spliterator(final long[] values, final int characteristic) {
    return new ArrayLongSpliterator(values, characteristic);
  }

  public static OfLong spliterator(final long[] values, final int index, final int maximum,
      final int characteristic) {
    final int length = values.length;
    verify(length, index, maximum);

    return new ArrayLongSpliterator(values, index, maximum, characteristic);
  }

  public static OfDouble spliterator(final double[] values, final int characteristic) {
    return new ArrayDoubleSpliterator(values, characteristic);
  }

  public static OfDouble spliterator(final double[] values, final int index, final int maximum,
      final int characteristic) {
    final int length = values.length;
    verify(length, index, maximum);

    return new ArrayDoubleSpliterator(values, index, maximum, characteristic);
  }

  public static <T> Spliterator<T> spliterator(final Collection<T> values,
      final int characteristic) {
    return new IteratorSpliterator<>(values, characteristic);
  }

  public static <T> Spliterator<T> spliterator(final Iterator<T> iterator, final long size,
      final int characteristic) {
    return new IteratorSpliterator<>(iterator, size, characteristic);
  }

  public static <T> Spliterator<T> spliteratorUnknownSize(final Iterator<T> iterator,
      final int characteristic) {
    return new IteratorSpliterator<>(iterator, characteristic);
  }

  public static OfInt spliterator(final PrimitiveIterator.OfInt iterator, final long size,
      final int characteristic) {
    return new IteratorIntSpliterator(iterator, size, characteristic);
  }

  public static OfInt spliteratorUnknownSize(final PrimitiveIterator.OfInt iterator,
      final int characteristic) {
    return new IteratorIntSpliterator(iterator, characteristic);
  }

  public static OfLong spliterator(final PrimitiveIterator.OfLong iterator, final long size,
      final int characteristic) {
    return new IteratorLongSpliterator(iterator, size, characteristic);
  }

  public static OfLong spliteratorUnknownSize(final PrimitiveIterator.OfLong iterator,
      final int characteristic) {
    return new IteratorLongSpliterator(iterator, characteristic);
  }

  public static OfDouble spliterator(final PrimitiveIterator.OfDouble iterator, final long size,
      final int characteristic) {
    return new IteratorDoubleSpliterator(iterator, size, characteristic);
  }

  public static OfDouble spliteratorUnknownSize(final PrimitiveIterator.OfDouble iterator,
      final int characteristic) {
    return new IteratorDoubleSpliterator(iterator, characteristic);
  }

  public static <T> Iterator<T> iterator(final Spliterator<T> spliterator) {
    return IteratorAdapter.of(spliterator);
  }

  public static PrimitiveIterator.OfInt iterator(final OfInt spliterator) {
    return IteratorIntAdapter.of(spliterator);
  }

  public static PrimitiveIterator.OfLong iterator(final OfLong spliterator) {
    return IteratorLongAdapter.of(spliterator);
  }

  public static PrimitiveIterator.OfDouble iterator(final OfDouble spliterator) {
    return IteratorDoubleAdapter.of(spliterator);
  }

  private static void verify(final int length, final int index, final int maximum) {
    if (index > maximum) {
      throw new ArrayIndexOutOfBoundsException("Index cannot be greater than maximum value");
    }

    if (index < 0) {
      throw new ArrayIndexOutOfBoundsException("Index cannot be less than 0");
    }

    if (maximum > length) {
      throw new ArrayIndexOutOfBoundsException("Maximum value cannot be greater than array size");
    }
  }

  public static <T> Spliterator<T> getEmptySpliterator() {
    return Objects.cast(EMPTY_SPLITERATOR);
  }

  public static OfInt getEmptyIntSpliterator() {
    return EMPTY_INT_SPLITERATOR;
  }

  public static OfDouble getEmptyDoubleSpliterator() {
    return EMPTY_DOUBLE_SPLITERATOR;
  }

  public static OfLong getEmptyLongSpliterator() {
    return EMPTY_LONG_SPLITERATOR;
  }

}
