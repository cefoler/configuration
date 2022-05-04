package com.cefoler.configuration.core.model.spliterator;

import com.cefoler.configuration.core.util.Primitives;
import java.util.Comparator;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterator.OfInt;
import java.util.function.IntConsumer;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public class IteratorIntSpliterator implements OfInt {

  private static final int UNIT_BATCH;
  private static final int MAXIMUM_BATCH;

  static {
    UNIT_BATCH = 1 << 10;
    MAXIMUM_BATCH = 1 << 25;
  }

  private final PrimitiveIterator.OfInt iterator;
  private long size;

  private final int characteristic;
  private int batch;

  public IteratorIntSpliterator(final PrimitiveIterator.OfInt iterator, final long size,
      final int characteristic) {
    this.iterator = iterator;
    this.size = size;

    final int hex = characteristic & Spliterator.CONCURRENT;

    this.characteristic = hex == 0
        ? characteristic | Spliterator.SIZED | Spliterator.SUBSIZED
        : characteristic;
  }

  public IteratorIntSpliterator(final PrimitiveIterator.OfInt iterator, final int characteristic) {
    this.iterator = iterator;
    this.size = Long.MAX_VALUE;

    this.characteristic = characteristic & ~Spliterator.SIZED | Spliterator.SUBSIZED;
  }

  @Override
  @Nullable
  public OfInt trySplit() {
    if (size <= 1L || !iterator.hasNext()) {
      return null;
    }

    int summed = batch + UNIT_BATCH;
    final int converted = Primitives.toInt(size);

    if (summed > converted) {
      summed = converted;
    }

    if (summed > MAXIMUM_BATCH) {
      summed = MAXIMUM_BATCH;
    }

    final int[] values = new int[summed];
    int index = 0;

    for (; index < summed && iterator.hasNext(); index++) {
      values[index] = iterator.next();
    }

    this.batch = index;

    if (size != Long.MAX_VALUE) {
      this.size -= Primitives.toLong(index);
    }

    return new ArrayIntSpliterator(values, 0, index, characteristic);
  }

  @Override
  public void forEachRemaining(final IntConsumer consumer) {
    iterator.forEachRemaining(consumer);
  }

  @Override
  public boolean tryAdvance(final IntConsumer consumer) {
    if (!iterator.hasNext()) {
      return false;
    }

    final int value = iterator.next();
    consumer.accept(value);

    return true;
  }

  @Override
  public long estimateSize() {
    return size;
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
