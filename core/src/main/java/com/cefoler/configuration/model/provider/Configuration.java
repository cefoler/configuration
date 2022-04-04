package com.cefoler.configuration.model.provider;

import com.cefoler.configuration.model.map.ReplaceMap;
import com.cefoler.configuration.model.provider.exception.checked.impl.FailedLoadException;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public interface Configuration extends Serializable {

  void load() throws FailedLoadException;

  void save();

  void saveAndLoad() throws FailedLoadException;

  boolean contains(final String path);

  void set(final String path, @Nullable final Object object);

  <T> T get(final String path);

  <T> T get(final String path, @Nullable final T orElse);

  Object getObject(final String path);

  Object getObject(final String path, @Nullable final Object orElse);

  String getString(final String path);

  String getString(final String path, @Nullable final String orElse);

  int getInt(final String path);

  int getInt(final String path, @Nullable final Integer orElse);

  long getLong(final String path);

  long getLong(final String path, @Nullable final Long orElse);

  double getDouble(final String path);

  double getDouble(final String path, @Nullable final Double orElse);

  boolean getBoolean(final String path);

  boolean getBoolean(final String path, @Nullable final Boolean orElse);

  List<?> getList(final String path);

  List<?> getList(final String path, @Nullable final List<?> orElse);

  List<String> getStringList(final String path);

  List<String> getStringList(final String path, @Nullable final List<String> orElse);

  List<Integer> getIntegerList(final String path);

  List<Integer> getIntegerList(final String path, @Nullable final List<Integer> orElse);

  List<Long> getLongList(final String path);

  List<Long> getLongList(final String path, @Nullable final List<Long> orElse);

  List<Double> getDoubleList(final String path);

  List<Double> getDoubleList(final String path, @Nullable final List<Double> orElse);

  List<Boolean> getBooleanList(final String path);

  List<Boolean> getBooleanList(final String path, @Nullable final List<Boolean> orElse);

  Set<String> getKeys();

  Set<String> getKeys(final String path);

  ReplaceMap getReplacer();

  File getFile();

  ConfigurationType getType();

}
