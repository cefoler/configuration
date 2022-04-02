package com.cefoler.configuration.factory;

import com.cefoler.configuration.model.properties.Resources;
import com.cefoler.configuration.model.provider.Configuration;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.cefoler.configuration.util.Streams;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NonNls;
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

  public Configuration start(final Resources resources) {
    @Nullable
    final String driver = resources.find("driver", null);

    final String path = resources.find("path");
    final String resource = resources.find("resource");

    final boolean replace = resources.find("replace", false);
//    final String converted = driver.isEmpty()

    final ConfigurationType type = ConfigurationType.getConfiguration(driver);

    return start(type, path, resource, replace);
  }

  public Configuration start(final File file) {
    final String path = file.getParent();
    final String name = file.getName();

    return start(path, name);
  }

  public Configuration start(final String path, final String resource) {
    return start(path, resource, false);
  }

  public Configuration start(final String path, final String resource, final boolean replace) {
    final Matcher matcher = REGEX.matcher(resource);
    final String extension = matcher.replaceFirst("");

    final ConfigurationType configuration = ConfigurationType.getConfiguration(extension);
    return start(extension, path, resource, replace);
  }

  public Configuration start(final String driver, final String path, final String resource,
      final boolean replace) {
    final ConfigurationType configuration = ConfigurationType.getConfiguration(driver);
    return start(configuration, path, resource, replace);
  }

  public Configuration start(final ConfigurationType type, final String path, final String resource,
      final boolean replace) {
    return type.create(path, resource, replace);
  }

  public Set<Configuration> startByFolder(final File folder, final String... ignored) {
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
        .map(this::start)
        .collect(Collectors.toSet());
  }

  public static ConfigurationFactory getInstance() {
    return INSTANCE;
  }

}
