import com.celeste.configuration.factory.ConfigurationFactory;
import com.celeste.configuration.model.provider.Configuration;
import com.celeste.configuration.model.type.ConfigurationType;

public class Main {

  public static void main(final String[] args) {
    try {
      final Configuration configuration = ConfigurationFactory.getInstance()
          .start(ConfigurationType.YAML, "/home/deser/Downloads", "config.yml", false);

      final Long abluble = configuration.getLong("name", 10L);
      System.out.println(abluble);
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
//      exception.printStackTrace();
    }
  }
}
