import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Match {
  public static void main(String[] args) {
    Student s1 = new Student("name1", 7.3);
    Student s2 = new Student("name2", 6.2);
    Student s3 = new Student("name3", 8.6);
    Student s4 = new Student("name4", 4.2);

    List<Student> students = Arrays.asList(s1, s2, s3, s4);

    Predicate<Student> approved = a -> a.degree >= 7;
    Predicate<Student> reproved = approved.negate();

    System.out.println(students.stream().allMatch(approved));
    System.out.println(students.stream().anyMatch(approved));
    System.out.println(students.stream().noneMatch(approved));

    System.out.println();

    System.out.println(students.stream().allMatch(reproved));
    System.out.println(students.stream().anyMatch(reproved));
    System.out.println(students.stream().noneMatch(reproved));
  }
}
