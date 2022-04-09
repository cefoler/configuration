package com.cefoler.configuration.core.model.spliterator;

import com.cefoler.configuration.core.model.consumer.HoldingConsumer;
import com.cefoler.configuration.core.util.Primitives;
import java.util.Spliterator;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public abstract class AbstractSpliterator<T> implements Spliterator<T> {

  private static final int UNIT_BATCH;
  private static final int MAXIMUM_BATCH;

  static {
    UNIT_BATCH = 1 << 10;
    MAXIMUM_BATCH = 1 << 25;
  }

  private long size;
  private final int characteristic;

  private int batch;

  protected AbstractSpliterator(final long size, final int characteristic) {
    this.size = size;

    final int hex = characteristic & Spliterator.SIZED;
    this.characteristic = hex != 0 ? characteristic | Spliterator.SUBSIZED : characteristic;
  }

  @Override
  @Nullable
  public Spliterator<T> trySplit() {
    final HoldingConsumer<T> consumer = HoldingConsumer.of();

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

    final Object[] values = new Object[newBatch];
    int index = 0;

    for (; index < newBatch; index++, tryAdvance(consumer)) {
      values[index] = consumer.getValue();
    }

    this.batch = index;

    if (size != Long.MAX_VALUE) {
      this.size -= Primitives.toLong(index);
    }

    return new ArraySpliterator<>(values, 0, index, characteristic);
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
