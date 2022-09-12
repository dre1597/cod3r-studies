import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reduce2 {

  public static void main(String[] args) {
    Student s1 = new Student("name1", 7.1);
    Student s2 = new Student("name2", 6.0);
    Student s3 = new Student("name3", 8.2);
    Student s4 = new Student("name4", 4.0);

    List<Student> students = Arrays.asList(s1, s2, s3, s4);

    Predicate<Student> approved = a -> a.degree >= 7;
    Function<Student, Double> onlyDegree = a -> a.degree;
    BinaryOperator<Double> sum = Double::sum;

    students.parallelStream()
        .filter(approved)
        .map(onlyDegree)
        .reduce(sum)
        .ifPresent(System.out::println);

  }

}
