package com.cefoler.configuration.model.provider.impl.configuration;

import com.cefoler.configuration.core.exception.unchecked.file.impl.impl.FileNotPermissionException;
import com.cefoler.configuration.core.exception.unchecked.serialize.impl.FailedToSerializeException;
import com.cefoler.configuration.model.provider.AbstractModule;
import com.cefoler.configuration.model.provider.Module;
import com.cefoler.configuration.model.provider.impl.module.SubModule;
import com.cefoler.configuration.core.util.Objects;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.ImmutableMap;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractConfiguration extends AbstractModule implements Configuration {

  private static final long serialVersionUID = 7338146955033356675L;

  protected final File file;

  protected AbstractConfiguration(final String path, final String resource, final boolean replace)
      throws FileNotFoundException {
    this.file = create(path, resource);

    if (!file.exists() || replace) {
      try (final InputStream input = getResource(resource)) {
        copy(input, file);
      } catch (final FileNotFoundException exception) {
        throw exception;
      } catch (final IOException exception) {
        exception.printStackTrace();
      }
    }

    load();
  }

  protected AbstractConfiguration(final File file) throws FileNotFoundException {
    this.file = file;

    load();
  }

  @Override
  public void load() throws FileNotFoundException {
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
    } catch (final FileNotFoundException exception) {
      throw exception;
    } catch (final StreamReadException | DatabindException exception) {
      final String path = file.getAbsolutePath();
      throw new FailedToSerializeException("Failed to get data from: " + path, exception);
    } catch (final IOException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void save() throws FileNotFoundException {
    final Charset charset = StandardCharsets.UTF_8;

    try (
        final FileOutputStream output = new FileOutputStream(file);
        final Writer writer = new OutputStreamWriter(output, charset)
    ) {
      final ObjectMapper mapper = getMapper();

      final DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
      final ObjectWriter object = mapper.writer(printer);

      object.writeValue(writer, configuration);
    } catch (final FileNotFoundException exception) {
      throw exception;
    } catch (final StreamWriteException | DatabindException exception) {
      final String path = file.getAbsolutePath();
      throw new FailedToSerializeException("Failed to save data to: " + path, exception);
    } catch (final IOException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void saveAndLoad() throws FileNotFoundException {
    save();
    load();
  }

  @Override
  public void set(final String path, @Nullable final Object value) {
    final String[] split = path.split("\\.");
    final int length = split.length;

    final int index = length - 1;
    final String last = split[index];

    Map<Object, Object> values = Objects.cast(configuration);

    for (@NonNls final String key : split) {
      if (!values.containsKey(key)) {
        final Map<?, ?> newValues = new LinkedHashMap<>(1);
        values.put(key, newValues);
      }

      if (key.equals(last)) {
        if (value == null) {
          values.remove(last);
          return;
        }

        if (value instanceof Module) {
          final Configuration converted = Objects.cast(value);
          final Map<?, ?> configuration = converted.getConfiguration();

          final Map<?, ?> newValue = new LinkedHashMap<>(configuration);
          values.put(last, newValue);

          return;
        }

        values.put(last, value);
        return;
      }

      final Object sub = values.get(key);
      values = Objects.cast(sub);
    }
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

  private File create(final String path, final String resource) {
    final int index = resource.lastIndexOf('/');
    final String directory = resource.contains("/") ? resource.substring(0, index) : "";

    final File folder = new File(path, directory);

    if (!folder.exists() && !folder.mkdirs()) {
      throw new FileNotPermissionException("There was an error creating the file folder");
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

  @Override
  protected Map<Predicate<Object>, Function<Object, Object>> loadConverters() {
    return ImmutableMap.of(value -> {
      if (value instanceof Collection) {
        final Collection<?> converted = Objects.cast(value);
        final Iterator<?> iterator = converted.iterator();

        return !iterator.hasNext() || !(iterator.next() instanceof Map);
      }

      return value instanceof Map;
    }, value -> {
      if (value instanceof Map) {
        final Map<?, ?> converted = Objects.cast(value);
        return SubModule.of(converted, converters, replacers);
      }

      final Collection<?> converted = Objects.cast(value);

      return converted.stream()
          .filter(Map.class::isInstance)
          .map(values -> Objects.cast(values, Map.class))
          .map(values -> SubModule.of(values, converters, replacers))
          .collect(Collectors.toList());
    });
  }

  protected abstract JsonFactory getFactory();

  protected abstract ObjectMapper getMapper();

}
