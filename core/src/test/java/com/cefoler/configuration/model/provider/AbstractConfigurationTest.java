package com.cefoler.configuration.model.provider;

import com.cefoler.configuration.model.provider.impl.yaml.YamlProvider;
import java.util.List;
import org.junit.jupiter.api.Test;

class AbstractConfigurationTest {

  @Test
  void start() {
    final Configuration configuration = YamlProvider.of("/home/deser/Downloads", "settings.yml", true);
    final List<Double> doubles = configuration.getDoubleList("cefoler2");

    doubles.forEach(System.out::println);
  }

}