import java.util.ArrayList;

public class Lecture {
  final String name;
  final ArrayList<Student> students = new ArrayList<>();

  Lecture(String name) {
    this.name = name;
  }

  void addStudent(Student student) {
    this.students.add(student);
    student.lectures.add(this);
  }

  public String toString() {
    return name;
  }
}
