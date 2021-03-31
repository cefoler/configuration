package com.celeste.configuration.model.provider.yaml;

import com.celeste.configuration.model.ConfigurationType;
import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.exception.FailedGetException;
import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.exception.FailedSaveException;
import com.celeste.configuration.model.provider.Configuration;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

@Getter
public final class YamlProvider implements Configuration {

  private final YAMLFactory yaml;
  private final ObjectMapper mapper;

  private final File file;

  private LinkedHashMap<?, ?> config;

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
  public YamlProvider(@NotNull final String path, @NotNull final String resourcePath, final boolean replace)
      throws FailedCreateException, FailedLoadException {
    this.yaml = new YAMLFactory();
    this.mapper = new ObjectMapper(yaml);

    yaml.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);

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
   * @throws FailedLoadException Throws when it fails to load the configuration
   */
  @Override
  public void load() throws FailedLoadException {
    try (
        final FileInputStream input = new FileInputStream(file);
        final Reader reader = new InputStreamReader(input, Charset.defaultCharset())
    ) {
      this.config = mapper.readValue(reader, LinkedHashMap.class);
    } catch (Throwable throwable) {
      throw new FailedLoadException(throwable);
    }
  }

  /**
   * Saves the configuration
   * @throws FailedSaveException Throws when it wasn't possible to save the configuration
   */
  @Override
  public void save() throws FailedSaveException {
    try (
        final FileOutputStream output = new FileOutputStream(file);
        final Writer writer = new OutputStreamWriter(output, Charset.defaultCharset())
    ) {
      final DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
      mapper.writer(printer).writeValue(writer, config);
    } catch (Throwable throwable) {
      throw new FailedSaveException(throwable);
    }
  }

  /**
   * Saves and update the configuration
   * @throws FailedLoadException Throws when it fails to load
   * @throws FailedSaveException Throws when it fails to save
   */
  @Override
  public void saveAndUpdate() throws FailedLoadException, FailedSaveException {
    save();
    load();
  }

  /**
   * Check if the value contains in the configuration
   * @param path String
   * @return boolean
   */
  @Override
  public boolean contains(@NotNull final String path) {
    return getResult(path) != null;
  }

  /**
   * Sets a value into the configuration
   * @param path String
   * @param object Object
   */
  @Override @SuppressWarnings("unchecked")
  public void set(@NotNull final String path, @Nullable final Object object) {
    final String[] split = path.split("\\.");
    final String lastPath = split[split.length - 1];

    Map<Object, Object> result = (Map<Object, Object>) config;

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
   *
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
   * @param orElseFound T
   * @param <T> T
   * @return T
   */
  @Override @NotNull @SuppressWarnings("unchecked")
  public <T> T get(@NotNull final String path, @NotNull final T orElseFound) {
    final Object result = getResult(path);
    return result == null ? orElseFound : (T) result;
  }

  /**
   * Gets Object from path
   * @param path String
   *
   * @return Object
   */
  @Override @NotNull
  public Object getObject(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets Object from path, if nulls return a value
   * @param path String
   * @param orElseFound String
   *
   * @return Object
   */
  @Override @NotNull
  public Object getObject(@NotNull final String path, @NotNull final String orElseFound) {
    return get(path, orElseFound);
  }

  /**
   * Gets string from path
   * @param path String
   *
   * @return string
   */
  @Override @NotNull
  public String getString(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets string from path, if nulls return a value
   * @param path String
   * @param orElseFound string
   *
   * @return string
   */
  @Override @NotNull
  public String getString(@NotNull final String path, @NotNull final String orElseFound) {
    return get(path, orElseFound);
  }

  /**
   * Gets int from path
   * @param path String
   *
   * @return int
   */
  @Override
  public int getInt(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets int from path, if nulls return a value
   * @param path String
   * @param orElseFound int
   *
   * @return int
   */
  @Override
  public int getInt(@NotNull final String path, final int orElseFound) {
    return get(path, orElseFound);
  }

  /**
   * Gets long from path
   * @param path String
   *
   * @return long
   */
  @Override
  public long getLong(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets long from path, if nulls return a value
   * @param path String
   * @param orElseFound long
   *
   * @return long
   */
  @Override
  public long getLong(@NotNull final String path, final long orElseFound) {
    return get(path, orElseFound);
  }

  /**
   * Gets double from path
   * @param path String
   *
   * @return double
   */
  @Override
  public double getDouble(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets double from path, if nulls return a value
   * @param path String
   * @param orElseFound double
   *
   * @return double
   */
  @Override
  public double getDouble(@NotNull final String path, final double orElseFound) {
    return get(path, orElseFound);
  }

  /**
   * Gets boolean from path
   * @param path String
   *
   * @return boolean
   */
  @Override
  public boolean getBoolean(@NotNull final String path) {
    return get(path);
  }

  /**
   * Gets boolean from path, if nulls return a value
   * @param path String
   * @param orElseFound boolean
   *
   * @return boolean
   */
  @Override
  public boolean getBoolean(@NotNull final String path, final boolean orElseFound) {
    return get(path, orElseFound);
  }

  /**
   * Get list from path
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<?> getList(@NotNull final String path) {
    return get(path);
  }

  /**
   * Get list from path
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<?> getList(@NotNull final String path, @NotNull final List<?> orElseFound) {
    return get(path, orElseFound);
  }

  /**
   * Get string list from path
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<String> getStringList(@NotNull final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get integer list from path
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<Integer> getIntegerList(@NotNull final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get long list from path
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<Long> getLongList(@NotNull final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get double list from path
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<Double> getDoubleList(@NotNull final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get boolean list from path
   * @param path String
   * @return List
   */
  @Override @NotNull
  public List<Boolean> getBooleanList(@NotNull final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   *
   * @param path String
   * @return Set
   */
  @Override @NotNull
  public Set<String> getKeys(@NotNull final String path) {
    Object result = config.clone();

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
   * Get the type of the configuration
   * @return ConfigurationType
   */
  @Override @NotNull
  public ConfigurationType getType() {
    return ConfigurationType.YAML;
  }

  /**
   * Gets the result from the path
   * @param path String
   * @return Object
   */
  @Nullable
  private Object getResult(@NotNull final String path) {
    Object result = config.clone();

    for (final String key : path.split("\\.")) {
      if (!(result instanceof Map)) {
        return null;
      }

      result = ((Map<?, ?>) result).get(key);
    }

    return result;
  }

}
