package com.cefoler.configuration.model.provider;

import com.cefoler.configuration.model.entity.ReplaceValue;
import com.cefoler.configuration.model.entity.type.ReplaceType;
import com.cefoler.configuration.model.lambda.supplier.ThrowSupplier;
import com.cefoler.configuration.model.map.ReplaceMap;
import com.cefoler.configuration.model.provider.exception.checked.impl.FailedCreateException;
import com.cefoler.configuration.model.provider.exception.checked.impl.FailedLoadException;
import com.cefoler.configuration.model.provider.exception.unchecked.configuration.impl.FailedGetException;
import com.cefoler.configuration.model.provider.exception.unchecked.configuration.impl.FailedSaveException;
import com.cefoler.configuration.util.Objects;
import com.cefoler.configuration.util.Reflection;
import com.cefoler.configuration.util.Streams;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

@Getter
@ToString
@EqualsAndHashCode
public abstract class AbstractConfiguration implements Configuration {

  private static final long serialVersionUID = 7338146955033356675L;

  protected final File file;
  protected final ReplaceMap replace;

  protected Map<?, ?> configuration;

  @SneakyThrows
  protected AbstractConfiguration(final String path, final String resource, final boolean replace) {
    this.file = create(path, resource);
    this.replace = ReplaceMap.create();

    if (!file.exists() || replace) {
      try (final InputStream input = getResource(resource)) {
        copy(input, file);
      } catch (final IOException exception) {
        throw new FailedLoadException("Some unexpected error has occurred: ", exception);
      }
    }

    load();
  }

  @Override
  public void load() throws FailedLoadException {
    final Charset charset = StandardCharsets.UTF_8;

    try (
        final FileInputStream input = new FileInputStream(file);
        final Reader reader = new InputStreamReader(input, charset)
    ) {
      final long length = file.length();

      if (length == 0) {
        this.configuration = new LinkedHashMap<>(0);
        return;
      }

      final ObjectMapper mapper = getMapper();
      this.configuration = mapper.readValue(reader, LinkedHashMap.class);
    } catch (final IOException exception) {
      throw new FailedLoadException(exception);
    }
  }

  @Override
  public void save() {
    final Charset charset = StandardCharsets.UTF_8;

    try (
        final FileOutputStream output = new FileOutputStream(file);
        final Writer writer = new OutputStreamWriter(output, charset)
    ) {
      final ObjectMapper mapper = getMapper();

      final DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
      final ObjectWriter object = mapper.writer(printer);

      object.writeValue(writer, configuration);
    } catch (final IOException exception) {
      throw new FailedSaveException(exception);
    }
  }

  @Override
  public void saveAndLoad() throws FailedLoadException {
    save();
    load();
  }

  @Override
  public boolean contains(final String path) {
    final Object result = getResult(path);
    return result != null;
  }

  @Override
  public void set(final String path, @Nullable final Object value) {
    final String[] split = path.split("\\.");
    final int length = split.length;

    final int index = length - 1;
    final String last = split[index];

    Map<Object, Object> result = Objects.cast(configuration);

    for (@NonNls final String key : split) {
      if (!result.containsKey(key)) {
        final Map<?, ?> values = new LinkedHashMap<>(1);
        result.put(key, values);
      }

      if (key.equals(last)) {
        if (value == null) {
          result.remove(last);
          return;
        }

        result.put(last, value);
        return;
      }

      final Object sub = result.get(key);
      result = Objects.cast(sub);
    }
  }

  @Override
  public <U> U get(final String path) {
    final Object result = getResult(path);

    if (result == null) {
      throw new FailedGetException("Path " + path + " was not found");
    }

    return Objects.cast(result);
  }

  @Override
  public <U> U get(final String path, @Nullable final U orElse) {
    final Object result = getResult(path);
    return result != null ? Objects.cast(result) : orElse;
  }

