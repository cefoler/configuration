package com.celeste.configuration.model.provider;

import com.celeste.configuration.model.entity.ReplaceValue;
import com.celeste.configuration.model.entity.type.ReplaceType;
import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.exception.FailedGetException;
import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.exception.FailedSaveException;
import com.celeste.configuration.model.map.ReplaceMap;
import com.celeste.configuration.util.Validation;
import com.celeste.configuration.util.Wrapper;
import com.celeste.configuration.util.pattern.CollectorPattern;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

/**
 * Abstract class that will do all the functions of get, set and save regardless
 * of the type of Abstraction.
 *
 * @param <T> A factory that extends TokenStreamFactory, used to instantiate Mappers
 */
@Getter
public abstract class AbstractConfiguration<T extends TokenStreamFactory> implements Configuration,
    Serializable {

  protected final T factory;
  protected final ObjectMapper mapper;

  protected final File file;
  protected final ReplaceMap replace;

  protected LinkedHashMap<?, ?> configuration;

  /**
   * Creates a new YamlProvider.
   *
   * @param path String
   * @param resource String
   * @param replace boolean
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   * @throws FailedLoadException Throws when it wasn't possible to load the configuration
   */
  public AbstractConfiguration(final String path, final String resource, final boolean replace)
      throws FailedCreateException, FailedLoadException {
    this.factory = getFactory();
    this.mapper = getMapper();

    this.file = create(path, resource);
    this.replace = new ReplaceMap();

    if (!file.exists() || replace) {
      try (final InputStream input = getResource(resource)) {
        copy(input, file);
      } catch (Exception exception) {
        throw new FailedLoadException("Some unexpected error has occurred: ", exception);
      }
    }

    load();
  }

  /**
   * Loads the configuration.
   *
   * @throws FailedLoadException Throws when it fails to load the configuration
   */
  @Override
  public void load() throws FailedLoadException {
    try (
        final FileInputStream input = new FileInputStream(file);
        final Reader reader = new InputStreamReader(input, Charset.defaultCharset())
    ) {
      if (file.length() == 0) {
        this.configuration = new LinkedHashMap<>();
        return;
      }

      this.configuration = mapper.readValue(reader, LinkedHashMap.class);
    } catch (Exception exception) {
      throw new FailedLoadException(exception);
    }
  }

  /**
   * Saves the configuration.
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
    } catch (Exception exception) {
      throw new FailedSaveException(exception);
    }
  }

  /**
   * Saves and update the configuration.
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
   * Check if the value contains in the configuration.
   *
   * @param path String
   * @return boolean
   */
  @Override
  public boolean contains(final String path) {
    return getResult(path) != null;
  }

  /**
   * Sets a value into the configuration.
   *
   * @param path String
   * @param value Object
   */
  @Override
  @SuppressWarnings("unchecked")
  public void set(final String path, @Nullable final Object value) {
    final String[] split = path.split("\\.");
    final String lastPath = split[split.length - 1];

    Map<Object, Object> result = (Map<Object, Object>) configuration;

    for (final String key : split) {
      if (!result.containsKey(key)) {
        final Map<?, ?> newPath = new LinkedHashMap<>();
        result.put(key, newPath);
      }

      if (key.equals(lastPath)) {
        if (value == null) {
          result.remove(lastPath);
          return;
        }

        final Object replaced = replace(value, ReplaceType.SET);
        result.put(lastPath, replaced);
        return;
      }

      result = (Map<Object, Object>) result.get(key);
    }
  }

  /**
   * Gets the value from path in the configuration.
   *
   * @param path String
   * @param <U> Object
   * @return Object
   */
  @Override
  @SuppressWarnings("unchecked")
  public <U> U get(final String path) {
    final Object result = getResult(path);

    return (U) Validation.notNull(result, () -> new FailedGetException("Path " + path
        + " was not found"));
  }

  /**
   * Returns a generic value from that path.
   *
   * @param path String
   * @param orElse T
   * @param <U> T
   * @return T
   */
  @Override
  @SuppressWarnings("unchecked")
  public <U> U get(final String path, @Nullable final U orElse) {
    final Object result = getResult(path);
    return result == null ? orElse : (U) result;
  }

  /**
   * Gets Object from path.
   *
   * @param path String
   * @return Object
   */
  @Override
  public Object getObject(final String path) {
    return get(path);
  }

  /**
   * Gets Object from path, if nulls return a value.
   *
   * @param path String
   * @param orElse String
   * @return Object
   */
  @Override
  public Object getObject(final String path, @Nullable final Object orElse) {
    return get(path, orElse);
  }

  /**
   * Gets string from path.
   *
   * @param path String
   * @return string
   */
  @Override
  public String getString(final String path) {
    return get(path);
  }

  /**
   * Gets string from path, if nulls return a value.
   *
   * @param path String
   * @param orElse string
   * @return string
   */
  @Override
  public String getString(final String path, @Nullable final String orElse) {
    return get(path, orElse);
  }

  /**
   * Gets int from path.
   *
   * @param path String
   * @return int
   */
  @Override
  public int getInt(final String path) {
    return get(path);
  }

  /**
   * Gets int from path, if nulls return a value.
   *
   * @param path String
   * @param orElse int
   * @return int
   */
  @Override
  public int getInt(final String path, @Nullable final Integer orElse) {
    return get(path, orElse);
  }

  /**
   * Gets long from path.
   *
   * @param path String
   * @return long
   */
  @Override
  public long getLong(final String path) {
    final Number number = get(path);
    return number.longValue();
  }

  /**
   * Gets long from path, if nulls return a value.
   *
   * @param path String
   * @param orElse long
   * @return long
   */
  @Override
  public long getLong(final String path, @Nullable final Long orElse) {
    final Number number = get(path, orElse);
    return number.longValue();
  }

  /**
   * Gets double from path.
   *
   * @param path String
   * @return double
   */
  @Override
  public double getDouble(final String path) {
    return get(path);
  }

  /**
   * Gets double from path, if nulls return a value.
   *
   * @param path String
   * @param orElse double
   * @return double
   */
  @Override
  public double getDouble(final String path, @Nullable final Double orElse) {
    return get(path, orElse);
  }

  /**
   * Gets boolean from path.
   *
   * @param path String
   * @return boolean
   */
  @Override
  public boolean getBoolean(final String path) {
    return get(path);
  }

  /**
   * Gets boolean from path, if nulls return a value.
   *
   * @param path String
   * @param orElse boolean
   * @return boolean
   */
  @Override
  public boolean getBoolean(final String path, @Nullable final Boolean orElse) {
    return get(path, orElse);
  }

  /**
   * Get list from path.
   *
   * @param path String
   * @return List
   */
  @Override
  public List<?> getList(final String path) {
    return get(path);
  }

  /**
   * Get list from path.
   *
   * @param path String
   * @return List
   */
  @Override
  public List<?> getList(final String path, @Nullable final List<?> orElse) {
    return get(path, orElse);
  }

  /**
   * Get string list from path.
   *
   * @param path String
   * @return List
   */
  @Override
  public List<String> getStringList(final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get integer list from path.
   *
   * @param path String
   * @return List
   */
  @Override
  public List<Integer> getIntegerList(final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get long list from path.
   *
   * @param path String
   * @return List
   */
  @Override
  public List<Long> getLongList(final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get double list from path.
   *
   * @param path String
   * @return List
   */
  @Override
  public List<Double> getDoubleList(final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get boolean list from path.
   *
   * @param path String
   * @return List
   */
  @Override
  public List<Boolean> getBooleanList(final String path) {
    return get(path, new ArrayList<>());
  }

  /**
   * Get String set from path.
   *
   * @param path String
   * @return Set
   */
  @Override
  public Set<String> getKeys(final String path) {
    Object result = configuration.clone();

    if (!path.equals("")) {
      for (final String key : path.split("\\.")) {
        if (!(result instanceof Map)) {
          throw new FailedGetException("Path " + path + " was not found");
        }

        result = ((Map<?, ?>) result).get(key);
      }
    }

    if (result instanceof List) {
      return new LinkedHashSet<>();
    }

    if (result instanceof Map) {
      return ((Map<?, ?>) result).keySet().stream()
          .map(Object::toString)
          .collect(Collectors.toSet());
    }

    throw new FailedGetException("Path " + path + " was not found");
  }

  /**
   * Returns Map with contains all type of replaces.
   *
   * @return ReplaceRegistry
   */
  @Override
  public ReplaceMap getReplacer() {
    return replace;
  }

  /**
   * Gets the result from the path.
   *
   * @param path String
   * @return Object
   */
  @Nullable
  private Object getResult(final String path) {
    Object result = configuration.clone();

    for (final String key : path.split("\\.")) {
      if (!(result instanceof Map)) {
        return null;
      }

      result = ((Map<?, ?>) result).get(key);
    }

    return replace(result, ReplaceType.GET);
  }

  /**
   * Get the result already replaced.
   *
   * @param object T
   * @param type ReplaceType
   * @param <U> Any type
   * @return T
   */
  @SuppressWarnings("unchecked")
  private <U> U replace(final U object, final ReplaceType type) {
    if (object instanceof String) {
      String replaced = Wrapper.toString(object);

      for (final Entry<String, ReplaceValue> entry : replace.entrySet(type)) {
        final String key = entry.getKey();
        final ReplaceValue value = entry.getValue();

        replaced = replaced.replaceAll("(?i)" + key, value.getValue());
      }

      return (U) replaced;
    }

    if (object instanceof List) {
      List<?> replaced = (List<?>) object;

      if (replaced.size() == 0 || !(replaced.get(0) instanceof String)) {
        return object;
      }

      for (final Entry<String, ReplaceValue> entry : replace.entrySet(type)) {
        replaced = replaced.stream()
            .map(line -> {
              final String key = entry.getKey();
              final ReplaceValue value = entry.getValue();

              return Wrapper.toString(line).replaceAll("(?i)" + key, value.getValue());
            })
            .collect(CollectorPattern.toList());
      }

      return (U) replaced;
    }

    return object;
  }

  /**
   * Gets the InputStream from the path.
   *
   * @param resource String
   * @return InputStream
   */
  private InputStream getResource(final String resource) {
    final InputStream input = getClass().getClassLoader().getResourceAsStream(resource);

    return Validation.notNull(input, "Resource " + resource + " not found");
  }

  /**
   * Creates the configuration file.
   *
   * @param path String
   * @param resource String
   * @return File
   */
  private File create(final String path, final String resource) throws FailedCreateException {
    final int lastIndex = resource.lastIndexOf("/");
    final String directory = resource.contains("/") ? resource.substring(0, lastIndex) : "";

    final File folder = new File(path, directory);

    if (!folder.exists() && !folder.mkdirs()) {
      throw new FailedCreateException("There was an error creating the file folder");
    }

    return new File(path, resource);
  }

  /**
   * Copy a configuration.
   *
   * @param input InputStream
   * @param output File
   * @throws FailedCreateException Throws when it fails to create the new configuration
   */
  private void copy(final InputStream input, final File output) throws FailedCreateException {
    try (
        final Scanner scanner = new Scanner(input);
        final PrintStream print = new PrintStream(output)
    ) {
      while (scanner.hasNext()) {
        print.println(scanner.nextLine());
      }
    } catch (Exception exception) {
      throw new FailedCreateException(exception);
    }
  }

  /**
   * Return a TokenStreamFactory.
   *
   * @return TokenStreamFactory
   */
  protected abstract T getFactory();

  /**
   * Return a ObjectMapper.
   *
   * @return ObjectMapper
   */
  protected abstract ObjectMapper getMapper();

}
