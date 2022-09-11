import java.util.Arrays;
import java.util.List;

public class ForEach {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("name1", "name2", "name3");

    for(String name:  names) {
      System.out.println(name);
    }

    System.out.println();

    names.forEach(name -> System.out.println(name));

    System.out.println();

    names.forEach(System.out::println);
  }
}
