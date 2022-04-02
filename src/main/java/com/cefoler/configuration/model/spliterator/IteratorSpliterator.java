package com.cefoler.configuration.model.spliterator;

import com.cefoler.configuration.util.Primitives;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public class IteratorSpliterator<T> implements Spliterator<T> {

  private static final int UNIT_BATCH;
  private static final int MAXIMUM_BATCH;

  static {
    UNIT_BATCH = 1 << 10;
    MAXIMUM_BATCH = 1 << 25;
  }

  @Nullable
  private final Collection<T> collection;

  @Nullable
  private Iterator<T> iterator;

  private long size;
  private final int characteristic;

  private int batch;

  public IteratorSpliterator(@Nullable final Collection<T> collection, final int characteristic) {
    this.collection = collection;
    this.iterator = null;

    final int hex = characteristic & Spliterator.CONCURRENT;

    this.characteristic = hex == 0
        ? characteristic | Spliterator.SIZED | Spliterator.SUBSIZED
        : characteristic;
  }

  public IteratorSpliterator(@Nullable final Iterator<T> iterator, final long size,
      final int characteristic) {
    this.collection = null;
    this.iterator = iterator;

    this.size = size;
    final int hex = characteristic & Spliterator.CONCURRENT;

    this.characteristic = hex == 0
        ? characteristic | Spliterator.SIZED | Spliterator.SUBSIZED
        : characteristic;
  }

  public IteratorSpliterator(@Nullable final Iterator<T> iterator, final int characteristic) {
    this.collection = null;
    this.iterator = iterator;

    this.size = Long.MAX_VALUE;
    this.characteristic = characteristic & ~Spliterator.SIZED | Spliterator.SUBSIZED;
  }

  @Override
  @Nullable
  public Spliterator<T> trySplit() {
    if (iterator == null) {
      this.iterator = collection.iterator();

      final int size = collection.size();
      this.size = Primitives.toLong(size);
    }

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

    final Object[] values = new Object[newBatch];
    int index = 0;

    for (; index < newBatch && iterator.hasNext(); index++) {
      values[index] = iterator.next();
    }

    this.batch = index;

    if (size != Long.MAX_VALUE) {
      this.size -= Primitives.toLong(index);
    }

    return new ArraySpliterator<>(values, 0, index, characteristic);
  }

  @Override
  public void forEachRemaining(final Consumer<? super T> consumer) {
    if (iterator == null) {
      this.iterator = collection.iterator();

      final int size = collection.size();
      this.size = Primitives.toLong(size);
    }

    iterator.forEachRemaining(consumer);
  }

  @Override
  public boolean tryAdvance(final Consumer<? super T> consumer) {
    if (iterator == null) {
      this.iterator = collection.iterator();

      final int size = collection.size();
      this.size = Primitives.toLong(size);
    }

    final boolean hasNext = iterator.hasNext();

    if (!hasNext) {
      return false;
    }

    final T value = iterator.next();
    consumer.accept(value);

    return true;
  }

  @Override
  public long estimateSize() {
    if (iterator == null) {
      this.iterator = collection.iterator();

      final int size = collection.size();
      this.size = Primitives.toLong(size);
    }

    return size;
  }

  @Override
  public int characteristics() {
    return characteristic;
  }

  @Override
  @Nullable
  public Comparator<? super T> getComparator() {
    final int characteristics = Spliterator.SORTED;

    if (hasCharacteristics(characteristics)) {
      return null;
    }

    throw new IllegalStateException("Spliterator doesn't have the SORTED value");
  }

}
