package com.cefoler.configuration.model.provider.yaml;

import com.cefoler.configuration.exception.FailedCreateException;
import com.cefoler.configuration.exception.FailedLoadException;
import com.cefoler.configuration.model.provider.AbstractConfiguration;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;

/**
 * Responsible for instantiating and managing the YAML configuration.
 */
public final class YamlProvider extends AbstractConfiguration<YAMLFactory> {

  private static final YAMLFactory YAML_FACTORY;
  private static final ObjectMapper OBJECT_MAPPER;

  static {
    YAML_FACTORY = new YAMLFactory();
    OBJECT_MAPPER = new ObjectMapper(YAML_FACTORY);

    YAML_FACTORY.disable(Feature.WRITE_DOC_START_MARKER);
  }

  /**
   * Creates a new YamlProvider.
   *
   * @param path String
   * @param resource String
   * @param replace boolean
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   * @throws FailedLoadException Throws when it wasn't possible to load the configuration
   */
  public YamlProvider(final String path, final String resource, final boolean replace) {
    super(path, resource, replace);
  }

  /**
   * Get the type of the configuration.
   *
   * @return ConfigurationType
   */
  @Override
  public ConfigurationType getType() {
    return ConfigurationType.YAML;
  }

  /**
   * Return a YAMLFactory.
   *
   * @return YAMLFactory
   */
  @Override
  protected YAMLFactory getFactory() {
    return YAML_FACTORY;
  }

  /**
   * Return a ObjectMapper.
   *
   * @return ObjectMapper
   */
  @Override
  protected ObjectMapper getMapper() {
    return OBJECT_MAPPER;
  }

}