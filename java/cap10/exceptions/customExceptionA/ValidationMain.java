package exceptions.customExceptionA;

import exceptions.Student;

public class ValidationMain {
  public static void main(String[] args) {
    try {
      Student student = new Student("Ana", 7);
      Validation.student(student);

      Validation.student(null);
    } catch (EmptyStringException | OutOfBoundsNumberException | IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("End.");
  }
}
