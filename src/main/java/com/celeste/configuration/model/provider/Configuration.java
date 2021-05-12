package com.celeste.configuration.model.provider;

import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.exception.FailedSaveException;
import com.celeste.configuration.model.registry.ReplaceRegistry;
import com.celeste.configuration.model.type.ConfigurationType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

/**
 * A root interface responsible for the standard of the methods regardless
 * of the class that will implement it.
 */
public interface Configuration {

  /**
   * Loads the configuration.
   *
   * @throws FileNotFoundException Throws when file was not found
   * @throws FailedLoadException   Throws when it wasn't able to load the file
   */
  void load() throws FileNotFoundException, FailedLoadException;

  /**
   * Saves the configuration.
   *
   * @throws FailedSaveException Throws when file wasn't able to save
   */
  void save() throws FailedSaveException;

  /**
   * Saves and update the configuration.
   *
   * @throws FailedLoadException Throws when it fails to load
   * @throws FailedSaveException Throws when it fails to save
   */
  void saveAndLoad() throws FailedSaveException, FailedLoadException;

  /**
   * Check if the value contains in the configuration.
   *
   * @param path String
   * @return boolean
   */
  boolean contains(final String path);

  /**
   * Sets a value into the configuration.
   *
   * @param path String
   * @param object Object
   */
  void set(final String path, @Nullable final Object object);

  /**
   * Gets the value from path in the configuration.
   *
   * @param path String
   * @param <T> Object
   * @return Object
   */
  <T> T get(final String path);

  /**
   * Returns a generic value from that path.
   *
   * @param path String
   * @param orElse T
   * @param <T> T
   * @return T
   */
  <T> T get(final String path, @Nullable final T orElse);

  /**
   * Gets Object from path.
   *
   * @param path String
   * @return Object
   */
  Object getObject(final String path);

  /**
   * Gets Object from path, if nulls return a value.
   *
   * @param path String
   * @param orElse String
   * @return Object
   */
  Object getObject(final String path, @Nullable final Object orElse);

  /**
   * Gets string from path.
   *
   * @param path String
   * @return string
   */
  String getString(final String path);

  /**
   * Gets string from path, if nulls return a value.
   *
   * @param path String
   * @param orElse String
   * @return string
   */
  String getString(final String path, @Nullable final String orElse);

  /**
   * Gets int from path.
   *
   * @param path String
   * @return int
   */
  int getInt(final String path);

  /**
   * Gets int from path, if nulls return a value.
   *
   * @param path String
   * @param orElse int
   * @return int
   */
  int getInt(final String path, @Nullable final Integer orElse);

  /**
   * Gets long from path.
   *
   * @param path String
   * @return long
   */
  long getLong(final String path);

  /**
   * Gets long from path, if nulls return a value.
   *
   * @param path String
   * @param orElse long
   * @return long
   */
  long getLong(final String path, @Nullable final Long orElse);

  /**
   * Gets double from path.
   *
   * @param path String
   * @return double
   */
  double getDouble(final String path);

  /**
   * Gets double from path, if nulls return a value.
   *
   * @param path String
   * @param orElse double
   * @return double
   */
  double getDouble(final String path, @Nullable final Double orElse);

  /**
   * Gets boolean from path.
   *
   * @param path String
   * @return boolean
   */
  boolean getBoolean(final String path);

  /**
   * Gets boolean from path, if nulls return a value.
   *
   * @param path String
   * @param orElse boolean
   * @return boolean
   */
  boolean getBoolean(final String path, @Nullable final Boolean orElse);

  /**
   * Get list from path.
   *
   * @param path String
   * @return List
   */
  List<?> getList(final String path);

  /**
   * Get list from path, if nulls return a value.
   *
   * @param path String
   * @param orElse List
   * @return List
   */
  List<?> getList(final String path, @Nullable final List<?> orElse);

  /**
   * Get string list from path.
   *
   * @param path String
   * @return List
   */
  List<String> getStringList(final String path);

  /**
   * Get integer list from path.
   *
   * @param path String
   * @return List
   */
  List<Integer> getIntegerList(final String path);

  /**
   * Get long list from path.
   *
   * @param path String
   * @return List
   */
  List<Long> getLongList(final String path);

  /**
   * Get double list from path.
   *
   * @param path String
   * @return List
   */
  List<Double> getDoubleList(final String path);

  /**
   * Get boolean list from path.
   *
   * @param path String
   * @return List
   */
  List<Boolean> getBooleanList(final String path);

  /**
   * Get String set from path.
   *
   * @param path String
   * @return Set
   */
  Set<String> getKeys(final String path);

  /**
   * Returns Map with contains all type of replaces.
   *
   * @return ReplaceRegistry
   */
  ReplaceRegistry getReplaceRegistry();

  /**
   * Returns the configuration file.
   *
   * @return File
   */
  File getFile();

  /**
   * Get the type of the configuration.
   *
   * @return ConfigurationType
   */
  ConfigurationType getType();

}
