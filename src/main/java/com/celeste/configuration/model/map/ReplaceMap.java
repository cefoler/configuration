package com.celeste.configuration.model.map;

import com.celeste.configuration.model.entity.ReplaceValue;
import com.celeste.configuration.model.entity.type.ReplaceType;
import com.celeste.configuration.util.pattern.CollectorPattern;
import com.google.common.collect.ForwardingMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import lombok.Getter;
import lombok.SneakyThrows;

/**
 * Registry responsible for storing and managing information on maps.
 */
@Getter
public final class ReplaceMap extends ForwardingMap<String, ReplaceValue> implements Cloneable {

  private final Map<String, ReplaceValue> map;

  public ReplaceMap() {
    this.map = new ConcurrentHashMap<>();
  }

  public ReplaceMap(final Supplier<Map<String, ReplaceValue>> supplier) {
    this.map = supplier.get();
  }

  public ReplaceMap(final Map<String, ReplaceValue> values) {
    this();
    putAll(values);
  }

  public ReplaceMap(final Supplier<Map<String, ReplaceValue>> supplier,
      final Map<String, ReplaceValue> values) {
    this(supplier);
    putAll(values);
  }

  /**
   * Register a large number of values on a map if they do not exist.
   *
   * @param newMap Map
   */
  public void putAllIfAbsent(final Map<String, ReplaceValue> newMap) {
    newMap.forEach(map::putIfAbsent);
  }

  /**
   * Get all keys and values that contain a type.
   *
   * @param type ReplaceType
   * @return Set
   */
  public Set<Entry<String, ReplaceValue>> entrySet(final ReplaceType type) {
    return map.entrySet().stream()
        .filter(entry -> entry.getValue().getType().equals(type)
            || entry.getValue().getType().equals(ReplaceType.ALL))
        .collect(CollectorPattern.toSet());
  }

  /**
   * Get all keys that contain a type.
   *
   * @param type ReplaceType
   * @return Set
   */
  public Set<String> keySet(final ReplaceType type) {
    return map.entrySet().stream()
        .filter(entry -> entry.getValue().getType().equals(type)
            || entry.getValue().getType().equals(ReplaceType.ALL))
        .map(Entry::getKey)
        .collect(CollectorPattern.toSet());
  }

  /**
   * Get all values that contain a type.
   *
   * @param type ReplaceType
   * @return Set
   */
  public Collection<ReplaceValue> values(final ReplaceType type) {
    return map.values().stream()
        .filter(replace -> replace.getType().equals(type)
            || replace.getType().equals(ReplaceType.ALL))
        .collect(CollectorPattern.toSet());
  }

  /**
   * Get all values ordered.
   *
   * @param comparator Comparator
   * @return Set
   */
  public Set<ReplaceValue> sort(final Comparator<ReplaceValue> comparator) {
    return this.values()
        .stream()
        .sorted(comparator)
        .collect(CollectorPattern.toCollection(LinkedHashSet::new));
  }

  @Override
  protected Map<String, ReplaceValue> delegate() {
    return map;
  }

  @Override
  @SneakyThrows
  public ReplaceMap clone() {
    return (ReplaceMap) super.clone();
  }

}
