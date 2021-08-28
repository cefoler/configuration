package com.celeste.configuration.factory;

import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.provider.Configuration;
import com.celeste.configuration.model.type.ConfigurationType;
import com.celeste.configuration.util.Reflection;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * A factory of instances of {@link Configuration}.<p>
 *
 * This class uses the Singleton design pattern, so there is only one instance of this class,
 * which can be obtained through the {@code getInstance()} method.
 * <p> You must use the {@code start()} method to get an instance of {@link Configuration}.
 */
public final class ConfigurationFactory {

  private static final ConfigurationFactory INSTANCE;

  static {
    INSTANCE = new ConfigurationFactory();
  }

  /**
   * Create a new {@link Configuration} that supports input and output options to a file.
   *
   * @param properties Used for creating the {@link Configuration}.
   * <p> All data must be inserted as a {@link String}.
   * <p> Must contain the {@code driver} which is the type of the configuration file.
   * <p> Must contain the {@code path} which is the path of the remote configuration file where
   * it should be created or get.
   * <p> Must contain the {@code resource} which is the path of the local configuration file.
   * <p> It should contain the {@code replace}, which mentions whether the file should be overwritten
   * every time the method is invoked.
   * @return {@link Configuration} An instance of {@link Configuration} the instance will be set
   * according to the {@code properties} parameter.
   * @throws FailedCreateException It can be launched if unable to create the configuration file
   * or fails to copy data from a local configuration file to the remote configuration file.
   */
  public Configuration start(final Properties properties) throws FailedCreateException {
    try {
      final ConfigurationType type = ConfigurationType
          .getConfiguration(properties.getProperty("driver"));

      final String path = properties.getProperty("path");
      final String resource = properties.getProperty("resource");

      final boolean replace = Boolean.parseBoolean(properties.getProperty("replace"));

      return start(type, path, resource, replace);
    } catch (Exception exception) {
      throw new FailedCreateException(exception);
    }
  }

  /**
   * Create a new {@link Configuration} that supports input and output options to a file.
   *
   * @param type ConfigurationType Type of file configuration.
   * @param path Remote configuration file path where it should be created or get.
   * @param resource Local configuration file path.
   * @param replace Whether the file should be overwritten every time the method is invoked.
   * @return {@link Configuration} An instance of {@link Configuration} the instance will be set
   * according to the {@code type} parameter.
   * @throws FailedCreateException It can be launched if unable to create the configuration file
   * or fails to copy data from a local configuration file to the remote configuration file.
   */
  public Configuration start(final ConfigurationType type, final String path, final String resource,
      final boolean replace) throws FailedCreateException {
    try {
      final Class<? extends Configuration> providerClazz = type.getProvider();
      final Constructor<? extends Configuration> providerConstructor = Reflection
          .getConstructor(providerClazz, String.class, String.class, boolean.class);

      return Reflection.instance(providerConstructor, path, resource, replace);
    } catch (Exception exception) {
      throw new FailedCreateException(exception);
    }
  }

  /**
   * Gets an {@link ConfigurationFactory} instance.
   *
   * @return {@link ConfigurationFactory} instance.
   */
  public static ConfigurationFactory getInstance() {
    return INSTANCE;
  }

}
