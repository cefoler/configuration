package com.celeste.configuration.model.registry;

import com.celeste.configuration.model.registry.type.ReplaceType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Registry responsible for storing and managing information on maps.
 */
@Getter
@SuppressWarnings("unused")
public final class ReplaceRegistry implements Serializable, Cloneable {

  private final Map<String, ReplaceValue> map;

  public ReplaceRegistry() {
    this.map = new ConcurrentHashMap<>();
  }

  @Nullable
  public ReplaceValue register(@NotNull final String key, @Nullable final ReplaceValue value) {
    return map.put(key, value);
  }

  @Nullable
  public ReplaceValue registerIfAbsent(@NotNull final String key,
      @Nullable final ReplaceValue value) {
    return map.putIfAbsent(key, value);
  }

  public void registerAll(@NotNull final Map<String, ReplaceValue> newMap) {
    map.putAll(newMap);
  }

  /**
   * Register a large number of values on a map if they do not exist.
   *
   * @param newMap Map
   */
  public void registerAllIfAbsent(@NotNull final Map<String, ReplaceValue> newMap) {
    final Map<String, ReplaceValue> newValues = newMap.entrySet().stream()
        .filter(entry -> !map.containsKey(entry.getKey()))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue
        ));

    map.putAll(newValues);
  }

  @NotNull
  public ReplaceValue compute(@NotNull final String key,
      @NotNull final BiFunction<String, ReplaceValue, ReplaceValue> function) {
    return map.compute(key, function);
  }

  @NotNull
  public ReplaceValue computeIfAbsent(@NotNull final String key,
      @NotNull final Function<String, ReplaceValue> function) {
    return map.computeIfAbsent(key, function);
  }

  @Nullable
  public ReplaceValue remove(@NotNull final String key) {
    return map.remove(key);
  }

  public void replace(@NotNull final String key, @NotNull final ReplaceValue value) {
    map.replace(key, value);
  }

  @Nullable
  public ReplaceValue get(@NotNull final String key) {
    return map.get(key);
  }

  public boolean contains(@NotNull final String key) {
    return map.containsKey(key);
  }

  @NotNull
  public Set<Entry<String, ReplaceValue>> getEntrySet() {
    return map.entrySet();
  }

  /**
   * Get all keys and values that contain a type.
   *
   * @param type ReplaceType
   * @return Set
   */
  @NotNull
  public Set<Entry<String, ReplaceValue>> getEntrySet(@NotNull final ReplaceType type) {
    return map.entrySet().stream()
        .filter(entry -> entry.getValue().getType().equals(type) || entry.getValue().getType()
            .equals(ReplaceType.ALL))
        .collect(Collectors.toSet());
  }

  @NotNull
  public Set<String> getKeys() {
    return map.keySet();
  }

  /**
   * Get all keys that contain a type.
   *
   * @param type ReplaceType
   * @return Set
   */
  @NotNull
  public Set<String> getKeys(@NotNull final ReplaceType type) {
    return map.entrySet().stream()
        .filter(entry -> entry.getValue().getType().equals(type) || entry.getValue().getType()
            .equals(ReplaceType.ALL))
        .map(Entry::getKey)
        .collect(Collectors.toSet());
  }

  @NotNull
  public Collection<ReplaceValue> getAll() {
    return map.values();
  }

  /**
   * Get all values that contain a type.
   *
   * @param type ReplaceType
   * @return Set
   */
  @NotNull
  public Set<ReplaceValue> getAll(@NotNull final ReplaceType type) {
    return map.values().stream()
        .filter(
            replace -> replace.getType().equals(type) || replace.getType().equals(ReplaceType.ALL))
        .collect(Collectors.toSet());
  }

  /**
   * Get all values ordered.
   *
   * @param comparator Comparator
   * @return Set
   */
  @NotNull
  public Set<ReplaceValue> sort(@NotNull final Comparator<ReplaceValue> comparator) {
    return getAll()
        .stream()
        .sorted(comparator)
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }

  public int size() {
    return map.size();
  }

  public boolean isEmpty() {
    return map.isEmpty();
  }

  public void wipe() {
    map.clear();
  }

  @Override
  @NotNull
  @SneakyThrows
  public ReplaceRegistry clone() {
    return (ReplaceRegistry) super.clone();
  }

  /**
   * An entity that is responsible for storing replace information.
   */
  @Data
  @Builder
  public static final class ReplaceValue {

    @NotNull
    private final String value;

    @NotNull
    private final ReplaceType type;

  }

}
