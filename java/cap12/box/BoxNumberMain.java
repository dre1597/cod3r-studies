package box;

public class BoxNumberMain {
  public static void main(String[] args) {
    BoxNumber<Double> boxA = new BoxNumber<>();
    boxA.save(2.3);
    System.out.println(boxA.open());

    BoxNumber<Integer> boxB = new BoxNumber<>();
    boxB.save(123);
    System.out.println(boxB.open());
  }
}
