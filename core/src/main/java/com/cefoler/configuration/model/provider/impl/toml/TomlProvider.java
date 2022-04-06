package com.cefoler.configuration.model.provider.impl.toml;

import com.cefoler.configuration.model.provider.AbstractConfiguration;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;
import com.fasterxml.jackson.dataformat.toml.TomlFactory;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class TomlProvider extends AbstractConfiguration<TomlFactory> {

  private static final long serialVersionUID = 2073194103307257834L;

  private static final TomlFactory TOML_FACTORY;
  private static final ObjectMapper OBJECT_MAPPER;

  static {
    TOML_FACTORY = new TomlFactory();
    OBJECT_MAPPER = new ObjectMapper(TOML_FACTORY);
  }

  public TomlProvider(final String path, final String resource, final boolean replace) {
    super(path, resource, replace);
  }

  @Override
  public ConfigurationType getType() {
    return ConfigurationType.PROPERTIES;
  }

  @Override
  protected TomlFactory getFactory() {
    return TOML_FACTORY;
  }

  @Override
  protected ObjectMapper getMapper() {
    return OBJECT_MAPPER;
  }

}
