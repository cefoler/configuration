package com.celeste.configuration.model.provider;

import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.exception.FailedGetException;
import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.exception.FailedSaveException;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public abstract class AbstractConfiguration<T extends TokenStreamFactory> implements Configuration {

  private final T factory;
  private final ObjectMapper mapper;

  private final File file;

  private LinkedHashMap<?, ?> configuration;

  /**
   * Creates a new YamlProvider
   *
   * @param path String
   * @param resourcePath String
   * @param replace boolean
   *
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   * @throws FailedLoadException Throws when it wasn't possible to load the configuration
   */
  public AbstractConfiguration(@NotNull final String path, @NotNull final String resourcePath, final boolean replace)
      throws FailedCreateException, FailedLoadException {
    this.factory = getFactory();
    this.mapper = getMapper();
    this.file = create(path, resourcePath);

    if (!file.exists() || replace) {
      try (final InputStream resource = getResource(resourcePath)) {
        copy(resource, file);
      } catch (IOException exception) {
        throw new FailedLoadException("Some unexpected error has occurred: ", exception);
      }
    }

    load();
  }

  /**
   * Loads the configuration
   *
   * @throws FailedLoadException Throws when it fails to load the configuration
   */
  @Override
  public void load() throws FailedLoadException {
    try (
        final FileInputStream input = new FileInputStream(file);
        final Reader reader = new InputStreamReader(input, Charset.defaultCharset())
    ) {
      this.configuration = mapper.readValue(reader, LinkedHashMap.class);
    } catch (Throwable throwable) {
      throw new FailedLoadException(throwable);
    }
  }

  /**
   * Saves the configuration
   *
   * @throws FailedSaveException Throws when it wasn't possible to save the configuration
   */
  @Override
  public void save() throws FailedSaveException {
    try (
        final FileOutputStream output = new FileOutputStream(file);
        final Writer writer = new OutputStreamWriter(output, Charset.defaultCharset())
    ) {
      final DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
      mapper.writer(printer).writeValue(writer, configuration);
    } catch (Throwable throwable) {
      throw new FailedSaveException(throwable);
    }
  }

  /**
   * Saves and update the configuration
   *
   * @throws FailedLoadException Throws when it fails to load
   * @throws FailedSaveException Throws when it fails to save
   */
  @Override
  public void saveAndLoad() throws FailedLoadException, FailedSaveException {
    save();
    load();
  }

  /**
   * Check if the value contains in the configuration
   *
   * @param path String
   * @return boolean
   */
  @Override
  public boolean contains(@NotNull final String path) {
    return getResult(path) != null;
  }

  /**
   * Sets a value into the configuration
   *
   * @param path String
   * @param object Object
   */
  @Override @SuppressWarnings("unchecked")
  public void set(@NotNull final String path, @Nullable final Object object) {
    final String[] split = path.split("\\.");
    final String lastPath = split[split.length - 1];

    Map<Object, Object> result = (Map<Object, Object>) configuration;

    for (final String key : split) {
      if (!result.containsKey(key)) {
        result.put(key, new LinkedHashMap<>());
      }

      if (result.containsKey(lastPath)) {
        if (object == null) {
          result.remove(lastPath);
          return;
        }

        result.put(lastPath, object);
        return;
      }

      result = (Map<Object, Object>) result.get(key);
    }
  }

  /**
   * Gets the value from path in the configuration
   *
   * @param path String
   * @param <T> Object
   * @return Object
   */
  @Override @NotNull @SuppressWarnings("unchecked")
  public <T> T get(@NotNull final String path) {
    final Object result = getResult(path);

    if (result == null) {
      throw new FailedGetException("The path " + path + " was not found");
    }

    return (T) result;
  }

  /**
   * Returns a generic value from that path
   *
   * @param path String
   * @param orElse T
   * @param <T> T
   * @return T
   */
  @Override @NotNull @SuppressWarnings("unchecked")
  public <T> T get(@NotNull final String path, @NotNull final T orElse) {
    final Object result = getResult(path);
    return result == null ? orElse : (T) result;
  }

  /**
   * Gets Object from path
   *
   * @param path String
   * @return Object
   */
  @Override @NotNull
  public Object getObject(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets Object from path, if nulls return a value
   *
   * @param path String
   * @param orElse String
   * @return Object
   */
  @Override @NotNull
  public Object getObject(@NotNull final String path, @NotNull final String orElse) {
    return get(path, orElse);
  }

  /**
   * Gets string from path
   *
   * @param path String
   * @return string
   */
  @Override @NotNull
  public String getString(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets string from path, if nulls return a value
   *
   * @param path String
   * @param orElse string
   * @return string
   */
  @Override @NotNull
  public String getString(@NotNull final String path, @NotNull final String orElse) {
    return get(path, orElse);
  }

  /**
   * Gets int from path
   *
   * @param path String
   * @return int
   */
  @Override
  public int getInt(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets int from path, if nulls return a value
   *
   * @param path String
   * @param orElse int
   * @return int
   */
  @Override
  public int getInt(@NotNull final String path, final int orElse) {
    return get(path, orElse);
  }

  /**
   * Gets long from path
   *
   * @param path String
   * @return long
   */
  @Override
  public long getLong(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets long from path, if nulls return a value
   *
   * @param path String
   * @param orElse long
   * @return long
   */
  @Override
  public long getLong(@NotNull final String path, final long orElse) {
    return get(path, orElse);
  }

  /**
   * Gets double from path
   *
   * @param path String
   * @return double
   */
  @Override
  public double getDouble(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets double from path, if nulls return a value
   *
   * @param path String
   * @param orElse double
   * @return double
   */
  @Override
  public double getDouble(@NotNull final String path, final double orElse) {
    return get(path, orElse);
  }

  /**
   * Gets boolean from path
   *
   * @param path String
   * @return boolean
   */
  @Override
  public boolean getBoolean(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets boolean from path, if nulls return a value
   *
   * @param path String
   * @param orElse boolean
   * @return boolean
   */
  @Override
  public boolean getBoolean(@NotNull final String path, final boolean orElse) {
    return get(path, orElse);
  }

  /**
   * Get list from path
   *
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<?> getList(@NotNull final String path) {
    return get(path);
  }

  /**
   * Get list from path
   *
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<?> getList(@NotNull final String path, @NotNull final List<?> orElse) {
    return get(path, orElse);
  }

  /**
   * Get string list from path
   *
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<String> getStringList(@NotNull final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get integer list from path
   *
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<Integer> getIntegerList(@NotNull final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get long list from path
   *
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<Long> getLongList(@NotNull final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get double list from path
   *
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<Double> getDoubleList(@NotNull final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get boolean list from path
   *
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<Boolean> getBooleanList(@NotNull final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get String set from path
   *
   * @param path String
   * @return Set
   */
  @Override @NotNull
  public Set<String> getKeys(@NotNull final String path) {
    Object result = configuration.clone();

    if (!path.equals("")) {
      for (final String key : path.split("\\.")) {
        if (!(result instanceof Map)) {
          throw new FailedGetException("The path " + path + " was not found");
        }

        result = ((Map<?, ?>) result).get(key);
      }
    }

    if (!(result instanceof Map)) {
      throw new FailedGetException("The path " + path + " was not found");
    }

    return ((Map<?, ?>) result).keySet().stream()
        .map(Object::toString)
        .collect(Collectors.toSet());
  }

  /**
   * Gets the result from the path
   *
   * @param path String
   * @return Object
   */
  @Nullable
  private Object getResult(@NotNull final String path) {
    Object result = configuration.clone();

    for (final String key : path.split("\\.")) {
      if (!(result instanceof Map)) {
        return null;
      }

      result = ((Map<?, ?>) result).get(key);
    }

    return result;
  }

  /**
   * Gets the InputStream from the path
   *
   * @param resourcePath String
   * @return InputStream
   */
  @NotNull
  private InputStream getResource(@NotNull final String resourcePath) {
    final InputStream input = getClass().getClassLoader().getResourceAsStream(resourcePath);

    if (input == null) {
      throw new IllegalArgumentException(resourcePath + " not found");
    }

    return input;
  }

  /**
   * Creates the configuration file
   *
   * @param path String
   * @param resourcePath String
   * @return File
   */
  @NotNull
  private File create(@NotNull final String path, @NotNull final String resourcePath) throws FailedCreateException {
    final int lastIndex = resourcePath.lastIndexOf("/");
    final String directories = resourcePath.contains("/")
        ? resourcePath.substring(0, lastIndex)
        : "";

    final File file = new File(path, directories);
    if (!file.exists() && !file.mkdirs()) {
      throw new FailedCreateException("There was an error creating the file folder");
    }

    return new File(path, resourcePath);
  }

  /**
   * Copy a configuration
   *
   * @param input InputStream
   * @param output File
   *
   * @throws FailedCreateException Throws when it fails to create the new configuration
   */
  private void copy(@NotNull final InputStream input, @NotNull final File output) throws FailedCreateException {
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

  /**
   * Return a TokenStreamFactory
   *
   * @return TokenStreamFactory
   */
  @NotNull
  protected abstract T getFactory();

  /**
   * Return a ObjectMapper
   *
   * @return ObjectMapper
   */
  @NotNull
  protected abstract ObjectMapper getMapper();

}
