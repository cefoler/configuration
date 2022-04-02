package com.cefoler.configuration.model.consumer;

import java.util.function.IntConsumer;
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
public final class HoldingIntConsumer implements IntConsumer {

  private int value;

  @Override
  public void accept(final int value) {
    this.value = value;
  }

}
