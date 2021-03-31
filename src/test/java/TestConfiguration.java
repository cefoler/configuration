import com.celeste.configuration.factory.ConfigurationFactory;
import com.celeste.configuration.model.ConfigurationType;
import com.celeste.configuration.model.exception.FailedCreateException;
import com.celeste.configuration.model.exception.FailedLoadException;
import com.celeste.configuration.model.exception.FailedSaveException;
import com.celeste.configuration.model.provider.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestConfiguration {

  private static final LinkedHashMap<String, String> map = new LinkedHashMap<>();

  public static void main(String[] args) {
    try {
      new TestConfiguration().test();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }

  void test() throws FailedCreateException, FailedLoadException, FailedSaveException {
    final Configuration config = ConfigurationFactory.getInstance().start(
        ConfigurationType.YAML,
        "/home/deser/Downloads",
        "config.yml",
        true
    );

    final String name1 = config.getString("users.Deser.name");
    final int age1 = config.getInt("users.Deser.age");

    System.out.println(name1 + " " + age1);

    final String name2 = config.getString("users.luiza.name");
    final int age2 = config.getInt("users.luiza.age");

    System.out.println(name2 + " " + age2);

    System.out.println("-----");
    config.getKeys("").forEach(System.out::println);
    System.out.println("-----");

    config.set("users.leo.name", "leonardo");
    config.set("users.leo.age", 19);

    final String name3 = config.getString("users.leo.name");
    final int age3 = config.getInt("users.leo.age");

    System.out.println(name3 + " " + age3);

    System.out.println("-----");
    config.getKeys("").forEach(System.out::println);
    System.out.println("-----");

    config.saveAndUpdate();
  }

}
