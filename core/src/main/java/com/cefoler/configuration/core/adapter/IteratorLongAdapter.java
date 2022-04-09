package com.cefoler.configuration.core.adapter;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator.OfLong;
import java.util.Spliterator;
import java.util.function.LongConsumer;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
public final class IteratorLongAdapter implements OfLong, LongConsumer {

  private final Spliterator.OfLong spliterator;

  private boolean contains;
  private long value;

  @Override
  public void accept(final long value) {
    this.contains = true;
    this.value = value;
  }

  @Override
  public boolean hasNext() {
    if (!contains) {
      spliterator.tryAdvance(this);
    }

    return contains;
  }

  @Override
  public long nextLong() {
    if (!contains && !hasNext()) {
      throw new NoSuchElementException("Value is empty");
    }

    this.contains = false;
    return value;
  }

}
