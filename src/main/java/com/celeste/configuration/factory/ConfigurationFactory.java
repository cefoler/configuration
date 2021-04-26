package com.celeste.configuration.factory;

import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.provider.Configuration;
import com.celeste.configuration.model.type.ConfigurationType;
import java.lang.reflect.Constructor;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;

/**
 * A factory of instances of configurations.
 */
@SuppressWarnings("unused")
public final class ConfigurationFactory {

  private static final ConfigurationFactory INSTANCE = new ConfigurationFactory();

  /**
   * Returns the ConfigurationFactory instance.
   *
   * @return ConfigurationFactory
   */
  public static ConfigurationFactory getInstance() {
    return INSTANCE;
  }

  /**
   * Starts a configuration with the properties driver, path, resourcePath and replace.
   *
   * @param properties Properties
   * @return Configuration
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   */
  public Configuration start(@NotNull final Properties properties) throws FailedCreateException {
    try {
      return start(
          ConfigurationType.getConfiguration(properties.getProperty("driver")),
          properties.getProperty("path"),
          properties.getProperty("resourcePath"),
          Boolean.parseBoolean(properties.getProperty("replace"))
      );
    } catch (Throwable throwable) {
      throw new FailedCreateException(throwable);
    }
  }

  /**
   * Starts a new configuration with the following credentials.
   *
   * @param configuration ConfigurationType
   * @param path          String
   * @param resourcePath  String
   * @param replace       boolean
   * @return Configuration
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   */
  public Configuration start(@NotNull final ConfigurationType configuration,
      @NotNull final String path,
      @NotNull final String resourcePath, final boolean replace) throws FailedCreateException {
    try {
      final Constructor<? extends Configuration> providerConstructor =
          configuration.getProvider().getConstructor(String.class, String.class, boolean.class);

      return providerConstructor.newInstance(path, resourcePath, replace);
    } catch (Throwable throwable) {
      throw new FailedCreateException(throwable);
    }
  }

}
