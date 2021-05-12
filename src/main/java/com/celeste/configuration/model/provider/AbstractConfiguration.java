package com.celeste.configuration.model.provider;

import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.exception.FailedGetException;
import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.exception.FailedSaveException;
import com.celeste.configuration.model.registry.ReplaceRegistry;
import com.celeste.configuration.model.registry.ReplaceRegistry.ReplaceValue;
import com.celeste.configuration.model.registry.type.ReplaceType;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
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
 * @param <U> A factory that extends TokenStreamFactory, used to instantiate Mappers
 */
@Getter
public abstract class AbstractConfiguration<U extends TokenStreamFactory> implements Configuration {

  private final U factory;
  private final ObjectMapper mapper;

  private final File file;
  private final ReplaceRegistry replace;

  private LinkedHashMap<?, ?> configuration;

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
    this.replace = new ReplaceRegistry();

    if (!file.exists() || replace) {
      try (final InputStream input = getResource(resource)) {
        copy(input, file);
      } catch (IOException exception) {
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
      this.configuration = mapper.readValue(reader, LinkedHashMap.class);
    } catch (Throwable throwable) {
      throw new FailedLoadException(throwable);
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
    } catch (Throwable throwable) {
      throw new FailedSaveException(throwable);
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
   * @param object Object
   */
  @Override
  @SuppressWarnings("unchecked")
  public void set(final String path, @Nullable final Object object) {
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

        result.put(lastPath, replace(object, ReplaceType.SET));
        return;
      }

      result = (Map<Object, Object>) result.get(key);
    }
  }

  /**
   * Gets the value from path in the configuration.
   *
   * @param path String
   * @param <T> Object
   * @return Object
   */
  @Override
  @SuppressWarnings("unchecked")
  public <T> T get(final String path) {
    final Object result = getResult(path);

    if (result == null) {
      throw new FailedGetException("The path " + path + " was not found");
    }

    return (T) result;
  }

  /**
   * Returns a generic value from that path.
   *
   * @param path String
   * @param orElse T
   * @param <T> T
   * @return T
   */
  @Override
  @SuppressWarnings("unchecked")
  public <T> T get(final String path, @Nullable final T orElse) {
    final Object result = getResult(path);
    return result == null ? orElse : (T) result;
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
    return get(path);
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
    return get(path, orElse);
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
   * Returns Map with contains all type of replaces.
   *
   * @return ReplaceRegistry
   */
  @Override
  public ReplaceRegistry getReplaceRegistry() {
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
   * @param replace T
   * @param type ReplaceType
   * @param <T> Any type
   * @return T
   */
  @SuppressWarnings("unchecked")
  private <T> T replace(final T replace, final ReplaceType type) {
    if (replace instanceof String) {
      String replaced = replace.toString();

      for (Entry<String, ReplaceValue> entry : getReplaceRegistry().getEntrySet(type)) {
        replaced = replaced.replaceAll("(?i)" + entry.getKey(), entry.getValue().getValue());
      }

      return (T) replaced;
    }

    if (replace instanceof List) {
      List<?> replaced = (List<?>) replace;

      if (replaced.size() == 0 || !(replaced.get(0) instanceof String)) {
        return replace;
      }

      for (Entry<String, ReplaceValue> entry : getReplaceRegistry().getEntrySet(type)) {
        replaced = replaced.stream()
            .map(line -> line.toString()
                .replaceAll("(?i)" + entry.getKey(), entry.getValue().getValue()))
            .collect(Collectors.toList());
      }

      return (T) replaced;
    }

    return replace;
  }

  /**
   * Gets the InputStream from the path.
   *
   * @param resourcePath String
   * @return InputStream
   */
  private InputStream getResource(final String resourcePath) {
    final InputStream input = getClass().getClassLoader().getResourceAsStream(resourcePath);

    if (input == null) {
      throw new IllegalArgumentException(resourcePath + " not found");
    }

    return input;
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
    final String directories = resource.contains("/") ? resource.substring(0, lastIndex) : "";

    final File file = new File(path, directories);
    if (!file.exists() && !file.mkdirs()) {
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
    } catch (Throwable exception) {
      throw new FailedCreateException(exception);
    }
  }

  /**
   * Return a TokenStreamFactory.
   *
   * @return TokenStreamFactory
   */
  protected abstract U getFactory();

  /**
   * Return a ObjectMapper.
   *
   * @return ObjectMapper
   */
  protected abstract ObjectMapper getMapper();

}
