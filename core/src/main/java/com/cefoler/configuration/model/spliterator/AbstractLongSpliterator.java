package com.cefoler.configuration.model.spliterator;

import com.cefoler.configuration.model.consumer.HoldingLongConsumer;
import com.cefoler.configuration.util.Primitives;
import java.util.Spliterator;
import java.util.Spliterator.OfLong;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public abstract class AbstractLongSpliterator implements OfLong {

  private static final int UNIT_BATCH;
  private static final int MAXIMUM_BATCH;

  static {
    UNIT_BATCH = 1 << 10;
    MAXIMUM_BATCH = 1 << 25;
  }

  private long size;
  private final int characteristic;

  private int batch;

  protected AbstractLongSpliterator(final long size, final int characteristic) {
    this.size = size;

    final int hex = characteristic & Spliterator.SIZED;
    this.characteristic = hex != 0 ? characteristic | Spliterator.SUBSIZED : characteristic;
  }

  @Override
  @Nullable
  public OfLong trySplit() {
    final HoldingLongConsumer consumer = HoldingLongConsumer.of();

    if (size <= 1L || !tryAdvance(consumer)) {
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

    for (; index < newBatch; index++, tryAdvance(consumer)) {
      values[index] = consumer.getValue();
    }

    this.batch = index;

    if (size != Long.MAX_VALUE) {
      this.size -= Primitives.toLong(index);
    }

    return new ArrayLongSpliterator(values, 0, index, characteristic);
  }

  @Override
  public long estimateSize() {
    return size;
  }

  @Override
  public int characteristics() {
    return characteristic;
  }

}
