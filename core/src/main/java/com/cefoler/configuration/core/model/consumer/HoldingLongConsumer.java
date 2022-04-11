package com.cefoler.configuration.core.model.consumer;

import java.util.function.LongConsumer;
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
public final class HoldingLongConsumer implements LongConsumer {

  private long value;

  @Override
  public void accept(final long value) {
    this.value = value;
  }

}
