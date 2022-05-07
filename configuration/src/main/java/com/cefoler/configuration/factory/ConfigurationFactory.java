package com.cefoler.configuration.factory;

import com.cefoler.configuration.core.exception.unchecked.file.impl.InvalidFileException;
import com.cefoler.configuration.core.model.lambda.function.ThrowFunction;
import com.cefoler.configuration.core.model.properties.Resources;
import com.cefoler.configuration.core.util.Streams;
import com.cefoler.configuration.model.provider.impl.configuration.Configuration;
import com.cefoler.configuration.model.provider.impl.configuration.type.ConfigurationType;
import com.google.common.collect.ImmutableSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

/**
 * Configuration factory
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public final class ConfigurationFactory {

  private static final ConfigurationFactory INSTANCE;
  private static final Pattern REGEX;

  static {
    INSTANCE = new ConfigurationFactory();
    REGEX = Pattern.compile(".*[$.](?=.+)");
  }

  public Configuration start(final Resources resources) throws FileNotFoundException {
    if (resources.contains("file")) {
      final File file = resources.find("file");
      return start(file);
    }

    final String driver = resources.find("driver", null);

    final String path = resources.find("path");
    final String resource = resources.find("resource");

    final boolean replace = resources.find("replace", false);

    if (driver == null) {
      return start(path, resource, replace);
    }

    final ConfigurationType type = ConfigurationType.getConfiguration(driver);
    return start(type, path, resource, replace);
  }

  public Configuration start(final String path, final String resource)
      throws FileNotFoundException {
    return start(path, resource, false);
  }

  public Configuration start(final String path, final String resource, final boolean replace)
      throws FileNotFoundException {
    final Matcher matcher = REGEX.matcher(resource);

    if (!matcher.find()) {
      throw new InvalidFileException("File does not have a valid extension: " + resource);
    }

    final String extension = matcher.replaceAll("");
    final ConfigurationType type = ConfigurationType.getConfiguration(extension);

    return start(type, path, resource, replace);
  }

  public Configuration start(final String driver, final String path, final String resource,
      final boolean replace) throws FileNotFoundException {
    final ConfigurationType type = ConfigurationType.getConfiguration(driver);
    return start(type, path, resource, replace);
  }

  public Configuration start(final ConfigurationType type, final String path, final String resource,
      final boolean replace) throws FileNotFoundException {
    final Matcher matcher = REGEX.matcher(resource);
    final String concat = !matcher.find() ? resource + type.getExtension() : resource;

    return type.create(path, concat, replace);
  }

  public Configuration start(final File file) throws FileNotFoundException {
    if (file.isDirectory()) {
      throw new InvalidFileException("File cannot be a directory");
    }

    final String name = file.getName();
    final Matcher matcher = REGEX.matcher(name);

    if (!matcher.find()) {
      throw new InvalidFileException("File does not have a valid extension: " + name);
    }

    final String extension = matcher.replaceAll("");
    final ConfigurationType type = ConfigurationType.getConfiguration(extension);

    return type.of(file);
  }

  @Unmodifiable
  public Set<Configuration> startByFolder(final File folder) {
    if (!folder.exists()) {
      return ImmutableSet.of();
    }

    final File[] files = folder.listFiles();
    final int length = files.length;

    if (length == 0) {
      return ImmutableSet.of();
    }

    return Streams.toStream(files)
        .map(ThrowFunction.convert(this::start))
        .collect(ImmutableSet.toImmutableSet());
  }

  @Unmodifiable
  public Set<Configuration> startByFolder(final File folder, final String... excluded) {
    if (!folder.exists()) {
      return ImmutableSet.of();
    }

    final File[] files = folder.listFiles();
    final int length = files.length;

    if (length == 0) {
      return ImmutableSet.of();
    }

    return Streams.toStream(files)
        .filter(file -> Streams.toStream(excluded)
            .map(Pattern.compile("(?i)\\b" + file.getName() + "\\b")::matcher)
            .anyMatch(Matcher::find))
        .map(ThrowFunction.convert(this::start))
        .collect(ImmutableSet.toImmutableSet());
  }

  public static ConfigurationFactory getInstance() {
    return INSTANCE;
  }

}
