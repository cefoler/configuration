package com.celeste.configuration.model.entity;

import com.celeste.configuration.model.entity.type.ReplaceType;
import com.celeste.configuration.model.map.ReplaceMap;
import com.celeste.configuration.model.provider.Configuration;
import lombok.Builder;
import lombok.Data;

/**
 * Entity where there is replacement information.
 * <p> These values are saved in a {@link ReplaceMap} which can be added, removed or accessed by
 * the {@link Configuration} class in the {@code getReplacer()} method.
 */
@Data
@Builder
public final class ReplaceValue {

  private final String value;
  private final ReplaceType type;

}
