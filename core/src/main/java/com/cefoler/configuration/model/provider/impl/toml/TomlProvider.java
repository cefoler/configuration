package com.cefoler.configuration.model.provider.impl.toml;

import com.cefoler.configuration.model.provider.AbstractConfiguration;
import com.cefoler.configuration.model.provider.impl.properties.PropertiesProvider;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.toml.TomlFactory;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class TomlProvider extends AbstractConfiguration {

  private static final long serialVersionUID = 5852130573390919172L;

  private static final TomlFactory TOML_FACTORY;
  private static final TomlMapper TOML_MAPPER;

  static {
    TOML_FACTORY = new TomlFactory();
    TOML_MAPPER = new TomlMapper(TOML_FACTORY);
  }

  private TomlProvider(final String path, final String resource, final boolean replace) {
    super(path, resource, replace);
  }

  @Override
  public ConfigurationType getType() {
    return ConfigurationType.TOML;
  }

  @Override
  protected TomlFactory getFactory() {
    return TOML_FACTORY;
  }

  @Override
  protected TomlMapper getMapper() {
    return TOML_MAPPER;
  }

  public static TomlProvider of(final String path, final String resource) {
    return of(path, resource, false);
  }

  public static TomlProvider of(final String path, final String resource, final boolean replace) {
    return new TomlProvider(path, resource, replace);
  }

}
