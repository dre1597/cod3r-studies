public class NumberConversion {
  public static void main(String[] args) {
    double a = 1.1231241421414141;
    System.out.println(a);

    // the variable a will be truncate
    float b = (float) a;
    System.out.println(b);

    int c = 4000;
    System.out.println(c);

    // the variable a will be truncate and may not be what was expected
    byte d = (byte) c;
    System.out.println(d);
  }
}
