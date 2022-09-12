import java.util.function.UnaryOperator;

public class Utils {
  private Utils() {

  }

  public final static UnaryOperator<String> upper = String::toUpperCase;

  public final static UnaryOperator<String> firstLetter = str -> str.charAt(0) + "";
}
