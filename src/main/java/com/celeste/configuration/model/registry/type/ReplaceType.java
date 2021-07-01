package com.celeste.configuration.model.registry.type;

import com.google.common.collect.ImmutableList;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

/**
 * Types of replaces.
 */
@Getter
public enum ReplaceType {

  ALL("ALL", "*"),
  SET("SET"),
  GET("GET");

  private final List<String> names;

  /**
   * Create a new enum of ReplaceType.
   *
   * @param names List of names that can be given to this format.
   */
  ReplaceType(final String... names) {
    this.names = ImmutableList.copyOf(names);
  }

  /**
   * Gets the replace by their type.
   *
   * @param replace String
   * @return ReplaceType
   */
  public static ReplaceType getReplace(final String replace) {
    return Arrays.stream(values())
        .filter(type -> type.getNames().contains(replace.toUpperCase()))
        .findFirst()
        .orElseThrow(() -> new InvalidParameterException("Invalid replace type: " + replace));
  }

}