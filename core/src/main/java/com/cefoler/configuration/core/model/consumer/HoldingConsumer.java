package com.cefoler.configuration.core.model.consumer;

import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@NoArgsConstructor(staticName = "of")
@AllArgsConstructor(staticName = "of")
@Getter
@ToString
@EqualsAndHashCode
public final class HoldingConsumer<T> implements Consumer<T> {

  @Nullable
  private T value;

  @Override
  public void accept(final T value) {
    this.value = value;
  }

}
