package com.cefoler.configuration.model.provider.impl.properties;

import com.cefoler.configuration.model.provider.AbstractConfiguration;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
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

  private PropertiesProvider(final String path, final String resource, final boolean replace) {
    super(path, resource, replace);
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

  public static PropertiesProvider of(final String path, final String resource) {
    return of(path, resource, false);
  }

  public static PropertiesProvider of(final String path, final String resource,
      final boolean replace) {
    return new PropertiesProvider(path, resource, replace);
  }

}
