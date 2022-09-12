import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Map {
  public static void main(String[] args) {
    Consumer<String> print = System.out::print;
    List<String> brands = Arrays.asList("BMW ", "Toyota ", "Honda ");
    brands.stream().map(String::toUpperCase).forEach(print);

    brands.stream().map(Utils.upper).map(Utils.firstLetter).forEach(print);
  }
}
