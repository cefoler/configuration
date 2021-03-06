package com.cefoler.configuration.core.model.properties;

import com.cefoler.configuration.core.util.Objects;
import java.util.Map;
import java.util.Properties;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Resources extends Properties {

  private static final long serialVersionUID = -1230180278120635806L;

  protected Resources(final Map<?, ?> values) {
    addAll(values);
  }

  public synchronized Resources add(final Object key, final Object value) {
    put(key, value);
    return this;
  }

  public synchronized Resources addIfAbsent(final Object key, final Object value) {
    putIfAbsent(key, value);
    return this;
  }

  public synchronized Resources addAll(final Map<?, ?> values) {
    putAll(values);
    return this;
  }

  public synchronized <T> T find(final Object key) {
    final Object value = get(key);
    return Objects.cast(value);
  }

  public synchronized <T> T find(final Object key, @Nullable final T orElse) {
    final Object value = getOrDefault(key, orElse);
    return Objects.cast(value);
  }

  public static Resources create() {
    return new Resources();
  }

  public static Resources create(final Map<?, ?> values) {
    return new Resources(values);
  }

  @Override
  public synchronized Resources clone() {
    final Object value = super.clone();
    return Objects.cast(value);
  }

}
