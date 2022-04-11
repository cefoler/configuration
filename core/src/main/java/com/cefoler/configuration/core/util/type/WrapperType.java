package com.cefoler.configuration.core.util.type;

import com.cefoler.configuration.core.util.Objects;
import com.cefoler.configuration.core.util.Reflection;
import com.cefoler.configuration.core.util.Streams;
import java.io.Serializable;
import java.security.InvalidParameterException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
@Getter
@ToString
public enum WrapperType {

  CHARACTER("CHARACTER", Character.class),
  STRING("STRING", String.class),
  BYTE("BYTE", Byte.class),
  SHORT("SHORT", Short.class),
  INTEGER("INTEGER", Integer.class),
  LONG("LONG", Long.class),
  FLOAT("FLOAT", Float.class),
  DOUBLE("DOUBLE", Double.class),
  BOOLEAN("BOOLEAN", Boolean.class);

  private final String name;
  private final Class<? extends Serializable> clazz;

  public static boolean isWrapper(final Object value) {
    final WrapperType[] values = values();

    return Streams.toStream(values)
        .anyMatch(type -> Objects.is(value, type.getClazz()));
  }

  public static WrapperType getWrapper(final Object value) {
    final WrapperType[] values = values();

    return Streams.toStream(values)
        .filter(type -> Objects.is(value, type.getClazz()))
        .findFirst()
        .orElseThrow(() -> new InvalidParameterException("Invalid wrapper type: "
            + Reflection.getClassName(value)));
  }

  public static WrapperType getWrapper(final Object value, @Nullable final WrapperType orElse) {
    final WrapperType[] values = values();

    return Streams.toStream(values)
        .filter(type -> Objects.is(value, type.getClazz()))
        .findFirst()
        .orElse(orElse);
  }

}
