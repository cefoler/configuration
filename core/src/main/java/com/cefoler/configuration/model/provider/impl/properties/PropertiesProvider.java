package com.cefoler.configuration.model.provider.impl.properties;

import com.cefoler.configuration.model.provider.AbstractConfiguration;
import com.cefoler.configuration.model.provider.type.ConfigurationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class PropertiesProvider extends AbstractConfiguration<JavaPropsFactory> {

  private static final long serialVersionUID = 2073194103307257834L;

  private static final JavaPropsFactory PROPERTIES_FACTORY;
  private static final ObjectMapper OBJECT_MAPPER;

  static {
    PROPERTIES_FACTORY = new JavaPropsFactory();
    OBJECT_MAPPER = new ObjectMapper(PROPERTIES_FACTORY);
  }

  public PropertiesProvider(final String path, final String resource, final boolean replace) {
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
  protected ObjectMapper getMapper() {
    return OBJECT_MAPPER;
  }

}
