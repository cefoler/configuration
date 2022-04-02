package com.cefoler.configuration.model.provider.properties;

import com.cefoler.configuration.exception.FailedCreateException;
import com.cefoler.configuration.exception.FailedLoadException;
import com.cefoler.configuration.model.provider.AbstractConfiguration;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;

/**
 * Responsible for instantiating and managing the Properties configuration.
 */
public final class PropertiesProvider extends AbstractConfiguration<JavaPropsFactory> {

  private static final JavaPropsFactory PROPERTIES_FACTORY;
  private static final ObjectMapper OBJECT_MAPPER;

  static {
    PROPERTIES_FACTORY = new JavaPropsFactory();
    OBJECT_MAPPER = new ObjectMapper(PROPERTIES_FACTORY);
  }

  /**
   * Creates a new PropertiesProvider.
   *
   * @param path String
   * @param resource String
   * @param replace boolean
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   * @throws FailedLoadException Throws when it wasn't possible to load the configuration
   */
  public PropertiesProvider(final String path, final String resource, final boolean replace) {
    super(path, resource, replace);
  }

  /**
   * Get the type of the configuration.
   *
   * @return ConfigurationType
   */
  @Override
  public ConfigurationType getType() {
    return ConfigurationType.PROPERTIES;
  }

  /**
   * Return a JavaPropsFactory.
   *
   * @return YAMLFactory
   */
  @Override
  protected JavaPropsFactory getFactory() {
    return PROPERTIES_FACTORY;
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
