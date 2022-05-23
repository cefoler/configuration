package com.cefoler.configuration.core.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.StringJoiner;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Reflection {

  public static <T> Class<T> getClazz(final Object object) {
    final Class<?> clazz = object.getClass();
    return getClazz(clazz);
  }

  public static Class<?>[] getClazz(final Object... objects) {
    return Streams.toStream(objects)
        .map(Object::getClass)
        .toArray(Class<?>[]::new);
  }

  public static <T> Class<T> getClazz(final String path) throws ClassNotFoundException {
    final Class<?> clazz = Class.forName(path);
    return getClazz(clazz);
  }

  public static <T> Class<T> getClazz(final Field field) {
    final Class<?> clazz = field.getType();
    return getClazz(clazz);
  }

  public static <T> Class<T> getClazz(final Class<?> clazz) {
    return Objects.cast(clazz);
  }

  public static <T> Class<? super T>[] getClasses(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getClasses(clazz);
  }

  public static <T> Class<? super T> getClasses(final Object object, final int index) {
    final Class<?> clazz = getClazz(object);
    return getClasses(clazz, index);
  }

  public static <T> Class<? super T>[] getClasses(final String path) throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getClasses(clazz);
  }

  public static <T> Class<? super T> getClasses(final String path, final int index)
      throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getClasses(clazz, index);
  }

  public static <T> Class<? super T>[] getClasses(final Class<?> clazz) {
    final Class<?>[] classes = clazz.getClasses();
    return Objects.cast(classes);
  }

  public static <T> Class<? super T> getClasses(final Class<?> clazz, final int index) {
    final Class<? super T>[] classes = getClasses(clazz);
    return classes[index];
  }

  public static <T> Class<? super T>[] getDeclaredClasses(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getDeclaredClasses(clazz);
  }

  public static <T> Class<? super T> getDeclaredClasses(final Object object, final int index) {
    final Class<?> clazz = getClazz(object);
    return getDeclaredClasses(clazz, index);
  }

  public static <T> Class<? super T>[] getDeclaredClasses(final String path)
      throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getDeclaredClasses(clazz);
  }

  public static <T> Class<? super T> getDeclaredClasses(final String path, final int index)
      throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getDeclaredClasses(clazz, index);
  }

  public static <T> Class<? super T>[] getDeclaredClasses(final Class<?> clazz) {
    final Class<?>[] classes = clazz.getDeclaredClasses();
    return Objects.cast(classes);
  }

  public static <T> Class<? super T> getDeclaredClasses(final Class<?> clazz, final int index) {
    final Class<? super T>[] classes = getDeclaredClasses(clazz);
    return classes[index];
  }

  public static String getClassName(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getClassName(clazz);
  }

  public static String getClassName(final Class<?> clazz) {
    return clazz.getName();
  }

  public static String getClassSimpleName(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getClassName(clazz);
  }

  public static String getClassSimpleName(final Class<?> clazz) {
    return clazz.getSimpleName();
  }

  public static String getClassCanonicalName(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getClassCanonicalName(clazz);
  }

  public static String getClassCanonicalName(final Class<?> clazz) {
    return clazz.getCanonicalName();
  }

  public static Package getPackage(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getPackage(clazz);
  }

  public static Package getPackage(final Class<?> clazz) {
    return clazz.getPackage();
  }

  public static String getPackageName(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getPackageName(clazz);
  }

  public static String getPackageName(final Class<?> clazz) {
    final Package pack = getPackage(clazz);
    return getPackageName(pack);
  }

  public static String getPackageName(final Package pack) {
    return pack.getName();
  }

  public static <T> Constructor<T> getConstructor(final Object object, final Object... objects)
      throws NoSuchMethodException {
    final Class<T> clazz = getClazz(object);
    return getConstructor(clazz, objects);
  }

  public static <T> Constructor<T> getConstructor(final Object object, final Class<?>... parameters)
      throws NoSuchMethodException {
    final Class<T> clazz = getClazz(object);
    return getConstructor(clazz, parameters);
  }

  public static <T> Constructor<T> getConstructor(final String path, final Object... objects)
      throws ClassNotFoundException, NoSuchMethodException {
    final Class<T> clazz = getClazz(path);
    return getConstructor(clazz, objects);
  }

  public static <T> Constructor<T> getConstructor(final String path, final Class<?>... parameters)
      throws ClassNotFoundException, NoSuchMethodException {
    final Class<T> clazz = getClazz(path);
    return getConstructor(clazz, parameters);
  }

  public static <T> Constructor<T> getConstructor(final Class<T> clazz, final Object... objects)
      throws NoSuchMethodException {
    final Class<?>[] parameters = getClazz(objects);
    return getConstructor(clazz, parameters);
  }

  public static <T> Constructor<T> getConstructor(final Class<T> clazz,
      final Class<?>... parameters) throws NoSuchMethodException {
    return clazz.getConstructor(parameters);
  }

  public static <T> Constructor<T>[] getConstructors(final Object object) {
    final Class<T> clazz = getClazz(object);
    return getConstructors(clazz);
  }

  public static <T> Constructor<T> getConstructors(final Object object, final int index) {
    final Class<T> clazz = getClazz(object);
    return getConstructors(clazz, index);
  }

  public static <T> Constructor<T>[] getConstructors(final String path)
      throws ClassNotFoundException {
    final Class<T> clazz = getClazz(path);
    return getConstructors(clazz);
  }

  public static <T> Constructor<T> getConstructors(final String path, final int index)
      throws ClassNotFoundException {
    final Class<T> clazz = getClazz(path);
    return getConstructors(clazz, index);
  }

  public static <T> Constructor<T>[] getConstructors(final Class<T> clazz) {
    final Constructor<?>[] constructors = clazz.getConstructors();
    return Objects.cast(constructors);
  }

  public static <T> Constructor<T> getConstructors(final Class<T> clazz, final int index) {
    final Constructor<T>[] constructors = getConstructors(clazz);
    return constructors[index];
  }

  public static <T> Constructor<T> getDeclaredConstructor(final Object object,
      final Object... objects) throws NoSuchMethodException {
    final Class<T> clazz = getClazz(object);
    return getDeclaredConstructor(clazz, objects);
  }

  public static <T> Constructor<T> getDeclaredConstructor(final Object object,
      final Class<?>... parameters) throws NoSuchMethodException {
    final Class<T> clazz = getClazz(object);
    return getDeclaredConstructor(clazz, parameters);
  }

  public static <T> Constructor<T> getDeclaredConstructor(final String path,
      final Object... objects) throws ClassNotFoundException, NoSuchMethodException {
    final Class<T> clazz = getClazz(path);
    return getDeclaredConstructor(clazz, objects);
  }

  public static <T> Constructor<T> getDeclaredConstructor(final String path,
      final Class<?>... parameters) throws ClassNotFoundException, NoSuchMethodException {
    final Class<T> clazz = getClazz(path);
    return getDeclaredConstructor(clazz, parameters);
  }

  public static <T> Constructor<T> getDeclaredConstructor(final Class<T> clazz,
      final Object... objects) throws NoSuchMethodException {
    final Class<?>[] parameters = getClazz(objects);
    return getDeclaredConstructor(clazz, parameters);
  }

  public static <T> Constructor<T> getDeclaredConstructor(final Class<T> clazz,
      final Class<?>... parameters) throws NoSuchMethodException {
    final Constructor<T> constructor = clazz.getDeclaredConstructor(parameters);
    constructor.setAccessible(true);

    return constructor;
  }

  public static <T> Constructor<T>[] getDeclaredConstructors(final Object object) {
    final Class<T> clazz = getClazz(object);
    return getDeclaredConstructors(clazz);
  }

  public static <T> Constructor<T> getDeclaredConstructors(final Object object, final int index) {
    final Class<T> clazz = getClazz(object);
    return getDeclaredConstructors(clazz, index);
  }

  public static <T> Constructor<T>[] getDeclaredConstructors(final String path)
      throws ClassNotFoundException {
    final Class<T> clazz = getClazz(path);
    return getDeclaredConstructors(clazz);
  }

  public static <T> Constructor<T> getDeclaredConstructors(final String path, final int index)
      throws ClassNotFoundException {
    final Class<T> clazz = getClazz(path);
    return getDeclaredConstructors(clazz, index);
  }

  public static <T> Constructor<T>[] getDeclaredConstructors(final Class<T> clazz) {
    final Constructor<?>[] constructors = clazz.getDeclaredConstructors();

    final Constructor<?>[] converted = Streams.toStream(constructors)
        .peek(constructor -> constructor.setAccessible(true))
        .toArray(Constructor<?>[]::new);

    return Objects.cast(converted);
  }

  public static <T> Constructor<T> getDeclaredConstructors(final Class<T> clazz, final int index) {
    final Constructor<?>[] constructors = clazz.getDeclaredConstructors();
    final Constructor<?> constructor = constructors[index];

    constructor.setAccessible(true);
    return Objects.cast(constructor);
  }

  public static Method getMethod(final Object object, final String name, final Object... objects)
      throws NoSuchMethodException {
    final Class<?> clazz = getClazz(object);
    return getMethod(clazz, name, objects);
  }

  public static Method getMethod(final Object object, final String name,
      final Class<?>... parameters) throws NoSuchMethodException {
    final Class<?> clazz = getClazz(object);
    return getMethod(clazz, name, parameters);
  }

  public static Method getMethod(final String path, final String name, final Object... objects)
      throws ClassNotFoundException, NoSuchMethodException {
    final Class<?> clazz = getClazz(path);
    return getMethod(clazz, name, objects);
  }

  public static Method getMethod(final String path, final String name, final Class<?>... parameters)
      throws ClassNotFoundException, NoSuchMethodException {
    final Class<?> clazz = getClazz(path);
    return getMethod(clazz, name, parameters);
  }

  public static Method getMethod(final Class<?> clazz, final String name, final Object... objects)
      throws NoSuchMethodException {
    final Class<?>[] parameters = getClazz(objects);
    return clazz.getMethod(name, parameters);
  }

  public static Method getMethod(final Class<?> clazz, final String name,
      final Class<?>... parameters) throws NoSuchMethodException {
    return clazz.getMethod(name, parameters);
  }

  public static Method[] getMethods(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getMethods(clazz);
  }

  public static Method getMethods(final Object object, final int index) {
    final Class<?> clazz = getClazz(object);
    return getMethods(clazz, index);
  }

  public static Method[] getMethods(final String path) throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getMethods(clazz);
  }

  public static Method getMethods(final String path, final int index)
      throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getMethods(clazz, index);
  }

  public static Method[] getMethods(final Class<?> clazz) {
    return clazz.getMethods();
  }

  public static Method getMethods(final Class<?> clazz, final int index) {
    final Method[] methods = getMethods(clazz);
    return methods[index];
  }

  public static Method getDeclaredMethod(final Object object, final String name,
      final Object... objects) throws NoSuchMethodException {
    final Class<?> clazz = getClazz(object);
    return getDeclaredMethod(clazz, name, objects);
  }

  public static Method getDeclaredMethod(final Object object, final String name,
      final Class<?>... parameters) throws NoSuchMethodException {
    final Class<?> clazz = getClazz(object);
    return getDeclaredMethod(clazz, name, parameters);
  }

  public static Method getDeclaredMethod(final String path, final String name,
      final Object... objects) throws ClassNotFoundException, NoSuchMethodException {
    final Class<?> clazz = getClazz(path);
    return getDeclaredMethod(clazz, name, objects);
  }

  public static Method getDeclaredMethod(final String path, final String name,
      final Class<?>... parameters) throws ClassNotFoundException, NoSuchMethodException {
    final Class<?> clazz = getClazz(path);
    return getDeclaredMethod(clazz, name, parameters);
  }

  public static Method getDeclaredMethod(final Class<?> clazz, final String name,
      final Object... objects) throws NoSuchMethodException {
    final Class<?>[] parameters = getClazz(objects);
    return getDeclaredMethod(clazz, name, parameters);
  }

  public static Method getDeclaredMethod(final Class<?> clazz, final String name,
      final Class<?>... parameters) throws NoSuchMethodException {
    final Method method = clazz.getDeclaredMethod(name, parameters);
    method.setAccessible(true);

    return method;
  }

  public static Method[] getDeclaredMethods(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getDeclaredMethods(clazz);
  }

  public static Method getDeclaredMethods(final Object object, final int index) {
    final Class<?> clazz = getClazz(object);
    return getDeclaredMethods(clazz, index);
  }

  public static Method[] getDeclaredMethods(final String path) throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getDeclaredMethods(clazz);
  }

  public static Method getDeclaredMethods(final String path, final int index)
      throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getDeclaredMethods(clazz, index);
  }

  public static Method[] getDeclaredMethods(final Class<?> clazz) {
    final Method[] methods = clazz.getDeclaredMethods();

    return Streams.toStream(methods)
        .peek(method -> method.setAccessible(true))
        .toArray(Method[]::new);
  }

  public static Method getDeclaredMethods(final Class<?> clazz, final int index) {
    final Method[] methods = clazz.getDeclaredMethods();
    final Method method = methods[index];

    method.setAccessible(true);
    return method;
  }

  public static Field getField(final Object object, final String name) throws NoSuchFieldException {
    final Class<?> clazz = getClazz(object);
    return getField(clazz, name);
  }

  public static Field getField(final String path, final String name)
      throws ClassNotFoundException, NoSuchFieldException {
    final Class<?> clazz = getClazz(path);
    return getField(clazz, name);
  }

  public static Field getField(final Class<?> clazz, final String name)
      throws NoSuchFieldException {
    return clazz.getField(name);
  }

  public static Field[] getFields(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getFields(clazz);
  }

  public static Field getFields(final Object object, final int index) {
    final Class<?> clazz = getClazz(object);
    return getFields(clazz, index);
  }

  public static Field[] getFields(final String path) throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getFields(clazz);
  }

  public static Field getFields(final String path, final int index) throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getFields(clazz, index);
  }

  public static Field[] getFields(final Class<?> clazz) {
    return clazz.getFields();
  }

  public static Field getFields(final Class<?> clazz, final int index) {
    final Field[] fields = getFields(clazz);
    return fields[index];
  }

  public static Field getDeclaredField(final Object object, final String name)
      throws NoSuchFieldException {
    final Class<?> clazz = getClazz(object);
    return getDeclaredField(clazz, name);
  }

  public static Field getDeclaredField(final String path, final String name)
      throws ClassNotFoundException, NoSuchFieldException {
    final Class<?> clazz = getClazz(path);
    return getDeclaredField(clazz, name);
  }

  public static Field getDeclaredField(final Class<?> clazz, final String name)
      throws NoSuchFieldException {
    final Field field = clazz.getDeclaredField(name);
    field.setAccessible(true);

    return field;
  }

  public static Field[] getDeclaredFields(final Object object) {
    final Class<?> clazz = getClazz(object);
    return getDeclaredFields(clazz);
  }

  public static Field getDeclaredFields(final Object object, final int index) {
    final Class<?> clazz = getClazz(object);
    return getDeclaredFields(clazz, index);
  }

  public static Field[] getDeclaredFields(final String path) throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getDeclaredFields(clazz);
  }

  public static Field getDeclaredFields(final String path, final int index)
      throws ClassNotFoundException {
    final Class<?> clazz = getClazz(path);
    return getDeclaredFields(clazz, index);
  }

  public static Field[] getDeclaredFields(final Class<?> clazz) {
    final Field[] fields = clazz.getDeclaredFields();

    return Streams.toStream(fields)
        .peek(field -> field.setAccessible(true))
        .toArray(Field[]::new);
  }

  public static Field getDeclaredFields(final Class<?> clazz, final int index) {
    final Field[] fields = clazz.getDeclaredFields();
    final Field field = fields[index];

    field.setAccessible(true);
    return field;
  }

  public static String getMemberName(final Member member) {
    return member.getName();
  }

  public static <T extends Annotation> boolean containsAnnotation(final AnnotatedElement element,
      final Class<T> annotation) {
    return element.isAnnotationPresent(annotation);
  }

  public static <T extends Annotation> T getAnnotation(final AnnotatedElement element,
      final Class<T> annotation) {
    return element.getAnnotation(annotation);
  }

  public static <T> T instance(final Object object)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,
      InstantiationException {
    final Class<T> clazz = getClazz(object);
    return instance(clazz);
  }

  public static <T> T instance(final Object object, final Object... values)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,
      InstantiationException {
    final Class<T> clazz = getClazz(object);
    return instance(clazz, values);
  }

  public static <T> T instance(final Class<T> clazz)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,
      InstantiationException {
    final Constructor<T> constructor = getDeclaredConstructor(clazz);
    return instance(constructor);
  }

  public static <T> T instance(final Class<T> clazz, final Object... values)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,
      InstantiationException {
    final Class<?>[] parameters = getClazz(values);
    final Constructor<T>[] constructors = getDeclaredConstructors(clazz);

    final int length = parameters.length;

    final Constructor<T> constructor = Streams.toStream(constructors)
        .filter(candidate -> candidate.getParameterCount() == length)
        .filter(candidate -> {
          final Class<?>[] candidateParameters = candidate.getParameterTypes();

          return Streams.toStream(candidateParameters)
              .allMatch(parameter -> Streams.toStream(parameters)
                  .anyMatch(parameter::isAssignableFrom));
        })
        .findFirst()
        .orElseThrow(() -> {
          final StringJoiner joiner = new StringJoiner(", ");

          Streams.toStream(parameters)
              .map(Reflection::getClassCanonicalName)
              .forEach(joiner::add);

          final String text = joiner.toString();
          return new NoSuchMethodException("Constructor not found with parameters: " + text);
        });

    return instance(constructor, values);
  }

  public static <T> T instance(final Constructor<T> constructor)
      throws InvocationTargetException, IllegalAccessException, InstantiationException {
    return constructor.newInstance();
  }

  public static <T> T instance(final Constructor<T> constructor, final Object... values)
      throws InvocationTargetException, IllegalAccessException, InstantiationException {
    return constructor.newInstance(values);
  }

  public static <T> T invoke(final Method method, @Nullable final Object instance,
      final Object... values) throws InvocationTargetException, IllegalAccessException {
    final Object value = method.invoke(instance, values);
    return Objects.cast(value);
  }

  public static <T> T invokeStatic(final Method method, final Object... values)
      throws InvocationTargetException, IllegalAccessException {
    return invoke(method, null, values);
  }

  public static <T> T get(final Field field, @Nullable final Object instance)
      throws IllegalAccessException {
    final Object value = field.get(instance);
    return Objects.cast(value);
  }

  public static <T> T getStatic(final Field field) throws IllegalAccessException {
    return get(field, null);
  }

  public static void set(final Field field, @Nullable final Object instance, final Object value)
      throws IllegalAccessException {
    field.set(instance, value);
  }

  public static void setStatic(final Field field, final Object value)
      throws IllegalAccessException {
    set(field, null, value);
  }

}
