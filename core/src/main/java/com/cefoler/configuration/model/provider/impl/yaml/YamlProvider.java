package com.cefoler.configuration.model.provider.impl.yaml;

import com.cefoler.configuration.model.provider.AbstractConfiguration;
import com.cefoler.configuration.model.provider.impl.toml.TomlProvider;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class YamlProvider extends AbstractConfiguration {

  private static final long serialVersionUID = -5223554532112757093L;

  private static final YAMLFactory YAML_FACTORY;
  private static final YAMLMapper YAML_MAPPER;

  static {
    YAML_FACTORY = new YAMLFactory();
    YAML_MAPPER = new YAMLMapper(YAML_FACTORY);

    YAML_FACTORY.disable(Feature.WRITE_DOC_START_MARKER);
  }

  private YamlProvider(final String path, final String resource, final boolean replace) {
    super(path, resource, replace);
  }

  @Override
  public ConfigurationType getType() {
    return ConfigurationType.YAML;
  }

  @Override
  protected YAMLFactory getFactory() {
    return YAML_FACTORY;
  }

  @Override
  protected YAMLMapper getMapper() {
    return YAML_MAPPER;
  }

  public static YamlProvider of(final String path, final String resource) {
    return of(path, resource, false);
  }

  public static YamlProvider of(final String path, final String resource, final boolean replace) {
    return new YamlProvider(path, resource, replace);
  }

}
