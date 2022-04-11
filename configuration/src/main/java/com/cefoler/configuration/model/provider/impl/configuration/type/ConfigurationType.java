package com.cefoler.configuration.model.provider.impl.configuration.type;

import com.cefoler.configuration.core.util.Streams;
import com.cefoler.configuration.model.provider.impl.configuration.Configuration;
import com.cefoler.configuration.model.provider.impl.configuration.impl.json.JsonProvider;
import com.cefoler.configuration.model.provider.impl.configuration.impl.properties.PropertiesProvider;
import com.cefoler.configuration.model.provider.impl.configuration.impl.toml.TomlProvider;
import com.cefoler.configuration.model.provider.impl.configuration.impl.yaml.YamlProvider;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Locale;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

@Getter
@ToString
public enum ConfigurationType {

  JSON(JsonProvider.class, "JSON") {
    @Override
    public Configuration create(final String path, final String resource, final boolean replace)
        throws FileNotFoundException {
      return JsonProvider.create(path, resource, replace);
    }

    @Override
    public Configuration of(final File file) throws FileNotFoundException {
      return JsonProvider.of(file);
    }
  },
  YAML(YamlProvider.class, "YAML", "YML") {
    @Override
    public Configuration create(final String path, final String resource, final boolean replace)
        throws FileNotFoundException {
      return YamlProvider.create(path, resource, replace);
    }

    @Override
    public Configuration of(final File file) throws FileNotFoundException {
      return YamlProvider.of(file);
    }
  },
  TOML(TomlProvider.class, "TOML") {
    @Override
    public Configuration create(final String path, final String resource, final boolean replace)
        throws FileNotFoundException {
      return TomlProvider.create(path, resource, replace);
    }

    @Override
    public Configuration of(final File file) throws FileNotFoundException {
      return TomlProvider.of(file);
    }
  },
  PROPERTIES(PropertiesProvider.class, "PROPERTIES") {
    @Override
    public Configuration create(final String path, final String resource, final boolean replace)
        throws FileNotFoundException {
      return PropertiesProvider.create(path, resource, replace);
    }

    @Override
    public Configuration of(final File file) throws FileNotFoundException {
      return PropertiesProvider.of(file);
    }
  };

  private final Class<? extends Configuration> clazz;

  @Unmodifiable
  private final List<String> names;

  ConfigurationType(final Class<? extends Configuration> clazz, final String... names) {
    this.clazz = clazz;
    this.names = ImmutableList.copyOf(names);
  }

  public abstract Configuration create(final String path, final String resource,
      final boolean replace) throws FileNotFoundException;

  public Configuration create(final String path, final String resource)
      throws FileNotFoundException {
    return create(path, resource, false);
  }

  public abstract Configuration of(final File file) throws FileNotFoundException;

  public String getExtension() {
    final String extension = names.get(0);
    return extension.toLowerCase(Locale.ROOT);
  }

  public static ConfigurationType getConfiguration(final String driver) {
    final ConfigurationType[] values = values();
    final String converted = driver.toUpperCase(Locale.ROOT);

    return Streams.toStream(values)
        .filter(type -> type.getNames().contains(converted))
        .findFirst()
        .orElseThrow(() -> new InvalidParameterException("Invalid driver: " + driver));
  }

  public static ConfigurationType getConfiguration(final String driver,
      @Nullable final ConfigurationType orElse) {
    final ConfigurationType[] values = values();
    final String converted = driver.toUpperCase(Locale.ROOT);

    return Streams.toStream(values)
        .filter(type -> type.getNames().contains(converted))
        .findFirst()
        .orElse(orElse);
  }

}
