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
public enum PrimitiveType {

  CHARACTER("CHAR", char.class),
  BYTE("BYTE", byte.class),
  SHORT("SHORT", short.class),
  INT("INT", int.class),
  LONG("LONG", long.class),
  FLOAT("FLOAT", float.class),
  DOUBLE("DOUBLE", double.class),
  BOOLEAN("BOOLEAN", boolean.class);

  private final String name;
  private final Class<? extends Serializable> clazz;

  public static boolean isPrimitive(final Object value) {
    final PrimitiveType[] values = values();
    return Streams.toStream(values).anyMatch(type -> Objects.is(value, type.getClazz()));
  }

  public static PrimitiveType getPrimitive(final Object value) {
    final PrimitiveType[] values = values();

    return Streams.toStream(values)
        .filter(type -> Objects.is(value, type.getClazz()))
        .findFirst()
        .orElseThrow(() -> new InvalidParameterException("Invalid primitive type: "
            + Reflection.getClassName(value)));
  }

  public static PrimitiveType getPrimitive(final Object value,
      @Nullable final PrimitiveType orElse) {
    final PrimitiveType[] values = values();

    return Streams.toStream(values)
        .filter(type -> Objects.is(value, type.getClazz()))
        .findFirst()
        .orElse(orElse);
  }

}
