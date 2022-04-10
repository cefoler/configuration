package com.cefoler.configuration.model.provider.impl.configuration.impl.yaml;

import com.cefoler.configuration.model.provider.impl.configuration.AbstractConfiguration;
import com.cefoler.configuration.model.provider.impl.configuration.impl.toml.TomlProvider;
import com.cefoler.configuration.model.provider.impl.configuration.type.ConfigurationType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.io.FileNotFoundException;
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

  private YamlProvider(final String path, final String resource, final boolean replace)
      throws FileNotFoundException {
    super(path, resource, replace);
  }

  private YamlProvider(final File file) throws FileNotFoundException {
    super(file);
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

  public static YamlProvider create(final String path, final String resource)
      throws FileNotFoundException {
    return create(path, resource, false);
  }

  public static YamlProvider create(final String path, final String resource, final boolean replace)
      throws FileNotFoundException {
    return new YamlProvider(path, resource, replace);
  }

  public static YamlProvider of(final File file) throws FileNotFoundException {
    return new YamlProvider(file);
  }

}
