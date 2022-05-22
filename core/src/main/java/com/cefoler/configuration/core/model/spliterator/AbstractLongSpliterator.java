package com.cefoler.configuration.core.model.spliterator;

import com.cefoler.configuration.core.model.consumer.HoldingLongConsumer;
import com.cefoler.configuration.core.util.Primitives;
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
    this.characteristic = hex == 0 ? characteristic : characteristic | Spliterator.SUBSIZED;
  }

  @Override
  @Nullable
  public OfLong trySplit() {
    final HoldingLongConsumer consumer = HoldingLongConsumer.of();

    if (size <= 1L || !tryAdvance(consumer)) {
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

    final long[] values = new long[summed];
    int index = 0;

    for (; index < summed; index++, tryAdvance(consumer)) {
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
