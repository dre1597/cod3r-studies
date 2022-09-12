import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reduce3 {
  public static void main(String[] args) {
    Student s1 = new Student("name1", 7.2);
    Student s2 = new Student("name2", 6.1);
    Student s3 = new Student("name3", 8.5);
    Student s4 = new Student("name4", 4.1);

    List<Student> students = Arrays.asList(s1, s2, s3, s4);

    Predicate<Student> approved = a -> a.degree >= 7;
    Function<Student, Double> onlyDegree = a -> a.degree;

    BiFunction<Average, Double, Average> calcAverage = Average::add;
    BinaryOperator<Average> combineAvg = Average::combine;

    Average avg = students.parallelStream()
        .filter(approved)
        .map(onlyDegree)
        .reduce(new Average(), calcAverage, combineAvg);

    System.out.println("The average degree of the approved students is " + avg.getValue());
  }
}
