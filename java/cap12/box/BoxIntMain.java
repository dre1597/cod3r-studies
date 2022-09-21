package box;

public class BoxIntMain {
  public static void main(String[] args) {
    BoxInt box = new BoxInt();
    box.save(123);

    Integer thing = box.open();
    System.out.println(thing);
  }
}
