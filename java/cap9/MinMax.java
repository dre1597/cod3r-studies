import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMax {
  public static void main(String[] args) {
    Student s1 = new Student("name1", 7.4);
    Student s2 = new Student("name2", 6.3);
    Student s3 = new Student("name3", 8.7);
    Student s4 = new Student("name4", 4.3);

    List<Student> students = Arrays.asList(s1, s2, s3, s4);

    Comparator<Student> bestDegree = Comparator.comparingDouble(cs -> cs.degree);

    System.out.println(students.stream().max(bestDegree).get());
    System.out.println(students.stream().min(bestDegree).get());
  }
}
