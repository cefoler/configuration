package com.cefoler.configuration.model.provider;

import com.cefoler.configuration.core.exception.unchecked.data.impl.InvalidDataException;
import com.cefoler.configuration.core.model.lambda.supplier.ThrowSupplier;
import com.cefoler.configuration.core.util.Objects;
import com.cefoler.configuration.core.util.Reflection;
import com.cefoler.configuration.core.util.Streams;
import com.cefoler.configuration.model.entity.ReplaceValue;
import com.cefoler.configuration.model.entity.type.ReplaceType;
import com.cefoler.configuration.model.map.ConvertMap;
import com.cefoler.configuration.model.map.ReplaceMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

@ToString
@EqualsAndHashCode
public abstract class AbstractModule implements Module {

  private static final long serialVersionUID = -1789125045200316519L;

  protected Map<?, ?> values;

  protected final ConvertMap converters;
  protected final ReplaceMap replacers;

  protected AbstractModule() {
    this(new LinkedHashMap<>(0));
  }

  protected AbstractModule(final Supplier<? extends Map<?, ?>> supplier) {
    this(supplier.get());
  }

  protected AbstractModule(final Map<?, ?> values) {
    this.values = values;

    this.converters = ConvertMap.create();
    this.replacers = ReplaceMap.create();

    final Map<Predicate<Object>, Function<Object, Object>> newConverters = loadConverters();
    final Map<String, ReplaceValue> newReplacers = loadReplacers();

    converters.putAll(newConverters);
    replacers.putAll(newReplacers);
  }

  @Override
  public boolean contains(final String path) {
    final Object value = getValue(path);
    return value != null;
  }

  @Override
  public <U> U get(final String path) {
    final Object value = getValue(path);

    if (value == null) {
      throw new InvalidDataException("Path " + path + " was not found");
    }

    return Objects.cast(value);
  }

  @Override
  public <U> U get(final String path, @Nullable final U orElse) {
    final Object value = getValue(path);
    return value != null ? Objects.cast(value) : orElse;
  }

  @Override
  public Object getObject(final String path) {
    return get(path);
  }

  @Override
  public Object getObject(final String path, @Nullable final Object orElse) {
    return get(path, orElse);
  }

  @Override
  public String getString(final String path) {
    return get(path);
  }

  @Override
  public String getString(final String path, @Nullable final String orElse) {
    return get(path, orElse);
  }

  @Override
  public Number getNumber(final String path) {
    return get(path);
  }

  @Override
  public Number getNumber(final String path, @Nullable final Number orElse) {
    return get(path, orElse);
  }

  @Override
  public byte getByte(final String path) {
    final Number value = getNumber(path);
    return value.byteValue();
  }

  @Override
  public byte getByte(final String path, @Nullable final Byte orElse) {
    final Number value = getNumber(path, orElse);
    return value.byteValue();
  }

  @Override
  public short getShort(final String path) {
    final Number value = getNumber(path);
    return value.shortValue();
  }

  @Override
  public short getShort(final String path, @Nullable final Short orElse) {
    final Number value = getNumber(path, orElse);
    return value.shortValue();
  }

  @Override
  public int getInt(final String path) {
    final Number value = getNumber(path);
    return value.intValue();
  }

  @Override
  public int getInt(final String path, @Nullable final Integer orElse) {
    final Number value = getNumber(path, orElse);
    return value.intValue();
  }

  @Override
  public long getLong(final String path) {
    final Number value = getNumber(path);
    return value.longValue();
  }

  @Override
  public long getLong(final String path, @Nullable final Long orElse) {
    final Number value = getNumber(path, orElse);
    return value.longValue();
  }

  @Override
  public float getFloat(final String path) {
    final Number value = getNumber(path);
    return value.floatValue();
  }

  @Override
  public float getFloat(final String path, @Nullable final Float orElse) {
    final Number value = getNumber(path, orElse);
    return value.floatValue();
  }

  @Override
  public double getDouble(final String path) {
    final Number value = getNumber(path);
    return value.doubleValue();
  }

