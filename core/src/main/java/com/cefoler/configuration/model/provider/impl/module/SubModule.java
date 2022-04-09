package com.cefoler.configuration.model.provider.impl.module;

import com.cefoler.configuration.model.map.ConvertMap;
import com.cefoler.configuration.model.map.ReplaceMap;
import com.cefoler.configuration.model.provider.AbstractModule;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class SubModule extends AbstractModule {

  private static final long serialVersionUID = 7151604101325588955L;

  private SubModule(final Map<?, ?> configuration) {
    super(configuration);
  }

  public static SubModule of(final Map<?, ?> configuration) {
    return new SubModule(configuration);
  }

  public static SubModule of(final Map<?, ?> configuration, final ConvertMap converters) {
    final SubModule module = new SubModule(configuration);
    module.addConverters(converters);

    return module;
  }

  public static SubModule of(final Map<?, ?> configuration, final ReplaceMap replacers) {
    final SubModule module = new SubModule(configuration);
    module.addReplacers(replacers);

    return module;
  }

  public static SubModule of(final Map<?, ?> configuration, final ConvertMap converters,
      final ReplaceMap replacers) {
    final SubModule module = new SubModule(configuration);

    module.addConverters(converters);
    module.addReplacers(replacers);

    return module;
  }

}
