package com.cefoler.configuration.model.entity;

import com.cefoler.configuration.model.entity.type.ReplaceType;
import java.io.Serializable;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode
public final class ReplaceValue implements Serializable {

  private static final long serialVersionUID = 6784231446913874137L;

  private final String value;
  private final ReplaceType type;

}