  @Override
  public double getDouble(final String path, @Nullable final Double orElse) {
    final Number value = getNumber(path, orElse);
    return value.doubleValue();
  }

  @Override
  public boolean getBoolean(final String path) {
    return get(path);
  }

  @Override
  public boolean getBoolean(final String path, @Nullable final Boolean orElse) {
    return get(path, orElse);
  }

  @Override
  public Module getModule(final String path) {
    return get(path);
  }

  @Override
  public Module getModule(final String path, @Nullable final Module orElse) {
    return get(path, orElse);
  }

  @Override
  public List<?> getList(final String path) {
    final List<?> values = get(path);
    return ImmutableList.copyOf(values);
  }

  @Override
  public List<?> getList(final String path, @Nullable final List<?> orElse) {
    final List<?> values = get(path, orElse);
    return ImmutableList.copyOf(values);
  }

  @Override
  public List<Object> getObjectList(final String path) {
    final List<Object> values = get(path);
    return ImmutableList.copyOf(values);
  }

  @Override
  public List<Object> getObjectList(final String path, @Nullable final List<Object> orElse) {
    final List<Object> values = get(path, orElse);
    return ImmutableList.copyOf(values);
  }

  @Override
  public List<String> getStringList(final String path) {
    final List<String> values = get(path);
    return ImmutableList.copyOf(values);
  }

  @Override
  public List<String> getStringList(final String path, @Nullable final List<String> orElse) {
    final List<String> values = get(path, orElse);
    return ImmutableList.copyOf(values);
  }

  @Override
  public List<? extends Number> getNumberList(final String path) {
    final List<? extends Number> values = get(path);
    return ImmutableList.copyOf(values);
  }

  @Override
  public List<? extends Number> getNumberList(final String path,
      @Nullable final List<? extends Number> orElse) {
    final List<? extends Number> values = get(path, orElse);
    return ImmutableList.copyOf(values);
  }

