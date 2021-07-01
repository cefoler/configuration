package com.celeste.configuration.factory;

import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.provider.Configuration;
import com.celeste.configuration.model.type.ConfigurationType;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * A factory of instances of configurations.
 */
public final class ConfigurationFactory {

  private static final ConfigurationFactory INSTANCE;

  static {
    INSTANCE = new ConfigurationFactory();
  }

  /**
   * Starts a configuration with the properties driver, path, resource and replace.
   *
   * @param properties Properties
   * @return Configuration
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   */
  public Configuration start(final Properties properties) throws FailedCreateException {
    try {
      final ConfigurationType driver = ConfigurationType
          .getConfiguration(properties.getProperty("driver"));

      final String path = properties.getProperty("path");
      final String resource = properties.getProperty("resource");

      final boolean replace = Boolean.parseBoolean(properties.getProperty("replace"));

      return start(driver, path, resource, replace);
    } catch (Exception exception) {
      throw new FailedCreateException(exception);
    }
  }

  /**
   * Starts a new configuration with the following credentials.
   *
   * @param configuration ConfigurationType
   * @param path String
   * @param resource String
   * @param replace boolean
   * @return Configuration
   * @throws FailedCreateException Throws when it wasn't possible to create the configuration
   */
  public Configuration start(final ConfigurationType configuration, final String path,
      final String resource, final boolean replace) throws FailedCreateException {
    try {
      final Constructor<? extends Configuration> providerConstructor = configuration.getProvider()
          .getConstructor(String.class, String.class, boolean.class);

      return providerConstructor.newInstance(path, resource, replace);
    } catch (Exception exception) {
      throw new FailedCreateException(exception);
    }
  }

  /**
   * Returns the ConfigurationFactory instance.
   *
   * @return ConfigurationFactory
   */
  public static ConfigurationFactory getInstance() {
    return INSTANCE;
  }

}
