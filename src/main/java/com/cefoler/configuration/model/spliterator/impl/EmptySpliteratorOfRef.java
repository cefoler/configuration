package com.cefoler.configuration.model.spliterator.impl;

import com.cefoler.configuration.model.spliterator.AbstractEmptySpliterator;
import com.cefoler.configuration.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public final class EmptySpliteratorOfRef<T>
    extends AbstractEmptySpliterator<T, Spliterator<T>, Consumer<? super T>>
    implements Spliterator<T> {

  private static final EmptySpliteratorOfRef<?> INSTANCE;

  static {
    INSTANCE = new EmptySpliteratorOfRef<>();
  }

  public static <T> EmptySpliteratorOfRef<T> getInstance() {
    return Objects.cast(INSTANCE);
  }

}
