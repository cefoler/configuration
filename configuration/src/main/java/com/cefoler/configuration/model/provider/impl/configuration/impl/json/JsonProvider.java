package com.cefoler.configuration.model.provider.impl.configuration.impl.json;

import com.cefoler.configuration.model.provider.impl.configuration.AbstractConfiguration;
import com.cefoler.configuration.model.provider.impl.configuration.type.ConfigurationType;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.File;
import java.io.FileNotFoundException;
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

  private JsonProvider(final String path, final String resource, final boolean replace)
      throws FileNotFoundException {
    super(path, resource, replace);
  }

  private JsonProvider(final File file) throws FileNotFoundException {
    super(file);
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

  public static JsonProvider create(final String path, final String resource)
      throws FileNotFoundException {
    return create(path, resource, false);
  }

  public static JsonProvider create(final String path, final String resource, final boolean replace)
      throws FileNotFoundException {
    return new JsonProvider(path, resource, replace);
  }

  public static JsonProvider of(final File file) throws FileNotFoundException {
    return new JsonProvider(file);
  }

}
