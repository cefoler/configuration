package com.celeste.configuration.model.provider.yaml;

import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.provider.AbstractConfiguration;
import com.celeste.configuration.model.type.ConfigurationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.jetbrains.annotations.NotNull;

/**
 * Responsible for instantiating and managing the YAML configuration.
 */
public final class YamlProvider extends AbstractConfiguration<YAMLFactory> {

  private static final YAMLFactory YAML_FACTORY;
  private static final ObjectMapper OBJECT_MAPPER;

  static {
    YAML_FACTORY = new YAMLFactory();
    OBJECT_MAPPER = new ObjectMapper(YAML_FACTORY);

    YAML_FACTORY.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
  }

  /**
   * Creates a new YamlProvider.
   *
   * @param path         String
   * @param resourcePath String
   * @param replace      boolean
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   * @throws FailedLoadException   Throws when it wasn't possible to load the configuration
   */
  public YamlProvider(@NotNull final String path, @NotNull final String resourcePath,
      final boolean replace)
      throws FailedCreateException, FailedLoadException {
    super(path, resourcePath, replace);
  }

  @Override
  @NotNull
  public ConfigurationType getType() {
    return ConfigurationType.YAML;
  }

  /**
   * Return a YAMLFactory.
   *
   * @return YAMLFactory
   */
  @Override
  @NotNull
  protected YAMLFactory getFactory() {
    return YAML_FACTORY;
  }

  /**
   * Return a ObjectMapper.
   *
   * @return ObjectMapper
   */
  @Override
  @NotNull
  protected ObjectMapper getMapper() {
    return OBJECT_MAPPER;
  }

}
