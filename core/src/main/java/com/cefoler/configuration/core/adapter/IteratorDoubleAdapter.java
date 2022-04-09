package com.cefoler.configuration.core.adapter;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator.OfDouble;
import java.util.Spliterator;
import java.util.function.DoubleConsumer;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
public final class IteratorDoubleAdapter implements OfDouble, DoubleConsumer {

  private final Spliterator.OfDouble spliterator;

  private boolean contains;
  private double value;

  @Override
  public void accept(final double value) {
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
  public double nextDouble() {
    if (!contains && !hasNext()) {
      throw new NoSuchElementException("Value is empty");
    }

    this.contains = false;
    return value;
  }

}
