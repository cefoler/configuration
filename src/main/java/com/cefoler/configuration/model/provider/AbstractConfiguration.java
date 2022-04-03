package com.cefoler.configuration.model.provider;

import com.cefoler.configuration.model.provider.exception.checked.impl.FailedCreateException;
import com.cefoler.configuration.model.provider.exception.checked.impl.FailedLoadException;
import com.cefoler.configuration.model.map.ReplaceMap;
import com.cefoler.configuration.model.entity.ReplaceValue;
import com.cefoler.configuration.model.entity.type.ReplaceType;
import com.cefoler.configuration.model.provider.exception.unchecked.configuration.impl.FailedSaveException;
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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@Getter
@ToString
@EqualsAndHashCode
public abstract class AbstractConfiguration<T extends TokenStreamFactory> implements Configuration {

  private static final long serialVersionUID = 7338146955033356675L;

  protected final T factory;
  protected final ObjectMapper mapper;

  protected final File file;
  protected final ReplaceMap replace;

  protected LinkedHashMap<?, ?> configuration;

  @SneakyThrows
  protected AbstractConfiguration(final String path, final String resource, final boolean replace) {
    this.factory = getFactory();
    this.mapper = getMapper();

    this.file = create(path, resource);
    this.replace = ReplaceMap.create();

    if (!file.exists() || replace) {
      try (final InputStream input = getResource(resource)) {
        copy(input, file);
      } catch (Exception exception) {
        throw new FailedLoadException("Some unexpected error has occurred: ", exception);
      }
    }

    load();
  }

  @Override
  public void load() {
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

  @Override
  public void save() {
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

  @Override
  public void saveAndLoad() {
    save();
    load();
  }

  @Override
  public boolean contains(final String path) {
    return getResult(path) != null;
  }

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

  @Override
  public <U> U get(final String path) {
    final Object result = getResult(path);

    return (U) Validation.notNull(result, () -> new FailedGetException("Path " + path
        + " was not found"));
  }

  @Override
  public <U> U get(final String path, @Nullable final U orElse) {
    final Object result = getResult(path);
    return result == null ? orElse : (U) result;
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
  public int getInt(final String path) {
    return get(path);
  }

  @Override
  public int getInt(final String path, @Nullable final Integer orElse) {
    return get(path, orElse);
  }

  @Override
  public long getLong(final String path) {
    final Number number = get(path);
    return number.longValue();
  }

  @Override
  public long getLong(final String path, @Nullable final Long orElse) {
    final Number number = get(path, orElse);
    return number.longValue();
  }

  @Override
  public double getDouble(final String path) {
    return get(path);
  }

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

  @Override
  public boolean getBoolean(final String path, @Nullable final Boolean orElse) {
    return get(path, orElse);
  }

  @Override
  public List<?> getList(final String path) {
    return get(path);
  }

  @Override
  public List<?> getList(final String path, @Nullable final List<?> orElse) {
    return get(path, orElse);
  }

  @Override
  public List<String> getStringList(final String path) {
    return get(path, new ArrayList<>());
  }

  @Override
  public List<String> getStringList(final String path, final @Nullable List<String> orElse) {
    return null;
  }

  @Override
  public List<Integer> getIntegerList(final String path) {
    return get(path, new ArrayList<>());
  }

  @Override
  public List<Integer> getIntegerList(final String path, final @Nullable List<Integer> orElse) {
    return null;
  }

  @Override
  public List<Long> getLongList(final String path) {
    return get(path, new ArrayList<>());
  }

  @Override
  public List<Long> getLongList(final String path, final @Nullable List<Long> orElse) {
    return null;
  }

  @Override
  public List<Double> getDoubleList(final String path) {
    return get(path, new ArrayList<>());
  }

  @Override
  public List<Double> getDoubleList(final String path, final @Nullable List<Double> orElse) {
    return null;
  }

  @Override
  public List<Boolean> getBooleanList(final String path) {
    return get(path, new ArrayList<>());
  }

  @Override
  public List<Boolean> getBooleanList(final String path, final @Nullable List<Boolean> orElse) {
    return null;
  }

  @Override
  public Set<String> getKeys() {
    return null;
  }

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

  @Override
  public ReplaceMap getReplacer() {
    return replace;
  }

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

  private InputStream getResource(final String resource) {
    final InputStream input = getClass().getClassLoader().getResourceAsStream(resource);

    return Validation.notNull(input, "Resource " + resource + " not found");
  }

  private File create(final String path, final String resource) throws FailedCreateException {
    final int lastIndex = resource.lastIndexOf("/");
    final String directory = resource.contains("/") ? resource.substring(0, lastIndex) : "";

    final File folder = new File(path, directory);

    if (!folder.exists() && !folder.mkdirs()) {
      throw new FailedCreateException("There was an error creating the file folder");
    }

    return new File(path, resource);
  }

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

  protected abstract T getFactory();

  protected abstract ObjectMapper getMapper();

}
