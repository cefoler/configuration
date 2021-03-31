package com.celeste.configuration.model.provider;

import com.celeste.configuration.model.ConfigurationType;
import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.exception.FailedSaveException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("unused")
public interface Configuration {

  /**
   * Loads the configuration
   * @throws FileNotFoundException Throws when file was not found
   * @throws FailedLoadException Throws when it wasn't able to load the file
   */
  void load() throws FileNotFoundException, FailedLoadException;

  /**
   * Saves the configuration
   * @throws FailedSaveException Throws when file wasn't able to save
   */
  void save() throws FailedSaveException;

  /**
   * Saves and update the configuration
   * @throws FailedLoadException Throws when it fails to load
   * @throws FailedSaveException Throws when it fails to save
   */
  void saveAndUpdate() throws FailedSaveException, FailedLoadException;

  /**
   * Check if the value contains in the configuration
   * @param path String
   * @return boolean
   */
  boolean contains(@NotNull final String path);

  /**
   * Sets a value into the configuration
   * @param path String
   * @param object Object
   */
  void set(@NotNull final String path, @Nullable final Object object);

  /**
   * Gets the value from path in the configuration
   *
   * @param path String
   * @param <T> Object
   *
   * @return Object
   */
  @NotNull
  <T> T get(@NotNull final String path);

  /**
   * Returns a generic value from that path
   *
   * @param path String
   * @param orElseFound T
   * @param <T> T
   * @return T
   */
  @NotNull
  <T> T get(@NotNull final String path, @NotNull final T orElseFound);

  /**
   * Gets Object from path
   * @param path String
   *
   * @return Object
   */
  @NotNull
  Object getObject(@NotNull final String path);

  /**
   * Gets Object from path, if nulls return a value
   * @param path String
   * @param orElseFound String
   *
   * @return Object
   */
  @NotNull
  Object getObject(@NotNull final String path, @NotNull final String orElseFound);

  /**
   * Gets string from path
   * @param path String
   *
   * @return string
   */
  @NotNull
  String getString(@NotNull final String path);

  /**
   * Gets string from path, if nulls return a value
   * @param path String
   * @param orElseFound string
   *
   * @return string
   */
  @NotNull
  String getString(@NotNull final String path, @NotNull final String orElseFound);

  /**
   * Gets int from path
   * @param path String
   *
   * @return int
   */
  int getInt(@NotNull final String path);

  /**
   * Gets int from path, if nulls return a value
   * @param path String
   * @param orElseFound int
   *
   * @return int
   */
  int getInt(@NotNull final String path, final int orElseFound);

  /**
   * Gets long from path
   * @param path String
   *
   * @return long
   */
  long getLong(@NotNull final String path);

  /**
   * Gets long from path, if nulls return a value
   * @param path String
   * @param orElseFound long
   *
   * @return long
   */
  long getLong(@NotNull final String path, final long orElseFound);

  /**
   * Gets double from path
   * @param path String
   *
   * @return double
   */
  double getDouble(@NotNull final String path);

  /**
   * Gets double from path, if nulls return a value
   * @param path String
   * @param orElseFound double
   *
   * @return double
   */
  double getDouble(@NotNull final String path, final double orElseFound);

  /**
   * Gets boolean from path
   * @param path String
   *
   * @return boolean
   */
  boolean getBoolean(@NotNull final String path);

  /**
   * Gets boolean from path, if nulls return a value
   * @param path String
   * @param orElseFound boolean
   *
   * @return boolean
   */
  boolean getBoolean(@NotNull final String path, final boolean orElseFound);

  /**
   * Get list from path
   * @param path String
   * @return List
   */
  @NotNull
  List<?> getList(@NotNull final String path);

  /**
   * Get list from path, if nulls return a value
   * @param path String
   * @param orElseFound List
   *
   * @return List
   */
  @NotNull
  List<?> getList(@NotNull final String path, @NotNull final List<?> orElseFound);

  /**
   * Get string list from path
   * @param path String
   * @return List
   */
  @NotNull
  List<String> getStringList(@NotNull final String path);

  /**
   * Get integer list from path
   * @param path String
   * @return List
   */
  @NotNull
  List<Integer> getIntegerList(@NotNull final String path);

  /**
   * Get long list from path
   * @param path String
   * @return List
   */
  @NotNull
  List<Long> getLongList(@NotNull final String path);

  /**
   * Get double list from path
   * @param path String
   * @return List
   */
  @NotNull
  List<Double> getDoubleList(@NotNull final String path);

  /**
   * Get boolean list from path
   * @param path String
   * @return List
   */
  @NotNull
  List<Boolean> getBooleanList(@NotNull final String path);

  /**
   *
   * @param path String
   * @return Set
   */
  @NotNull
  Set<String> getKeys(@NotNull final String path);

  /**
   * Returns the configuration file
   * @return File
   */
  @NotNull
  File getFile();

  /**
   * Get the type of the configuration
   * @return ConfigurationType
   */
  @NotNull
  ConfigurationType getType();

  /**
   * Gets the InputStream from the path
   * @param resourcePath String
   *
   * @return InputStream
   */
  @NotNull
  default InputStream getResource(@NotNull final String resourcePath) {
    final InputStream input = getClass().getClassLoader().getResourceAsStream(resourcePath);

    if (input == null) {
      throw new IllegalArgumentException(resourcePath + " not found");
    }

    return input;
  }

  /**
   * Creates the configuration file
   * @param path String
   * @param resourcePath String
   *
   * @return File
   */
  @SuppressWarnings("all")
  default File create(final String path, final String resourcePath) {
    final String directories = resourcePath.contains("/")
        ? resourcePath.substring(0, resourcePath.lastIndexOf("/"))
        : "";

    final File file = new File(path, directories);
    if (!file.exists()) {
      file.mkdirs();
    }

    return new File(path, resourcePath);
  }

  /**
   * Copies a configuration
   * @param input InputStream
   * @param output File
   *
   * @throws FailedCreateException Throws when it fails to create the new configuration
   */
  default void copy(@NotNull final InputStream input, @NotNull final File output) throws FailedCreateException {
    try (
        final Scanner scanner = new Scanner(input);
        final PrintStream print = new PrintStream(output)
    ) {
      while (scanner.hasNext()) {
        print.println(scanner.nextLine());
      }
    } catch (Throwable exception) {
      throw new FailedCreateException(exception);
    }
  }

}
