package com.cefoler.configuration.core.util;

import com.cefoler.configuration.core.util.type.WrapperType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Wrappers {

  private static final Class<?>[] WRAPPERS;

  static {
    final WrapperType[] values = WrapperType.values();

    WRAPPERS = Streams.toStream(values)
        .map(WrapperType::getClazz)
        .toArray(Class[]::new);
  }

  public static boolean isWrapper(final Object value) {
    return value instanceof String || value instanceof Integer || value instanceof Double
        || value instanceof Boolean || value instanceof Long || value instanceof Float
        || value instanceof Byte || value instanceof Short || value instanceof Character;
  }

  public static boolean isWrapper(final Class<?> clazz) {
    return clazz.equals(String.class) || clazz.equals(Integer.class) || clazz.equals(Double.class)
        || clazz.equals(Boolean.class) || clazz.equals(Long.class) || clazz.equals(Float.class)
        || clazz.equals(Byte.class) || clazz.equals(Short.class) || clazz.equals(Character.class);
  }

  public static boolean isCharacter(final Object value) {
    return value instanceof Character;
  }

  public static boolean isCharacter(final Class<?> clazz) {
    return clazz.equals(Character.class);
  }

  public static boolean isString(final Object value) {
    return value instanceof String;
  }

  public static boolean isString(final Class<?> clazz) {
    return clazz.equals(String.class);
  }

  public static boolean isByte(final Object value) {
    return value instanceof Byte;
  }

  public static boolean isByte(final Class<?> clazz) {
    return clazz.equals(Byte.class);
  }

  public static boolean isShort(final Object value) {
    return value instanceof Short;
  }

  public static boolean isShort(final Class<?> clazz) {
    return clazz.equals(Short.class);
  }

  public static boolean isInteger(final Object value) {
    return value instanceof Integer;
  }

  public static boolean isInteger(final Class<?> clazz) {
    return clazz.equals(Integer.class);
  }

  public static boolean isLong(final Object value) {
    return value instanceof Long;
  }

  public static boolean isLong(final Class<?> clazz) {
    return clazz.equals(Long.class);
  }

  public static boolean isFloat(final Object value) {
    return value instanceof Float;
  }

  public static boolean isFloat(final Class<?> clazz) {
    return clazz.equals(Float.class);
  }

  public static boolean isDouble(final Object value) {
    return value instanceof Double;
  }

  public static boolean isDouble(final Class<?> clazz) {
    return clazz.equals(Double.class);
  }

  public static boolean isBoolean(final Object value) {
    return value instanceof Boolean;
  }

  public static boolean isBoolean(final Class<?> clazz) {
    return clazz.equals(Boolean.class);
  }

  public static Character toCharacter(final Object value) {
    final CharSequence converted = toString(value);
    return toCharacter(converted);
  }

  public static Character toCharacter(final Object value, final int index) {
    final CharSequence converted = toString(value);
    return toCharacter(converted, index);
  }

  public static Character toCharacter(final CharSequence value) {
    return toCharacter(value, 0);
  }

  public static Character toCharacter(final CharSequence value, final int index) {
    return value.charAt(index);
  }

  public static String toString(final Object value) {
    return String.valueOf(value);
  }

  public static Byte toByte(final Object value) {
    final String converted = toString(value);
    return toByte(converted);
  }

  public static Byte toByte(final String value) {
    final Float converted = toFloat(value);
    return toByte(converted);
  }

  public static Byte toByte(final Number value) {
    return value.byteValue();
  }

  public static Short toShort(final Object value) {
    final String converted = toString(value);
    return toShort(converted);
  }

  public static Short toShort(final String value) {
    final Float converted = toFloat(value);
    return toShort(converted);
  }

  public static Short toShort(final Number value) {
    return value.shortValue();
  }

  public static Integer toInteger(final Object value) {
    final String converted = toString(value);
    return toInteger(converted);
  }

  public static Integer toInteger(final String value) {
    final Float converted = toFloat(value);
    return toInteger(converted);
  }

  public static Integer toInteger(final Number value) {
    return value.intValue();
  }

  public static Long toLong(final Object value) {
    final String converted = toString(value);
    return toLong(converted);
  }

  public static Long toLong(final String value) {
    final Double converted = toDouble(value);
    return toLong(converted);
  }

  public static Long toLong(final Number value) {
    return value.longValue();
  }

  public static Float toFloat(final Object value) {
    final String converted = toString(value);
    return toFloat(converted);
  }

  public static Float toFloat(final String value) {
    return Float.valueOf(value);
  }

  public static Float toFloat(final Number value) {
    return value.floatValue();
  }

  public static Double toDouble(final Object value) {
    final String converted = toString(value);
    return toDouble(converted);
  }

  public static Double toDouble(final String value) {
    return Double.valueOf(value);
  }

  public static Double toDouble(final Number value) {
    return value.doubleValue();
  }

  public static Boolean toBoolean(final Object value) {
    final String converted = toString(value);
    return toBoolean(converted);
  }

  public static Boolean toBoolean(final String value) {
    return Boolean.valueOf(value);
  }

  public static Class<?>[] getWrappers() {
    return WRAPPERS;
  }

}
