package com.cefoler.configuration.core.model.spliterator;

import com.cefoler.configuration.core.util.Primitives;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.Spliterator.OfDouble;
import java.util.function.DoubleConsumer;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public class ArrayDoubleSpliterator implements OfDouble {

  private final double[] values;
  private int index;

  private final int maximum;
  private final int characteristic;

  public ArrayDoubleSpliterator(final double[] values, final int characteristic) {
    this(values, 0, values.length, characteristic);
  }

  public ArrayDoubleSpliterator(final double[] values, final int index, final int maximum,
      final int characteristic) {
    this.values = values;
    this.index = index;

    this.maximum = maximum;
    this.characteristic = characteristic | Spliterator.SIZED | Spliterator.SUBSIZED;
  }

  @Override
  public boolean tryAdvance(final DoubleConsumer consumer) {
    if (index >= 0 && index < maximum) {
      final double value = values[index];
      index++;

      consumer.accept(value);
      return true;
    }

    return false;
  }

  @Override
  @Nullable
  public OfDouble trySplit() {
    final int oldIndex = index;
    this.index = oldIndex + maximum >>> 1;

    if (oldIndex < index) {
      return null;
    }

    return new ArrayDoubleSpliterator(values, oldIndex, index, characteristic);
  }

  @Override
  public void forEachRemaining(final DoubleConsumer consumer) {
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
      final double value = values[oldIndex];
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
  public Comparator<? super Double> getComparator() {
    final int characteristics = Spliterator.SORTED;

    if (hasCharacteristics(characteristics)) {
      return null;
    }

    throw new IllegalStateException("Spliterator doesn't have the SORTED value");
  }

}