  @Override
  public <U> U get(final String path, final Supplier<? extends U> orElse) {
    final Object result = getResult(path);
    return result != null ? Objects.cast(result) : orElse.get();
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
  public Number getNumber(final String path) {
    return get(path);
  }

  @Override
  public Number getNumber(final String path, @Nullable final Number orElse) {
    return get(path, orElse);
  }

  @Override
  public byte getByte(final String path) {
    final Number number = getNumber(path);
    return number.byteValue();
  }

  @Override
  public byte getByte(final String path, @Nullable final Byte orElse) {
    final Number number = getNumber(path, orElse);
    return number.byteValue();
  }

  @Override
  public short getShort(final String path) {
    final Number number = getNumber(path);
    return number.shortValue();
  }

  @Override
  public short getShort(final String path, @Nullable final Short orElse) {
    final Number number = getNumber(path, orElse);
    return number.shortValue();
  }

  @Override
  public int getInt(final String path) {
    final Number number = getNumber(path);
    return number.intValue();
  }

  @Override
  public int getInt(final String path, @Nullable final Integer orElse) {
    final Number number = getNumber(path, orElse);
    return number.intValue();
  }

  @Override
  public long getLong(final String path) {
    final Number number = getNumber(path);
    return number.longValue();
  }

  @Override
  public long getLong(final String path, @Nullable final Long orElse) {
    final Number number = getNumber(path, orElse);
    return number.longValue();
  }

  @Override
  public float getFloat(final String path) {
    final Number number = getNumber(path);
    return number.floatValue();
  }

  @Override
  public float getFloat(final String path, @Nullable final Float orElse) {
    final Number number = getNumber(path, orElse);
    return number.floatValue();
  }

  @Override
  public double getDouble(final String path) {
    final Number number = getNumber(path);
    return number.doubleValue();
  }

  @Override
  public double getDouble(final String path, @Nullable final Double orElse) {
    final Number number = getNumber(path, orElse);
    return number.doubleValue();
  }

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
    return get(path, ArrayList::new);
  }

  @Override
  public List<?> getList(final String path, @Nullable final List<?> orElse) {
    return get(path, orElse);
  }

  @Override
  public List<String> getStringList(final String path) {
    return get(path, ArrayList::new);
  }

  @Override
  public List<String> getStringList(final String path, @Nullable final List<String> orElse) {
    return get(path, orElse);
  }

  @Override
  public List<? extends Number> getNumberList(final String path) {
    return get(path, ArrayList::new);
  }

  @Override
  public List<? extends Number> getNumberList(final String path,
      @Nullable final List<? extends Number> orElse) {
    return get(path, orElse);
  }