  @Override
  public List<Byte> getByteList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::byteValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Byte> getByteList(final String path, @Nullable final List<Byte> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::byteValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Short> getShortList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::shortValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Short> getShortList(final String path, @Nullable final List<Short> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::shortValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Integer> getIntegerList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::intValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Integer> getIntegerList(final String path, @Nullable final List<Integer> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::intValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Long> getLongList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::longValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Long> getLongList(final String path, @Nullable final List<Long> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::longValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Float> getFloatList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::floatValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Float> getFloatList(final String path, @Nullable final List<Float> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::floatValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Double> getDoubleList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::doubleValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Double> getDoubleList(final String path, @Nullable final List<Double> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::doubleValue)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public List<Boolean> getBooleanList(final String path) {
    final List<Boolean> results = get(path);
    return ImmutableList.copyOf(results);
  }

  @Override
  public List<Boolean> getBooleanList(final String path, @Nullable final List<Boolean> orElse) {
    final List<Boolean> results = get(path, orElse);
    return ImmutableList.copyOf(results);
  }

  @Override
  public List<Module> getModuleList(final String path) {
    final List<Module> results = get(path);
    return ImmutableList.copyOf(results);
  }

  @Override
  public List<Module> getModuleList(final String path, @Nullable final List<Module> orElse) {
    final List<Module> results = get(path, orElse);
    return ImmutableList.copyOf(results);
  }

  @Override
  public Set<String> getKeys() {
    final Set<?> keys = values.keySet();

    return keys.stream()
        .map(Object::toString)
        .collect(ImmutableSet.toImmutableSet());
  }

  @Override
  public Set<String> getKeys(final String path) {
    Object result = values;

    for (final String key : path.split("\\.")) {
      if (!(result instanceof Map)) {
        throw new InvalidDataException("Path " + path + " was not found");
      }

      final Map<?, ?> converted = Objects.cast(result);
      result = converted.get(key);
    }

    if (result instanceof Map) {
      final Map<?, ?> converted = Objects.cast(result);
      final Set<?> keys = converted.keySet();

      return keys.stream()
          .map(Object::toString)
          .collect(ImmutableSet.toImmutableSet());
    }

    if (result instanceof Collection) {
      final Collection<?> converted = Objects.cast(result);

      return converted.stream()
          .map(Object::toString)
          .collect(ImmutableSet.toImmutableSet());
    }

    if (result instanceof Object[]) {
      final Object[] converted = Objects.cast(result);

      return Streams.toStream(converted)
          .map(Object::toString)
          .collect(ImmutableSet.toImmutableSet());
    }

    throw new InvalidDataException("Path " + path + " was not found");
  }

  @Unmodifiable
  public Map<?, ?> getValues() {
    return ImmutableMap.copyOf(values);
  }

  @Override
  @Unmodifiable
  public Map<Predicate<Object>, Function<Object, Object>> getConverters() {
    return ImmutableMap.copyOf(converters);
  }

  @Override
  public void addConverter(final Predicate<Object> filter,
      final Function<Object, Object> function) {
    converters.put(filter, function);
  }

  @Override
  public void addConverters(final Map<Predicate<Object>, Function<Object, Object>> functions) {
    converters.putAll(functions);
  }

  @Override
  public void removeConverter(final Predicate<Object> filter) {
    converters.remove(filter);
  }

  @Override
  @Unmodifiable
  public Map<String, ReplaceValue> getReplacers() {
    return ImmutableMap.copyOf(replacers);
  }

  @Override
  public void addReplacer(final String key, final ReplaceValue replace) {
    replacers.put(key, replace);
  }

  @Override
  public void addReplacers(final Map<String, ReplaceValue> replaces) {
    replacers.putAll(replaces);
  }

  @Override
  public void removeReplacer(final String key) {
    replacers.remove(key);
  }

  @Nullable
  protected Object getValue(final String path) {
    Object value = values;

    for (final String key : path.split("\\.")) {
      if (!(value instanceof Map)) {
        return null;
      }

      final Map<?, ?> converted = Objects.cast(value);
      value = converted.get(key);
    }

    final Object converted = convert(value);
    final ReplaceType type = ReplaceType.GET;

    return replace(converted, type);
  }

  protected Object convert(final Object value) {
    final Set<Entry<Predicate<Object>, Function<Object, Object>>> entries = converters.entrySet();

    final Optional<Function<Object, Object>> optional = entries.stream()
        .filter(entry -> entry.getKey().test(value))
        .map(Entry::getValue)
        .findFirst();

    if (!optional.isPresent()) {
      return value;
    }

    final Function<Object, Object> function = optional.get();
    return function.apply(value);
  }

  protected Object replace(final Object value, final ReplaceType type) {
    if (value instanceof CharSequence) {
      CharSequence converted = Objects.cast(value);

      for (final Entry<String, ReplaceValue> entry : replacers.entrySet(type)) {
        final String key = entry.getKey();
        final ReplaceValue replace = entry.getValue();

        final String replacer = replace.getValue();
        final String pattern = "(?i)" + key;

        final Pattern regex = Pattern.compile(pattern);
        final Matcher matcher = regex.matcher(converted);

        converted = matcher.replaceAll(replacer);
      }

      return Objects.cast(converted);
    }

    if (value instanceof Collection) {
      final Collection<?> converted = Objects.cast(value);

      if (converted.isEmpty()) {
        return value;
      }

      final Collection<?> collection = converted.stream()
          .map(candidate -> replace(candidate, type))
          .collect(Collectors.toCollection(ThrowSupplier.convert(() ->
              Reflection.instance(value), ArrayList::new)));

      return Objects.cast(collection);
    }

    if (value instanceof Object[]) {
      final Object[] converted = Objects.cast(value);
      final int length = converted.length;

      if (length == 0) {
        return value;
      }

      final Object[] array = Streams.toStream(converted)
          .map(candidate -> replace(candidate, type))
          .toArray();

      return Objects.cast(array);
    }

    return value;
  }

  protected Map<Predicate<Object>, Function<Object, Object>> loadConverters() {
    return ImmutableMap.of();
  }

  protected Map<String, ReplaceValue> loadReplacers() {
    return ImmutableMap.of();
  }

}
