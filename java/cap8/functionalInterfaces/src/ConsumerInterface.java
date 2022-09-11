import java.util.function.Consumer;

public class ConsumerInterface {
  public static void main(String[] args) {
    Consumer<String> print = System.out::println;

    print.accept("Hello World");
  }
}
