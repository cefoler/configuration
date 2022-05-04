package com.cefoler.configuration.core.model.spliterator;

import com.cefoler.configuration.core.model.consumer.HoldingDoubleConsumer;
import com.cefoler.configuration.core.util.Primitives;
import java.util.Spliterator;
import java.util.Spliterator.OfDouble;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public abstract class AbstractDoubleSpliterator implements OfDouble {

  private static final int UNIT_BATCH;
  private static final int MAXIMUM_BATCH;

  static {
    UNIT_BATCH = 1 << 10;
    MAXIMUM_BATCH = 1 << 25;
  }

  private long size;
  private final int characteristic;

  private int batch;

  protected AbstractDoubleSpliterator(final long size, final int characteristic) {
    this.size = size;

    final int hex = characteristic & Spliterator.SIZED;
    this.characteristic = hex != 0 ? characteristic | Spliterator.SUBSIZED : characteristic;
  }

  @Override
  @Nullable
  public OfDouble trySplit() {
    final HoldingDoubleConsumer consumer = HoldingDoubleConsumer.of();

    if (size <= 1 || !tryAdvance(consumer)) {
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

    final double[] values = new double[summed];
    int index = 0;

    for (; index < summed; index++, tryAdvance(consumer)) {
      values[index] = consumer.getValue();
    }

    this.batch = index;
    final long max = Long.MAX_VALUE;

    if (size != max) {
      this.size -= Primitives.toLong(index);
    }

    return new ArrayDoubleSpliterator(values, 0, index, characteristic);
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
