package com.celeste.configuration.model.type;

import com.celeste.configuration.model.provider.Configuration;
import com.celeste.configuration.model.provider.json.JsonProvider;
import com.celeste.configuration.model.provider.properties.PropertiesProvider;
import com.celeste.configuration.model.provider.yaml.YamlProvider;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

/**
 * Types of configurations.
 */
@Getter
public enum ConfigurationType {

  JSON(JsonProvider.class, "JSON", "JSN"),
  YAML(YamlProvider.class, "YAML", "YML"),
  PROPERTIES(PropertiesProvider.class, "PROPERTIES", "PROP");

  private final Class<? extends Configuration> provider;
  private final List<String> names;

  /**
   * Create a new enum of ConfigurationType.
   *
   * @param provider Type of this class
   * @param names    List of names that can be given to this format
   */
  ConfigurationType(final Class<? extends Configuration> provider, final String... names) {
    this.provider = provider;
    this.names = ImmutableList.copyOf(names);
  }

  /**
   * Gets the configuration by their type.
   *
   * @param configuration String
   * @return ConfigurationType
   */
  public static ConfigurationType getConfiguration(final String configuration) {
    return Arrays.stream(values())
        .filter(type -> type.getNames().contains(configuration.toUpperCase()))
        .findFirst()
        .orElseThrow(
            () -> new NullPointerException("Invalid configuration type: " + configuration));
  }

}
