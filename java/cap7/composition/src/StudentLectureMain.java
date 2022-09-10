public class StudentLectureMain {
  public static void main(String[] args) {
    Student student1 = new Student("student1");
    Student student2 = new Student("student2");
    Student student3 = new Student("student3");

    Lecture lecture1 = new Lecture("lecture1");
    Lecture lecture2 = new Lecture("lecture2");
    Lecture lecture3 = new Lecture("lecture3");

    lecture1.addStudent(student1);
    lecture1.addStudent(student2);
    lecture2.addStudent(student3);

    student3.addLecture(lecture3);

    for (Student student : lecture1.students) {
      System.out.println(lecture1);
      System.out.println(student);
      System.out.println();
    }
  }
}
