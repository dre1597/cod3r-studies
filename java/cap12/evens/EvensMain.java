package evens;

public class EvensMain {
  public static void main(String[] args) {
    Evens<Integer, String> result = new Evens<>();

    result.add(1, "Maria");
    result.add(2, "Pedro");
    result.add(3, "Gui");
    result.add(4, "Ana");
    result.add(2, "Rebeca");

    System.out.println(result.getValue(1));
    System.out.println(result.getValue(4));
    System.out.println(result.getValue(2));
  }
}
