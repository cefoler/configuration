package com.cefoler.configuration.model.provider;

import com.cefoler.configuration.model.entity.ReplaceValue;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

public interface Module extends Serializable {

  boolean contains(final String path);

  <T> T get(final String path);

  <T> T get(final String path, @Nullable final T orElse);

  Object getObject(final String path);

  Object getObject(final String path, @Nullable final Object orElse);

  String getString(final String path);

  String getString(final String path, @Nullable final String orElse);

  Number getNumber(final String path);

  Number getNumber(final String path, @Nullable final Number orElse);

  byte getByte(final String path);

  byte getByte(final String path, @Nullable final Byte orElse);

  short getShort(final String path);

  short getShort(final String path, @Nullable final Short orElse);

  int getInt(final String path);

  int getInt(final String path, @Nullable final Integer orElse);

  long getLong(final String path);

  long getLong(final String path, @Nullable final Long orElse);

  float getFloat(final String path);

  float getFloat(final String path, @Nullable final Float orElse);

  double getDouble(final String path);

  double getDouble(final String path, @Nullable final Double orElse);

  boolean getBoolean(final String path);

  boolean getBoolean(final String path, @Nullable final Boolean orElse);

  Module getModule(final String path);

  Module getModule(final String path, @Nullable final Module orElse);

  List<?> getList(final String path);

  List<?> getList(final String path, @Nullable final List<?> orElse);

  List<Object> getObjectList(final String path);

  List<Object> getObjectList(final String path, @Nullable final List<Object> orElse);

  List<String> getStringList(final String path);

  List<String> getStringList(final String path, @Nullable final List<String> orElse);

  List<? extends Number> getNumberList(final String path);

  List<? extends Number> getNumberList(final String path,
      @Nullable final List<? extends Number> orElse);

  List<Byte> getByteList(final String path);

  List<Byte> getByteList(final String path, @Nullable final List<Byte> orElse);

  List<Short> getShortList(final String path);

  List<Short> getShortList(final String path, @Nullable final List<Short> orElse);

  List<Integer> getIntegerList(final String path);

  List<Integer> getIntegerList(final String path, @Nullable final List<Integer> orElse);

  List<Long> getLongList(final String path);

  List<Long> getLongList(final String path, @Nullable final List<Long> orElse);

  List<Float> getFloatList(final String path);

  List<Float> getFloatList(final String path, @Nullable final List<Float> orElse);

  List<Double> getDoubleList(final String path);

  List<Double> getDoubleList(final String path, @Nullable final List<Double> orElse);

  List<Boolean> getBooleanList(final String path);

  List<Boolean> getBooleanList(final String path, @Nullable final List<Boolean> orElse);

  List<Module> getModuleList(final String path);

  List<Module> getModuleList(final String path, @Nullable final List<Module> orElse);

  Set<String> getKeys();

  Set<String> getKeys(final String path);

  @Unmodifiable
  Map<?, ?> getConfiguration();

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
