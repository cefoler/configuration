package com.cefoler.configuration.core.model.spliterator;

import com.cefoler.configuration.core.model.consumer.HoldingIntConsumer;
import com.cefoler.configuration.core.util.Primitives;
import java.util.Spliterator;
import java.util.Spliterator.OfInt;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public abstract class AbstractIntSpliterator implements OfInt {

  private static final int UNIT_BATCH;
  private static final int MAXIMUM_BATCH;

  static {
    UNIT_BATCH = 1 << 10;
    MAXIMUM_BATCH = 1 << 25;
  }

  private long size;
  private final int characteristic;

  private int batch;

  protected AbstractIntSpliterator(final long size, final int characteristic) {
    this.size = size;

    final int hex = characteristic & Spliterator.SIZED;
    this.characteristic = hex != 0 ? characteristic | Spliterator.SUBSIZED : characteristic;
  }

  @Override
  @Nullable
  public OfInt trySplit() {
    final HoldingIntConsumer consumer = HoldingIntConsumer.of();

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

    final int[] values = new int[summed];
    int index = 0;

    for (; index < summed; index++, tryAdvance(consumer)) {
      values[index] = consumer.getValue();
    }

    this.batch = index;

    if (size != Long.MAX_VALUE) {
      this.size -= Primitives.toLong(index);
    }

    return new ArrayIntSpliterator(values, 0, index, characteristic);
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
