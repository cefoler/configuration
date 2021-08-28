package com.celeste.configuration.model.entity.type;

import com.celeste.configuration.model.entity.ReplaceValue;
import com.google.common.collect.ImmutableList;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

/**
 * Indicates which action type values will be replaced.
 * @see ReplaceValue
 */
@Getter
public enum ReplaceType {

  ALL("ALL", "*"),
  SET("SET"),
  GET("GET");

  private final List<String> names;

  /**
   * Create a new enum of {@link ReplaceType}.
   *
   * @param names Array of names that can be given to this format.
   */
  ReplaceType(final String... names) {
    this.names = ImmutableList.copyOf(names);
  }

  /**
   * Get an enum of {@link ReplaceType}, it will get based on your list of names.
   * <p> This method can create an {@link InvalidParameterException} unchecked exception if no enum is found
   * with that name.
   *
   * @param replace Name of the enum.
   * @return {@link ReplaceType} An instance of {@link ReplaceType} the instance will be set
   * according to the {@code replace} parameter.
   */
  public static ReplaceType getReplace(final String replace) {
    return Arrays.stream(values())
        .filter(type -> type.getNames().contains(replace.toUpperCase()))
        .findFirst()
        .orElseThrow(() -> new InvalidParameterException("Invalid replace: " + replace));
  }

  /**
   * Get an enum of {@link ReplaceType}, it will get based on your list of names.
   *
   * @param replace Name of the enum.
   * @param orElse Enum that is returned by default if no enum is found according to
   * the {@code replace} parameter
   * @return {@link ReplaceType} An instance of {@link ReplaceType} the instance will be set
   * according to the {@code replace} parameter.
   */
  public static ReplaceType getReplace(final String replace, final ReplaceType orElse) {
    return Arrays.stream(values())
        .filter(type -> type.getNames().contains(replace.toUpperCase()))
        .findFirst()
        .orElse(orElse);
  }

}