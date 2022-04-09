package com.cefoler.configuration.factory;

import com.cefoler.configuration.model.properties.Resources;
import com.cefoler.configuration.util.Streams;
import com.cefoler.configuration.model.provider.impl.configuration.Configuration;
import com.cefoler.configuration.model.provider.impl.configuration.type.ConfigurationType;
import com.google.common.annotations.Beta;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public final class ConfigurationFactory {

  private static final ConfigurationFactory INSTANCE;
  private static final Pattern REGEX;

  static {
    INSTANCE = new ConfigurationFactory();
    REGEX = Pattern.compile(".*[$.]");
  }

  public Configuration create(final Resources resources) throws FileNotFoundException {
    @Nullable
    final String driver = resources.find("driver", null);

    final String path = resources.find("path");
    final String resource = resources.find("resource");

    final boolean replace = resources.find("replace", false);

    if (driver == null) {
      return create(path, resource, replace);
    }

    final ConfigurationType type = ConfigurationType.getConfiguration(driver);
    return create(type, path, resource, replace);
  }

  @Beta
  public Configuration create(final File file) {
    return null;
  }

  public Configuration create(final String path, final String resource)
      throws FileNotFoundException {
    return create(path, resource, false);
  }

  public Configuration create(final String path, final String resource, final boolean replace)
      throws FileNotFoundException {
    final Matcher matcher = REGEX.matcher(resource);
    final String extension = matcher.replaceFirst("");

    final ConfigurationType configuration = ConfigurationType.getConfiguration(extension);
    return create(configuration, path, resource, replace);
  }

  public Configuration create(final String driver, final String path, final String resource,
      final boolean replace) throws FileNotFoundException {
    final ConfigurationType configuration = ConfigurationType.getConfiguration(driver);
    return create(configuration, path, resource, replace);
  }

  public Configuration create(final ConfigurationType type, final String path, final String resource,
      final boolean replace) throws FileNotFoundException {
    return type.create(path, resource, replace);
  }

  public Set<Configuration> createByFolder(final File folder, final String... ignored) {
    if (!folder.exists()) {
      return new LinkedHashSet<>(0);
    }

    final File[] files = folder.listFiles();
    final int length = files.length;

    if (length == 0) {
      return new LinkedHashSet<>(0);
    }

    return Streams.toStream(files)
        .filter(file -> {
          final String name = file.getName();
          final String[] split = name.split("\\.", 2);

          final String converted = split[0];
          return Streams.toStream(ignored).anyMatch(candidate -> candidate.startsWith(converted));
        })
        .map(this::create)
        .collect(Collectors.toSet());
  }

  public static ConfigurationFactory getInstance() {
    return INSTANCE;
  }

}
