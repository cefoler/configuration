package com.cefoler.configuration.core.model.spliterator;

import com.google.errorprone.annotations.DoNotCall;
import java.util.Spliterator;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public abstract class AbstractEmptySpliterator<T, U extends Spliterator<T>, V>
    implements EmptySpliterator<T, U, V> {

  @Override
  @DoNotCall("Always throws UnsupportedOperationException")
  public boolean tryAdvance(final V consumer) {
    throw new UnsupportedOperationException("Method not support");
  }

  @Override
  @DoNotCall("Always throws UnsupportedOperationException")
  public U trySplit() {
    throw new UnsupportedOperationException("Method not support");
  }

  @Override
  @DoNotCall("Always throws UnsupportedOperationException")
  public void forEachRemaining(final V consumer) {
    throw new UnsupportedOperationException("Method not support");
  }

  @Override
  @DoNotCall("Always throws UnsupportedOperationException")
  public long estimateSize() {
    throw new UnsupportedOperationException("Method not support");
  }

  @Override
  @DoNotCall("Always throws UnsupportedOperationException")
  public int characteristics() {
    throw new UnsupportedOperationException("Method not support");
  }

}
