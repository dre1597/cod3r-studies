import java.util.function.Function;

public class FunctionInterface {
  public static void main(String[] args) {
    Function<Integer, String> evenOrOdd = num -> num % 2 == 0 ? "Even" : "Odd";
    Function<String, String> printResult = value -> "The result is: " + value;

    System.out.println(evenOrOdd.andThen(printResult).apply(30));
    System.out.println(evenOrOdd.andThen(printResult).apply(31));
  }
}
