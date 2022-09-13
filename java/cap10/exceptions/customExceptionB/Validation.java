package exceptions.customExceptionB;

import exceptions.Student;

public class Validation {
  private Validation() {
  }

  public static void student(Student student) throws IllegalArgumentException, EmptyStringException, OutOfBoundsNumberException {
    if (student == null) {
      throw new IllegalArgumentException("The student is null!");
    }

    if (student.name == null || student.name.trim().isEmpty()) {
      throw new EmptyStringException("name");
    }

    if (student.degree < 0 || student.degree > 10) {
      throw new OutOfBoundsNumberException("degree");
    }
  }
}
