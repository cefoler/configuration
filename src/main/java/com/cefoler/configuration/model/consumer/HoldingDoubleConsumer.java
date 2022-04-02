package com.cefoler.configuration.model.consumer;

import java.util.function.DoubleConsumer;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(staticName = "of")
@AllArgsConstructor(staticName = "of")
@Getter
@ToString
@EqualsAndHashCode
public final class HoldingDoubleConsumer implements DoubleConsumer {

  private double value;

  @Override
  public void accept(final double value) {
    this.value = value;
  }

}
