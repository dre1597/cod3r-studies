package box;

public class BoxMain {
  public static void main(String[] args) {
    Box<String> boxA = new Box<>();
    boxA.save("Secret");

    String thingA = boxA.open();
    System.out.println(thingA);

    Box<Double> boxB = new Box<>();
    boxB.save(3.14);

    Double thingB = boxB.open();
    System.out.println(thingB);
  }
}
