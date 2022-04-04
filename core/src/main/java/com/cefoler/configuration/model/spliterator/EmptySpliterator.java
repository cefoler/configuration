package com.cefoler.configuration.model.spliterator;

public interface EmptySpliterator<T, U, V> {

  boolean tryAdvance(final V consumer);

  U trySplit();

  void forEachRemaining(final V consumer);

  long estimateSize();

  int characteristics();

}
