package com.celeste.configuration.model.provider.json;

import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.provider.AbstractConfiguration;
import com.celeste.configuration.model.type.ConfigurationType;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Responsible for instantiating and managing the Json configuration.
 */
public final class JsonProvider extends AbstractConfiguration<JsonFactory> {

  private static final JsonFactory JSON_FACTORY;
  private static final ObjectMapper OBJECT_MAPPER;

  static {
    JSON_FACTORY = new JsonFactory();
    OBJECT_MAPPER = new ObjectMapper(JSON_FACTORY);
  }

  /**
   * Creates a new JsonProvider.
   *
   * @param path String
   * @param resource String
   * @param replace boolean
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   * @throws FailedLoadException Throws when it wasn't possible to load the configuration
   */
  public JsonProvider(final String path, final String resource, final boolean replace)
      throws FailedCreateException, FailedLoadException {
    super(path, resource, replace);
  }

  /**
   * Get the type of the configuration.
   *
   * @return ConfigurationType
   */
  @Override
  public ConfigurationType getType() {
    return ConfigurationType.JSON;
  }

  /**
   * Return a JsonFactory.
   *
   * @return JsonFactory
   */
  @Override
  protected JsonFactory getFactory() {
    return JSON_FACTORY;
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
