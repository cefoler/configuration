package com.cefoler.configuration.core.adapter;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator.OfInt;
import java.util.Spliterator;
import java.util.function.IntConsumer;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
public final class IteratorIntAdapter implements OfInt, IntConsumer {

  private final Spliterator.OfInt spliterator;

  private boolean contains;
  private int value;

  @Override
  public void accept(final int value) {
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
  public int nextInt() {
    if (!contains && !hasNext()) {
      throw new NoSuchElementException("Value is empty");
    }

    this.contains = false;
    return value;
  }

}
