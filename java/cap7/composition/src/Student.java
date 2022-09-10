import java.util.ArrayList;

public class Student {
  final String name;
  final ArrayList<Lecture> lectures = new ArrayList<>();

  Student(String name) {
    this.name = name;
  }

  void addLecture(Lecture lecture) {
    this.lectures.add(lecture);
    lecture.students.add(this);
  }

  public String toString() {
    return name;
  }
}
