import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierInterface {
  public static void main(String[] args) {
    Supplier<List<String>> someList = () -> Arrays.asList("name1", "name2", "name3");

    System.out.println(someList.get());
  }
}
