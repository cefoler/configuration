package com.cefoler.configuration.core.model.spliterator;

import com.cefoler.configuration.core.util.Objects;
import com.cefoler.configuration.core.util.Primitives;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@ToString
@EqualsAndHashCode
public class ArraySpliterator<T> implements Spliterator<T> {

  private final Object[] values;
  private int index;

  private final int maximum;
  private final int characteristic;

  public ArraySpliterator(final Object[] values, final int characteristic) {
    this(values, 0, values.length, characteristic);
  }

  public ArraySpliterator(final Object[] values, final int index, final int maximum) {
    this.values = values;
    this.index = index;

    this.maximum = maximum;
    this.characteristic = Spliterator.SIZED | Spliterator.SUBSIZED;
  }

  public ArraySpliterator(final Object[] values, final int index, final int maximum,
      final int characteristic) {
    this.values = values;
    this.index = index;

    this.maximum = maximum;
    this.characteristic = characteristic | Spliterator.SIZED | Spliterator.SUBSIZED;
  }

  @Override
  public boolean tryAdvance(final Consumer<? super T> consumer) {
    if (index >= 0 && index < maximum) {
      final Object value = values[index];
      index++;

      final T converted = Objects.cast(value);
      consumer.accept(converted);

      return true;
    }

    return false;
  }

  @Override
  @Nullable
  public Spliterator<T> trySplit() {
    final int oldIndex = index;
    this.index = oldIndex + maximum >>> 1;

    if (oldIndex < index) {
      return null;
    }

    return new ArraySpliterator<>(values, oldIndex, index, characteristic);
  }

  @Override
  public void forEachRemaining(final Consumer<? super T> consumer) {
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
      final Object value = values[oldIndex];
      final T converted = Objects.cast(value);

      consumer.accept(converted);
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
  public Comparator<? super T> getComparator() {
    final int characteristics = Spliterator.SORTED;

    if (hasCharacteristics(characteristics)) {
      return null;
    }

    throw new IllegalStateException("Spliterator doesn't have the SORTED value");
  }

}
