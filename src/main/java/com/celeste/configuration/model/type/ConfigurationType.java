package com.celeste.configuration.model.type;

import com.celeste.configuration.model.provider.Configuration;
import com.celeste.configuration.model.provider.json.JsonProvider;
import com.celeste.configuration.model.provider.properties.PropertiesProvider;
import com.celeste.configuration.model.provider.yaml.YamlProvider;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Types of configurations.
 */
@Getter
public enum ConfigurationType {

  JSON(JsonProvider.class, "JSON", "JSN"),
  YAML(YamlProvider.class, "YAML", "YML"),
  PROPERTIES(PropertiesProvider.class, "PROPERTIES", "PROP");

  @NotNull
  private final Class<? extends Configuration> provider;

  @NotNull
  private final List<String> names;

  /**
   * Create a new enum of ConfigurationType.
   *
   * @param provider Type of this class
   * @param names    List of names that can be given to this format
   */
  ConfigurationType(@NotNull final Class<? extends Configuration> provider,
      @NotNull final String... names) {
    this.provider = provider;
    this.names = ImmutableList.copyOf(names);
  }

  /**
   * Gets the configuration by their type.
   *
   * @param configuration String
   * @return ConfigurationType
   */
  @NotNull
  public static ConfigurationType getConfiguration(@NotNull final String configuration) {
    return Arrays.stream(values())
        .filter(type -> type.getNames().contains(configuration.toUpperCase()))
        .findFirst()
        .orElseThrow(
            () -> new NullPointerException("Invalid configuration type: " + configuration));
  }

}