package com.cefoler.configuration.model.spliterator;

import com.cefoler.configuration.util.Primitives;
import java.util.Comparator;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterator.OfLong;
import java.util.function.LongConsumer;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public class IteratorLongSpliterator implements OfLong {

  private static final int UNIT_BATCH;
  private static final int MAXIMUM_BATCH;

  static {
    UNIT_BATCH = 1 << 10;
    MAXIMUM_BATCH = 1 << 25;
  }

  private final PrimitiveIterator.OfLong iterator;
  private long size;

  private final int characteristic;
  private int batch;

  public IteratorLongSpliterator(final PrimitiveIterator.OfLong iterator, final long size,
      final int characteristic) {
    this.iterator = iterator;
    this.size = size;

    final int hex = characteristic & Spliterator.CONCURRENT;

    this.characteristic = hex == 0
        ? characteristic | Spliterator.SIZED | Spliterator.SUBSIZED
        : characteristic;
  }

  public IteratorLongSpliterator(final PrimitiveIterator.OfLong iterator,
      final int characteristic) {
    this.iterator = iterator;
    this.size = Long.MAX_VALUE;

    this.characteristic = characteristic & ~Spliterator.SIZED | Spliterator.SUBSIZED;
  }

  @Override
  @Nullable
  public OfLong trySplit() {
    if (size <= 1L || !iterator.hasNext()) {
      return null;
    }

    int newBatch = batch + UNIT_BATCH;
    final int convertedSize = Primitives.toInt(size);

    if (newBatch > convertedSize) {
      newBatch = convertedSize;
    }

    if (newBatch > MAXIMUM_BATCH) {
      newBatch = MAXIMUM_BATCH;
    }

    final long[] values = new long[newBatch];
    int index = 0;

    for (; index < newBatch && iterator.hasNext(); index++) {
      values[index] = iterator.next();
    }

    this.batch = index;

    if (size != Long.MAX_VALUE) {
      this.size -= Primitives.toLong(index);
    }

    return new ArrayLongSpliterator(values, 0, index, characteristic);
  }

  @Override
  public void forEachRemaining(final LongConsumer consumer) {
    iterator.forEachRemaining(consumer);
  }

  @Override
  public boolean tryAdvance(final LongConsumer consumer) {
    if (!iterator.hasNext()) {
      return false;
    }

    final long value = iterator.next();
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
  public Comparator<? super Long> getComparator() {
    final int characteristics = Spliterator.SORTED;

    if (hasCharacteristics(characteristics)) {
      return null;
    }

    throw new IllegalStateException("Spliterator doesn't have the SORTED value");
  }

}
