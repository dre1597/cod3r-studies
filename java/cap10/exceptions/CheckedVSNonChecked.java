package exceptions;

public class CheckedVSNonChecked {
  public static void main(String[] args) {
    try {
      generateError1();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      generateError2();
    } catch (Throwable e) {
      System.out.println(e.getMessage());
    }

    System.out.println("End.");
  }

  // Non Checked - There isn't a compilation error - is optional the declaration "throws" on the method
  static void generateError1() throws RuntimeException {
    throw new RuntimeException("Some error #1");
  }

  // Checked - There is a compilation error - need the declaration "throws" on the method
  static void generateError2() throws Exception {
    throw new Exception("Some error #2");
  }
}
