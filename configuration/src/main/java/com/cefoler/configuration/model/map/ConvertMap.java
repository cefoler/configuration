package com.cefoler.configuration.model.map;

import com.cefoler.configuration.core.util.Objects;
import com.google.common.collect.ForwardingMap;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class ConvertMap extends ForwardingMap<Predicate<Object>, Function<Object, Object>>
    implements Serializable, Cloneable {

  private static final long serialVersionUID = -3919719753059628925L;

  private static final int DEFAULT_CAPACITY;
  private static final float DEFAULT_FACTOR;

  static {
    DEFAULT_CAPACITY = 0;
    DEFAULT_FACTOR = 0.75F;
  }

  private final Map<Predicate<Object>, Function<Object, Object>> values;

  protected ConvertMap(final Map<Predicate<Object>, Function<Object, Object>> values) {
    this.values = values;
  }

  @Override
  @NotNull
  protected Map<Predicate<Object>, Function<Object, Object>> delegate() {
    return values;
  }

  @Override
  @SneakyThrows
  public ConvertMap clone() {
    final Object clone = super.clone();
    return Objects.cast(clone);
  }

  public static ConvertMap create() {
    return create(DEFAULT_CAPACITY);
  }

  public static ConvertMap create(final int capacity) {
    return create(capacity, DEFAULT_FACTOR);
  }

  public static ConvertMap create(final int capacity, final float factor) {
    final Map<Predicate<Object>, Function<Object, Object>> values = new LinkedHashMap<>(capacity,
        factor);

    return of(values);
  }

  public static ConvertMap create(
      final Supplier<? extends Map<Predicate<Object>, Function<Object, Object>>> supplier) {
    final Map<Predicate<Object>, Function<Object, Object>> values = supplier.get();
    return of(values);
  }

  public static ConvertMap of(final Map<Predicate<Object>, Function<Object, Object>> values) {
    return new ConvertMap(values);
  }

}
