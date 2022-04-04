package com.cefoler.configuration.model.spliterator.impl;

import com.cefoler.configuration.model.spliterator.AbstractEmptySpliterator;
import java.util.Spliterator.OfDouble;
import java.util.function.DoubleConsumer;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public final class EmptySpliteratorOfDouble
    extends AbstractEmptySpliterator<Double, OfDouble, DoubleConsumer> implements OfDouble {

  private static final EmptySpliteratorOfDouble INSTANCE;

  static {
    INSTANCE = new EmptySpliteratorOfDouble();
  }

  public static EmptySpliteratorOfDouble getInstance() {
    return INSTANCE;
  }

}
