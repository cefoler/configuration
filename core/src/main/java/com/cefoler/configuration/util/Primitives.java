package com.cefoler.configuration.util;

import com.cefoler.configuration.util.type.PrimitiveType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Primitives {

  private static final Class<?>[] PRIMITIVES;

  static {
    final PrimitiveType[] values = PrimitiveType.values();

    PRIMITIVES = Streams.toStream(values)
        .map(PrimitiveType::getClazz)
        .toArray(Class[]::new);
  }

  public static boolean isPrimitive(final Object value) {
    final Class<?> clazz = Reflection.getClazz(value);
    return isPrimitive(clazz);
  }

  public static boolean isPrimitive(final Class<?> clazz) {
    return clazz.equals(int.class) || clazz.equals(double.class) || clazz.equals(boolean.class)
        || clazz.equals(long.class) || clazz.equals(float.class) || clazz.equals(byte.class)
        || clazz.equals(short.class) || clazz.equals(char.class);
  }

  public static boolean isChar(final Object value) {
    final Class<?> clazz = Reflection.getClazz(value);
    return isChar(clazz);
  }

  public static boolean isChar(final Class<?> clazz) {
    return clazz.equals(char.class);
  }

  public static boolean isByte(final Object value) {
    final Class<?> clazz = Reflection.getClazz(value);
    return isByte(clazz);
  }

  public static boolean isByte(final Class<?> clazz) {
    return clazz.equals(byte.class);
  }

  public static boolean isShort(final Object value) {
    final Class<?> clazz = Reflection.getClazz(value);
    return isShort(clazz);
  }

  public static boolean isShort(final Class<?> clazz) {
    return clazz.equals(short.class);
  }

  public static boolean isInt(final Object value) {
    final Class<?> clazz = Reflection.getClazz(value);
    return isInt(clazz);
  }

  public static boolean isInt(final Class<?> clazz) {
    return clazz.equals(int.class);
  }

  public static boolean isLong(final Object value) {
    final Class<?> clazz = Reflection.getClazz(value);
    return isLong(clazz);
  }

  public static boolean isLong(final Class<?> clazz) {
    return clazz.equals(long.class);
  }

  public static boolean isFloat(final Object value) {
    final Class<?> clazz = Reflection.getClazz(value);
    return isFloat(clazz);
  }

  public static boolean isFloat(final Class<?> clazz) {
    return clazz.equals(float.class);
  }

  public static boolean isDouble(final Object value) {
    final Class<?> clazz = Reflection.getClazz(value);
    return isDouble(clazz);
  }

  public static boolean isDouble(final Class<?> clazz) {
    return clazz.equals(double.class);
  }

  public static boolean isBoolean(final Object value) {
    final Class<?> clazz = Reflection.getClazz(value);
    return isBoolean(clazz);
  }

  public static boolean isBoolean(final Class<?> clazz) {
    return clazz.equals(boolean.class);
  }

  public static char toChar(final Object value) {
    final CharSequence converted = Wrappers.toString(value);
    return toChar(converted);
  }

  public static char toChar(final Object value, final int index) {
    final CharSequence converted = Wrappers.toString(value);
    return toChar(converted, index);
  }

  public static char toChar(final CharSequence value) {
    return toChar(value, 0);
  }

  public static char toChar(final CharSequence value, final int index) {
    return value.charAt(index);
  }

  public static byte toByte(final Object value) {
    final String converted = Wrappers.toString(value);
    return toByte(converted);
  }

  public static byte toByte(final String value) {
    final long converted = toLong(value);
    return toByte(converted);
  }

  public static byte toByte(final Number value) {
    return value.byteValue();
  }

  public static short toShort(final Object value) {
    final String converted = Wrappers.toString(value);
    return toShort(converted);
  }

  public static short toShort(final String value) {
    final long converted = toLong(value);
    return toShort(converted);
  }

  public static short toShort(final Number value) {
    return value.shortValue();
  }

  public static int toInt(final Object value) {
    final String converted = Wrappers.toString(value);
    return toInt(converted);
  }

  public static int toInt(final String value) {
    final long converted = toLong(value);
    return toInt(converted);
  }

  public static int toInt(final Number value) {
    return value.intValue();
  }

  public static long toLong(final Object value) {
    final String converted = Wrappers.toString(value);
    return toLong(converted);
  }

  public static long toLong(final String value) {
    final double converted = toDouble(value);
    return toLong(converted);
  }

  public static long toLong(final Number value) {
    return value.longValue();
  }

  public static float toFloat(final Object value) {
    final String converted = Wrappers.toString(value);
    return toFloat(converted);
  }

  public static float toFloat(final String value) {
    return Float.parseFloat(value);
  }

  public static float toFloat(final Number value) {
    return value.floatValue();
  }

  public static double toDouble(final Object value) {
    final String converted = Wrappers.toString(value);
    return toDouble(converted);
  }

  public static double toDouble(final String value) {
    return Double.parseDouble(value);
  }

  public static double toDouble(final Number value) {
    return value.doubleValue();
  }

  public static boolean toBoolean(final Object value) {
    final String converted = Wrappers.toString(value);
    return toBoolean(converted);
  }

  public static boolean toBoolean(final String value) {
    return Boolean.parseBoolean(value);
  }

  public static Class<?>[] getPrimitives() {
    return PRIMITIVES;
  }

}
