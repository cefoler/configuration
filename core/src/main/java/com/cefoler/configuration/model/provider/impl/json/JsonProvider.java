package com.cefoler.configuration.model.provider.impl.json;

import com.cefoler.configuration.model.provider.AbstractConfiguration;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class JsonProvider extends AbstractConfiguration {

  private static final long serialVersionUID = 6147879188177442564L;

  private static final JsonFactory JSON_FACTORY;
  private static final JsonMapper JSON_MAPPER;

  static {
    JSON_FACTORY = new JsonFactory();
    JSON_MAPPER = new JsonMapper(JSON_FACTORY);

    JSON_FACTORY.enable(Feature.ALLOW_COMMENTS);
  }

  private JsonProvider(final String path, final String resource, final boolean replace) {
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
  protected JsonMapper getMapper() {
    return JSON_MAPPER;
  }

  public static JsonProvider of(final String path, final String resource) {
    return of(path, resource, false);
  }

  public static JsonProvider of(final String path, final String resource, final boolean replace) {
    return new JsonProvider(path, resource, replace);
  }

}
