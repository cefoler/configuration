package com.cefoler.configuration.model.entity.type;

import com.cefoler.configuration.core.util.Streams;
import com.google.common.collect.ImmutableList;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Locale;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Unmodifiable;

@Getter
@ToString
public enum ReplaceType {

  ALL("ALL"),
  SET("SET"),
  GET("GET");

  @Unmodifiable
  private final List<String> names;

  ReplaceType(final String... names) {
    this.names = ImmutableList.copyOf(names);
  }

  public static ReplaceType getReplace(final String replace) {
    final ReplaceType[] values = values();
    final String converted = replace.toLowerCase(Locale.ROOT);

    return Streams.toStream(values)
        .filter(type -> type.getNames().contains(converted))
        .findFirst()
        .orElseThrow(() -> new InvalidParameterException("Invalid replace: " + replace));
  }

  public static ReplaceType getReplace(final String replace, final ReplaceType orElse) {
    final ReplaceType[] values = values();
    final String converted = replace.toUpperCase(Locale.ROOT);

    return Streams.toStream(values)
        .filter(type -> type.getNames().contains(converted))
        .findFirst()
        .orElse(orElse);
  }

}
