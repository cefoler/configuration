package com.cefoler.configuration.model.spliterator;

import com.cefoler.configuration.util.Primitives;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.Spliterator.OfInt;
import java.util.function.IntConsumer;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public class ArrayIntSpliterator implements OfInt {

  private final int[] values;
  private int index;

  private final int maximum;
  private final int characteristic;

  public ArrayIntSpliterator(final int[] values, final int characteristic) {
    this(values, 0, values.length, characteristic);
  }

  public ArrayIntSpliterator(final int[] values, final int index, final int maximum,
      final int characteristic) {
    this.values = values;
    this.index = index;

    this.maximum = maximum;
    this.characteristic = characteristic | Spliterator.SIZED | Spliterator.SUBSIZED;
  }

  @Override
  public boolean tryAdvance(final IntConsumer consumer) {
    if (index >= 0 && index < maximum) {
      final int value = values[index];
      index++;

      consumer.accept(value);
      return true;
    }

    return false;
  }

  @Override
  @Nullable
  public OfInt trySplit() {
    final int oldIndex = index;
    this.index = oldIndex + maximum >>> 1;

    if (oldIndex < index) {
      return null;
    }

    return new ArrayIntSpliterator(values, oldIndex, index, characteristic);
  }

  @Override
  public void forEachRemaining(final IntConsumer consumer) {
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
      final int value = values[oldIndex];
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
  public Comparator<? super Integer> getComparator() {
    final int characteristics = Spliterator.SORTED;

    if (hasCharacteristics(characteristics)) {
      return null;
    }

    throw new IllegalStateException("Spliterator doesn't have the SORTED value");
  }

}
