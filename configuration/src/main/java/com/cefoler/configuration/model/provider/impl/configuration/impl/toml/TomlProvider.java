package com.cefoler.configuration.model.provider.impl.configuration.impl.toml;

import com.cefoler.configuration.model.provider.impl.configuration.AbstractConfiguration;
import com.cefoler.configuration.model.provider.impl.configuration.impl.json.JsonProvider;
import com.cefoler.configuration.model.provider.impl.configuration.type.ConfigurationType;
import com.fasterxml.jackson.dataformat.toml.TomlFactory;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import java.io.File;
import java.io.FileNotFoundException;
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

  private TomlProvider(final String path, final String resource, final boolean replace)
      throws FileNotFoundException {
    super(path, resource, replace);
  }

  private TomlProvider(final File file) throws FileNotFoundException {
    super(file);
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

  public static TomlProvider create(final String path, final String resource)
      throws FileNotFoundException {
    return create(path, resource, false);
  }

  public static TomlProvider create(final String path, final String resource, final boolean replace)
      throws FileNotFoundException {
    return new TomlProvider(path, resource, replace);
  }

  public static TomlProvider of(final File file) throws FileNotFoundException {
    return new TomlProvider(file);
  }

}
