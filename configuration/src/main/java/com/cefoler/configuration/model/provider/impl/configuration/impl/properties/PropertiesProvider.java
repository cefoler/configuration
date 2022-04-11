package com.cefoler.configuration.model.provider.impl.configuration.impl.properties;

import com.cefoler.configuration.model.provider.impl.configuration.AbstractConfiguration;
import com.cefoler.configuration.model.provider.impl.configuration.type.ConfigurationType;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import java.io.File;
import java.io.FileNotFoundException;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class PropertiesProvider extends AbstractConfiguration {

  private static final long serialVersionUID = 7324002951235339179L;

  private static final JavaPropsFactory PROPERTIES_FACTORY;
  private static final JavaPropsMapper PROPERTIES_MAPPER;

  static {
    PROPERTIES_FACTORY = new JavaPropsFactory();
    PROPERTIES_MAPPER = new JavaPropsMapper(PROPERTIES_FACTORY);
  }

  private PropertiesProvider(final String path, final String resource, final boolean replace)
      throws FileNotFoundException {
    super(path, resource, replace);
  }

  private PropertiesProvider(final File file) throws FileNotFoundException {
    super(file);
  }

  @Override
  public ConfigurationType getType() {
    return ConfigurationType.PROPERTIES;
  }

  @Override
  protected JavaPropsFactory getFactory() {
    return PROPERTIES_FACTORY;
  }

  @Override
  protected JavaPropsMapper getMapper() {
    return PROPERTIES_MAPPER;
  }

  public static PropertiesProvider create(final String path, final String resource)
      throws FileNotFoundException {
    return create(path, resource, false);
  }

  public static PropertiesProvider create(final String path, final String resource,
      final boolean replace) throws FileNotFoundException {
    return new PropertiesProvider(path, resource, replace);
  }

  public static PropertiesProvider of(final File file) throws FileNotFoundException {
    return new PropertiesProvider(file);
  }

}
