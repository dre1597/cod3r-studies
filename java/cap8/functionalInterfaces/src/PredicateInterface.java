import java.util.function.Predicate;

public class PredicateInterface {
  public static void main(String[] args) {
    Predicate<Integer> greaterThan = num -> num > 100;

    System.out.println(greaterThan.test(150));
  }
}
