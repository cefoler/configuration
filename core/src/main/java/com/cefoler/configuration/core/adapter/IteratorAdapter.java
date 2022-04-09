package com.cefoler.configuration.core.adapter;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
public final class IteratorAdapter<T> implements Iterator<T>, Consumer<T> {

  private final Spliterator<T> spliterator;

  private boolean contains;
  private T value;

  @Override
  public void accept(final T value) {
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
  public T next() {
    if (!contains && !hasNext()) {
      throw new NoSuchElementException("Value is empty");
    }

    this.contains = false;
    return value;
  }

}
