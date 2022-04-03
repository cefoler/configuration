package com.cefoler.configuration.model.provider.impl.json;

import com.cefoler.configuration.model.provider.AbstractConfiguration;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class JsonProvider extends AbstractConfiguration<JsonFactory> {

  private static final long serialVersionUID = -170324639369121720L;

  private static final JsonFactory JSON_FACTORY;
  private static final ObjectMapper OBJECT_MAPPER;

  static {
    JSON_FACTORY = new JsonFactory();
    OBJECT_MAPPER = new ObjectMapper(JSON_FACTORY);
  }

  public JsonProvider(final String path, final String resource, final boolean replace) {
    super(path, resource, replace);
  }

  @Override
  public ConfigurationType getType() {
    return ConfigurationType.JSON;
  }

  @Override
  protected JsonFactory getFactory() {
    return JSON_FACTORY;
  }

  @Override
  protected ObjectMapper getMapper() {
    return OBJECT_MAPPER;
  }

}
