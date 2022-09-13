package exceptions;

public class Basic {
  public static void main(String[] args) {
    Student s1 = null;

    try {
      printStudentName(s1);
    } catch (Exception exception) {
      System.out.println("There is a error when trying to print the student name. " + exception.getMessage());
    }

    try {
      System.out.println(7 / 0);
    } catch (ArithmeticException exception) {
      System.out.println("It's not possible to divide by zero. " + exception.getMessage());
    }

    System.out.println("End.");
  }

  public static void printStudentName(Student student) {
    System.out.println(student.name);
  }
}
