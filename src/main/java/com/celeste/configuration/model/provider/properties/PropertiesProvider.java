package com.celeste.configuration.model.provider.properties;

import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.provider.AbstractConfiguration;
import com.celeste.configuration.model.type.ConfigurationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.jetbrains.annotations.NotNull;

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
   * @param path         String
   * @param resourcePath String
   * @param replace      boolean
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   * @throws FailedLoadException   Throws when it wasn't possible to load the configuration
   */
  public PropertiesProvider(@NotNull final String path, @NotNull final String resourcePath,
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
   * Return a JavaPropsFactory.
   *
   * @return YAMLFactory
   */
  @Override
  @NotNull
  protected JavaPropsFactory getFactory() {
    return PROPERTIES_FACTORY;
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
