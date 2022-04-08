package com.cefoler.configuration.model.map;

import com.cefoler.configuration.model.entity.ReplaceValue;
import com.cefoler.configuration.model.entity.type.ReplaceType;
import com.cefoler.configuration.util.Objects;
import com.google.common.collect.ForwardingMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class ReplaceMap extends ForwardingMap<String, ReplaceValue>
    implements Serializable, Cloneable {

  private static final long serialVersionUID = -7576525366887483422L;

  private static final int DEFAULT_CAPACITY;
  private static final float DEFAULT_FACTOR;

  static {
    DEFAULT_CAPACITY = 0;
    DEFAULT_FACTOR = 0.75F;
  }

  private final Map<String, ReplaceValue> values;

  protected ReplaceMap(final Map<String, ReplaceValue> values) {
    this.values = values;
  }

  public void putAllIfAbsent(final Map<String, ReplaceValue> newValues) {
    newValues.forEach(values::putIfAbsent);
  }

  public Set<Entry<String, ReplaceValue>> entrySet(final ReplaceType type) {
    final Set<Entry<String, ReplaceValue>> entries = entrySet();

    return entries.stream()
        .filter(entry -> {
          final ReplaceValue value = entry.getValue();
          final ReplaceType candidate = value.getType();

          return type == candidate || candidate == ReplaceType.ALL;
        }).collect(Collectors.toSet());
  }

  public Set<String> keySet(final ReplaceType type) {
    final Set<Entry<String, ReplaceValue>> entries = entrySet(type);

    return entries.stream()
        .map(Entry::getKey)
        .collect(Collectors.toSet());
  }

  public Collection<ReplaceValue> values(final ReplaceType type) {
    final Set<Entry<String, ReplaceValue>> entries = entrySet(type);

    return entries.stream()
        .map(Entry::getValue)
        .collect(Collectors.toSet());
  }

  @Override
  @NotNull
  protected Map<String, ReplaceValue> delegate() {
    return values;
  }

  @Override
  @SneakyThrows
  public ReplaceMap clone() {
    final Object clone = super.clone();
    return Objects.cast(clone);
  }

  public static ReplaceMap create() {
    return create(DEFAULT_CAPACITY);
  }

  public static ReplaceMap create(final int capacity) {
    return create(capacity, DEFAULT_FACTOR);
  }

  public static ReplaceMap create(final int capacity, final float factor) {
    final Map<String, ReplaceValue> values = new LinkedHashMap<>(capacity, factor);
    return of(values);
  }

  public static ReplaceMap create(final Supplier<? extends Map<String, ReplaceValue>> supplier) {
    final Map<String, ReplaceValue> values = supplier.get();
    return of(values);
  }

  public static ReplaceMap of(final Map<String, ReplaceValue> values) {
    return new ReplaceMap(values);
  }

}