  @Override
  public List<Byte> getByteList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::byteValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Byte> getByteList(final String path, @Nullable final List<Byte> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::byteValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Short> getShortList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::shortValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Short> getShortList(final String path, @Nullable final List<Short> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::shortValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Integer> getIntegerList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::intValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Integer> getIntegerList(final String path, @Nullable final List<Integer> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::intValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Long> getLongList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::longValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Long> getLongList(final String path, @Nullable final List<Long> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::longValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Float> getFloatList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::floatValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Float> getFloatList(final String path, @Nullable final List<Float> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::floatValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Double> getDoubleList(final String path) {
    final List<? extends Number> numbers = getNumberList(path);

    return numbers.stream()
        .map(Number::doubleValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Double> getDoubleList(final String path, @Nullable final List<Double> orElse) {
    final List<? extends Number> numbers = getNumberList(path, orElse);

    return numbers.stream()
        .map(Number::doubleValue)
        .collect(Collectors.toList());
  }

  @Override
  public List<Boolean> getBooleanList(final String path) {
    return get(path, ArrayList::new);
  }

  @Override
  public List<Boolean> getBooleanList(final String path, @Nullable final List<Boolean> orElse) {
    return get(path, orElse);
  }

  @Override
  public Set<String> getKeys() {
    final Set<?> keys = configuration.keySet();

    return keys.stream()
        .map(Object::toString)
        .collect(Collectors.toSet());
  }

  @Override
  public Set<String> getKeys(final String path) {
    Object result = configuration;

    for (final String key : path.split("\\.")) {
      if (!(result instanceof Map)) {
        throw new FailedGetException("Path " + path + " was not found");
      }

      final Map<?, ?> converted = Objects.cast(result);
      result = converted.get(key);
    }

    if (result instanceof Map) {
      final Map<?, ?> converted = Objects.cast(result);
      final Set<?> keys = converted.keySet();

      return keys.stream()
          .map(Object::toString)
          .collect(Collectors.toSet());
    }

    if (result instanceof Collection) {
      final Collection<?> converted = Objects.cast(result);

      return converted.stream()
          .map(Object::toString)
          .collect(Collectors.toSet());
    }

    if (result instanceof Object[]) {
      final Object[] converted = Objects.cast(result);

      return Streams.toStream(converted)
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
    Object result = configuration;

    for (final String key : path.split("\\.")) {
      if (!(result instanceof Map)) {
        return null;
      }

      final Map<?, ?> converted = Objects.cast(result);
      result = converted.get(key);
    }

    final ReplaceType type = ReplaceType.GET;
    return replace(result, type);
  }

  private <U> U replace(final U result, final ReplaceType type) {
    if (result instanceof CharSequence) {
      CharSequence converted = Objects.cast(result);

      for (final Entry<String, ReplaceValue> entry : replace.entrySet(type)) {
        final String key = entry.getKey();
        final ReplaceValue value = entry.getValue();

        final String replacer = value.getValue();
        final String pattern = "(?i)" + key;

        final Pattern regex = Pattern.compile(pattern);
        final Matcher matcher = regex.matcher(converted);

        converted = matcher.replaceAll(replacer);
      }

      return Objects.cast(converted);
    }

    if (result instanceof Collection) {
      final Collection<?> converted = Objects.cast(result);

      if (converted.isEmpty()) {
        return result;
      }

      final Collection<?> collection = converted.stream()
          .map(candidate -> replace(candidate, type))
          .collect(Collectors.toCollection(ThrowSupplier.convert(() ->
              Reflection.instance(result), ArrayList::new)));

      return Objects.cast(collection);
    }

    if (result instanceof Object[]) {
      final Object[] converted = Objects.cast(result);
      final int length = converted.length;

      if (length == 0) {
        return result;
      }

      final Object[] array = Streams.toStream(converted)
          .map(candidate -> replace(candidate, type))
          .toArray();

      return Objects.cast(array);
    }

    return result;
  }

  private InputStream getResource(final String resource) {
    final Class<?> clazz = getClass();

    final ClassLoader loader = clazz.getClassLoader();
    final InputStream input = loader.getResourceAsStream(resource);

    if (input == null) {
      throw new NullPointerException("Resource " + resource + " not found");
    }

    return input;
  }

  private File create(final String path, final String resource) throws FailedCreateException {
    final int index = resource.lastIndexOf('/');
    final String directory = resource.contains("/") ? resource.substring(0, index) : "";

    final File folder = new File(path, directory);

    if (!folder.exists() && !folder.mkdirs()) {
      throw new FailedCreateException("There was an error creating the file folder");
    }

    return new File(path, resource);
  }

  @SneakyThrows(UnsupportedEncodingException.class)
  private void copy(final InputStream input, final File output) throws FileNotFoundException {
    final String charset = "UTF-8";

    try (
        final Scanner scanner = new Scanner(input, charset);
        final PrintStream print = new PrintStream(output, charset)
    ) {
      while (scanner.hasNext()) {
        final String line = scanner.nextLine();
        print.println(line);
      }
    }
  }

  protected abstract JsonFactory getFactory();

  protected abstract ObjectMapper getMapper();

}
