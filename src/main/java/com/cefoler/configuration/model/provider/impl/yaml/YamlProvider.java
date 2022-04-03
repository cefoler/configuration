package com.cefoler.configuration.model.provider.impl.yaml;

import com.cefoler.configuration.model.provider.AbstractConfiguration;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class YamlProvider extends AbstractConfiguration<YAMLFactory> {

  private static final long serialVersionUID = -8011022440079007600L;

  private static final YAMLFactory YAML_FACTORY;
  private static final ObjectMapper OBJECT_MAPPER;

  static {
    YAML_FACTORY = new YAMLFactory();
    OBJECT_MAPPER = new ObjectMapper(YAML_FACTORY);

    YAML_FACTORY.disable(Feature.WRITE_DOC_START_MARKER);
  }

  public YamlProvider(final String path, final String resource, final boolean replace) {
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
  protected ObjectMapper getMapper() {
    return OBJECT_MAPPER;
  }

}
