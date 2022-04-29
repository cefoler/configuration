import com.cefoler.configuration.core.model.lambda.consumer.ThrowConsumer;
import java.io.Serializable;
import java.util.function.Consumer;

public class Main {

  public static void main(String[] args) {
    final Consumer<? extends String> consumer = ThrowConsumer.convert(
        new ThrowConsumer<Serializable, Exception>() {
          @Override
          public void accept(final Serializable key) throws Exception {

          }
        });
  }

}
