public class LabeledBreak {
  public static void main(String[] args) {
    outer:
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 1) {
          break outer;
        }
        System.out.printf("[i:%d j:%d] ", i, j);
      }
      System.out.println();
    }
    System.out.println("End");
  }
}
