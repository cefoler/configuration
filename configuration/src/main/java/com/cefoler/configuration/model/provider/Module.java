package com.cefoler.configuration.model.provider;

import com.cefoler.configuration.model.entity.ReplaceValue;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

public interface Module extends Serializable {

  boolean contains(final String path);

  <T> T get(final String path);

  <T> T get(final String path, @Nullable final T orElse);

  <T> T getOrGet(final String path, final Supplier<? extends T> orElse);

  Object getObject(final String path);

  Object getObject(final String path, @Nullable final Object orElse);

  Object getObjectOrGet(final String path, final Supplier<?> orElse);

  String getString(final String path);

  String getString(final String path, @Nullable final String orElse);

  String getStringOrGet(final String path, final Supplier<String> orElse);

  Number getNumber(final String path);

  Number getNumber(final String path, @Nullable final Number orElse);

  Number getNumberOrGet(final String path, final Supplier<? extends Number> orElse);

  byte getByte(final String path);

  Byte getByte(final String path, @Nullable final Number orElse);

  Byte getByteOrGet(final String path, final Supplier<? extends Number> orElse);

  short getShort(final String path);

  Short getShort(final String path, @Nullable final Number orElse);

  Short getShortOrGet(final String path, final Supplier<? extends Number> orElse);

  int getInt(final String path);

  Integer getInt(final String path, @Nullable final Number orElse);

  Integer getIntOrGet(final String path, final Supplier<? extends Number> orElse);

  long getLong(final String path);

  Long getLong(final String path, @Nullable final Number orElse);

  Long getLongOrGet(final String path, final Supplier<? extends Number> orElse);

  float getFloat(final String path);

  Float getFloat(final String path, @Nullable final Number orElse);

  Float getFloatOrGet(final String path, final Supplier<? extends Number> orElse);

  double getDouble(final String path);

  Double getDouble(final String path, @Nullable final Number orElse);

  Double getDoubleOrGet(final String path, final Supplier<? extends Number> orElse);

  boolean getBoolean(final String path);

  Boolean getBoolean(final String path, @Nullable final Boolean orElse);

  Boolean getBooleanOrGet(final String path, final Supplier<Boolean> orElse);

  Module getModule(final String path);

  Module getModule(final String path, @Nullable final Module orElse);

  Module getModuleOrGet(final String path, final Supplier<? extends Module> orElse);

  List<?> getList(final String path);

  List<?> getList(final String path, @Nullable final List<?> orElse);

  List<?> getListOrGet(final String path, final Supplier<? extends List<?>> orElse);

  List<Object> getObjectList(final String path);

  List<Object> getObjectList(final String path, @Nullable final List<?> orElse);

  List<Object> getObjectListOrGet(final String path, final Supplier<? extends List<?>> orElse);

  List<String> getStringList(final String path);

  List<String> getStringList(final String path, @Nullable final List<String> orElse);

  List<String> getStringListOrGet(final String path, final Supplier<? extends List<String>> orElse);

  List<? extends Number> getNumberList(final String path);

  List<? extends Number> getNumberList(final String path,
      @Nullable final List<? extends Number> orElse);

  List<? extends Number> getNumberListOrGet(final String path,
      final Supplier<? extends List<? extends Number>> orElse);

  List<Byte> getByteList(final String path);

  List<Byte> getByteList(final String path, @Nullable final List<? extends Number> orElse);

  List<Byte> getByteListOrGet(final String path,
      final Supplier<? extends List<? extends Number>> orElse);

  List<Short> getShortList(final String path);

  List<Short> getShortList(final String path, @Nullable final List<? extends Number> orElse);

  List<Short> getShortListOrGet(final String path,
      final Supplier<? extends List<? extends Number>> orElse);

  List<Integer> getIntegerList(final String path);

  List<Integer> getIntegerList(final String path, @Nullable final List<? extends Number> orElse);

  List<Integer> getIntegerListOrGet(final String path,
      final Supplier<? extends List<? extends Number>> orElse);

  List<Long> getLongList(final String path);

  List<Long> getLongList(final String path, @Nullable final List<? extends Number> orElse);

  List<Long> getLongListOrGet(final String path,
      final Supplier<? extends List<? extends Number>> orElse);

  List<Float> getFloatList(final String path);

  List<Float> getFloatList(final String path, @Nullable final List<? extends Number> orElse);

  List<Float> getFloatListOrGet(final String path,
      final Supplier<? extends List<? extends Number>> orElse);

  List<Double> getDoubleList(final String path);

  List<Double> getDoubleList(final String path, @Nullable final List<? extends Number> orElse);

  List<Double> getDoubleListOrGet(final String path,
      final Supplier<? extends List<? extends Number>> orElse);

  List<Boolean> getBooleanList(final String path);

  List<Boolean> getBooleanList(final String path, @Nullable final List<Boolean> orElse);

  List<Boolean> getBooleanListOrGet(final String path,
      final Supplier<? extends List<Boolean>> orElse);

  List<? extends Module> getModuleList(final String path);

  List<? extends Module> getModuleList(final String path,
      @Nullable final List<? extends Module> orElse);

  List<? extends Module> getModuleListOrGet(final String path,
      final Supplier<? extends List<? extends Module>> orElse);

  Set<String> getKeys();

  Set<String> getKeys(final String path);

  @Unmodifiable
  Map<?, ?> getValues();

  @Unmodifiable
  Map<Predicate<Object>, Function<Object, Object>> getConverters();

  void addConverter(final Predicate<Object> filter, final Function<Object, Object> function);

  void addConverters(final Map<Predicate<Object>, Function<Object, Object>> functions);

  void removeConverter(final Predicate<Object> filter);

  @Unmodifiable
  Map<String, ReplaceValue> getReplacers();

  void addReplacer(final String key, final ReplaceValue replace);

  void addReplacers(final Map<String, ReplaceValue> replaces);

  void removeReplacer(final String key);

}
