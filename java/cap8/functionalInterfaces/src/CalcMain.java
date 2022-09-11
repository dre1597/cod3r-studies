import java.util.function.BinaryOperator;

public class CalcMain {
  public static void main(String[] args) {
    Calculation calc = (x,y) -> x * y;
    Calculation calc2 = (x,y) -> { return x + y + 1; };
    Calculation calc3 = Double::sum;

    System.out.println(calc.exec(2,3));
    System.out.println(calc2.exec(2,3));
    System.out.println(calc3.exec(2,3));

    BinaryOperator<Double> calc4 = (x, y) -> x * y;
    System.out.println(calc4.apply(2.0,3.0));
  }
}
