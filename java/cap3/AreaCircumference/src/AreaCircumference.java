public class AreaCircumference {
  public static void main(String[] args) {
    int radio = 3;
    final double PI = 3.14159;

    double area = PI * radio * radio;

    System.out.println("Area: " + area + "m2.");

    radio = 10;
    area = PI * radio * radio;
    System.out.println("Area: " + area + "m2.");
  }
}
