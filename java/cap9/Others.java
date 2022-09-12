import java.util.Arrays;
import java.util.List;

public class Others {
  public static void main(String[] args) {
    Student s1 = new Student("name1", 7.5);
    Student s2 = new Student("name2", 6.4);
    Student s3 = new Student("name3", 8.8);
    Student s4 = new Student("name4", 4.4);
    Student s5 = new Student("name1", 7.5);
    Student s6 = new Student("name2", 6.4);
    Student s7 = new Student("name3", 8.8);
    Student s8 = new Student("name4", 4.4);

    List<Student> students = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8);

    System.out.println("Distinct: \n");
    students.stream().distinct().forEach(System.out::println);

    System.out.println("\nSkip - Limit: \n");
    students.stream().distinct().skip(2).limit(2).forEach(System.out::println);

    System.out.println("\nTakeWhile: \n");
    students.stream().distinct().takeWhile(a -> a.degree >= 7).forEach(System.out::println);
  }
}
