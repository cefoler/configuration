package com.cefoler.configuration.core.util;

import java.util.Collection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Objects {

  public static boolean is(final Object value, final Class<?> clazz) {
    return clazz.isInstance(value);
  }

  public static boolean is(final Class<?> clazz, final Class<?> other) {
    return clazz.equals(other);
  }

  public static boolean isAll(final Object value, final Class<?>... classes) {
    return Streams.toStream(classes).allMatch(clazz -> is(value, clazz));
  }

  public static boolean isAll(final Object value, final Collection<? extends Class<?>> classes) {
    return classes.stream().allMatch(clazz -> is(value, clazz));
  }

  public static boolean isAll(final Class<?> clazz, final Class<?>... classes) {
    return Streams.toStream(classes).allMatch(candidate -> is(clazz, candidate));
  }

  public static boolean isAll(final Class<?> clazz, final Collection<? extends Class<?>> classes) {
    return classes.stream().allMatch(candidate -> is(clazz, candidate));
  }

  public static boolean isAny(final Object value, final Class<?>... classes) {
    return Streams.toStream(classes).anyMatch(clazz -> is(value, clazz));
  }

  public static boolean isAny(final Object value, final Collection<? extends Class<?>> classes) {
    return classes.stream().anyMatch(clazz -> is(value, clazz));
  }

  public static boolean isAny(final Class<?> clazz, final Class<?>... classes) {
    return Streams.toStream(classes).anyMatch(candidate -> is(clazz, candidate));
  }

  public static boolean isAny(final Class<?> clazz, final Collection<? extends Class<?>> classes) {
    return classes.stream().anyMatch(candidate -> is(clazz, candidate));
  }

  @SuppressWarnings("unchecked")
  public static <T> T cast(final Object value) {
    return (T) value;
  }

  public static <T> T cast(final Object value, final Class<T> clazz) {
    return cast(value);
  }

}
