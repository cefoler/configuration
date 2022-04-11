package com.cefoler.configuration.core.model.spliterator.impl;

import com.cefoler.configuration.core.model.spliterator.AbstractEmptySpliterator;
import java.util.Spliterator.OfInt;
import java.util.function.IntConsumer;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public final class EmptySpliteratorOfInt
    extends AbstractEmptySpliterator<Integer, OfInt, IntConsumer> implements OfInt {

  private static final EmptySpliteratorOfInt INSTANCE;

  static {
    INSTANCE = new EmptySpliteratorOfInt();
  }

  public static EmptySpliteratorOfInt getInstance() {
    return INSTANCE;
  }

}
