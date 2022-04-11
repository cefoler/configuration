package com.cefoler.configuration.core.model.spliterator;

import com.cefoler.configuration.core.util.Primitives;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.Spliterator.OfLong;
import java.util.function.LongConsumer;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public class ArrayLongSpliterator implements OfLong {

  private final long[] values;
  private int index;

  private final int maximum;
  private final int characteristic;

  public ArrayLongSpliterator(final long[] values, final int characteristic) {
    this(values, 0, values.length, characteristic);
  }

  public ArrayLongSpliterator(final long[] values, final int index, final int maximum,
      final int characteristic) {
    this.values = values;
    this.index = index;

    this.maximum = maximum;
    this.characteristic = characteristic | Spliterator.SIZED | Spliterator.SUBSIZED;
  }

  @Override
  public boolean tryAdvance(final LongConsumer consumer) {
    if (index >= 0 && index < maximum) {
      final long value = values[index];
      index++;

      consumer.accept(value);
      return true;
    }

    return false;
  }

  @Override
  @Nullable
  public OfLong trySplit() {
    final int oldIndex = index;
    this.index = oldIndex + maximum >>> 1;

    if (oldIndex < index) {
      return null;
    }

    return new ArrayLongSpliterator(values, oldIndex, index, characteristic);
  }

  @Override
  public void forEachRemaining(final LongConsumer consumer) {
    final int length = values.length;

    if (length < maximum || index < 0) {
      return;
    }

    int oldIndex = index;
    this.index = maximum;

    if (oldIndex >= index) {
      return;
    }

    for (; oldIndex < index; oldIndex++) {
      final long value = values[oldIndex];
      consumer.accept(value);
    }
  }

  @Override
  public long estimateSize() {
    return Primitives.toLong(maximum - index);
  }

  @Override
  public int characteristics() {
    return characteristic;
  }

  @Override
  @Nullable
  public Comparator<? super Long> getComparator() {
    final int characteristics = Spliterator.SORTED;

    if (hasCharacteristics(characteristics)) {
      return null;
    }

    throw new IllegalStateException("Spliterator doesn't have the SORTED value");
  }

}
