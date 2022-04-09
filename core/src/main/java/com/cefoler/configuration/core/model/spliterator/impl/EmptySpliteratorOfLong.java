package com.cefoler.configuration.core.model.spliterator.impl;

import com.cefoler.configuration.core.model.spliterator.AbstractEmptySpliterator;
import java.util.Spliterator.OfLong;
import java.util.function.LongConsumer;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public final class EmptySpliteratorOfLong
    extends AbstractEmptySpliterator<Long, OfLong, LongConsumer> implements OfLong {

  private static final EmptySpliteratorOfLong INSTANCE;

  static {
    INSTANCE = new EmptySpliteratorOfLong();
  }

  public static EmptySpliteratorOfLong getInstance() {
    return INSTANCE;
  }

}
