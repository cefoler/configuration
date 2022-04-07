package com.cefoler.configuration.model.provider.type;

import com.cefoler.configuration.model.provider.Configuration;
import com.cefoler.configuration.model.provider.impl.json.JsonProvider;
import com.cefoler.configuration.model.provider.impl.properties.PropertiesProvider;
import com.cefoler.configuration.model.provider.impl.toml.TomlProvider;
import com.cefoler.configuration.model.provider.impl.yaml.YamlProvider;
import com.cefoler.configuration.util.Streams;
import com.google.common.collect.ImmutableList;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Locale;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@Getter
@ToString
public enum ConfigurationType {

  JSON(JsonProvider.class, "JSON") {
    @Override
    public Configuration create(final String path, final String resource, final boolean replace) {
      return JsonProvider.of(path, resource, replace);
    }
  },
  YAML(YamlProvider.class, "YAML", "YML") {
    @Override
    public Configuration create(final String path, final String resource, final boolean replace) {
      return YamlProvider.of(path, resource, replace);
    }
  },
  TOML(TomlProvider.class, "TOML", "TML") {
    @Override
    public Configuration create(final String path, final String resource, final boolean replace) {
      return TomlProvider.of(path, resource, replace);
    }
  },
  PROPERTIES(PropertiesProvider.class, "PROPERTIES") {
    @Override
    public Configuration create(final String path, final String resource, final boolean replace) {
      return PropertiesProvider.of(path, resource, replace);
    }
  };

  private final Class<? extends Configuration> clazz;
  private final List<String> names;

  ConfigurationType(final Class<? extends Configuration> clazz, final String... names) {
    this.clazz = clazz;
    this.names = ImmutableList.copyOf(names);
  }

  public abstract Configuration create(final String path, final String resource,
      final boolean replace);

  public Configuration create(final String path, final String resource) {
    return create(path, resource, false);
  }

  public static ConfigurationType getConfiguration(final String driver) {
    final ConfigurationType[] values = values();
    final String converted = driver.toUpperCase(Locale.ROOT);

    return Streams.toStream(values)
        .filter(type -> type.getNames().contains(driver))
        .findFirst()
        .orElseThrow(() -> new InvalidParameterException("Invalid driver: " + driver));
  }

  public static ConfigurationType getConfiguration(final String driver,
      @Nullable final ConfigurationType orElse) {
    final ConfigurationType[] values = values();
    final String converted = driver.toUpperCase(Locale.ROOT);

    return Streams.toStream(values)
        .filter(type -> type.getNames().contains(driver))
        .findFirst()
        .orElse(orElse);
  }

}
