package com.celeste.configuration.model.provider.properties;

import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.provider.AbstractConfiguration;
import com.celeste.configuration.model.type.ConfigurationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;

/**
 * Responsible for instantiating and managing the Properties configuration.
 */
public final class PropertiesProvider extends AbstractConfiguration<JavaPropsFactory> {

  protected static final JavaPropsFactory PROPERTIES_FACTORY;
  protected static final ObjectMapper OBJECT_MAPPER;

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
  public PropertiesProvider(final String path, final String resource, final boolean replace)
      throws FailedCreateException, FailedLoadException {
    super(path, resource, replace);
  }

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
