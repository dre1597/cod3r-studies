import java.util.Objects;

public class Student {
  final String name;
  final double degree;

  public Student(String name, double degree) {
    this.name = name;
    this.degree = degree;
  }

  @Override
  public String toString() {
    return "name: " + name + " degree: " + degree;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Student student = (Student) o;

    if (Double.compare(student.degree, degree) != 0) return false;
    return Objects.equals(name, student.name);
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = name != null ? name.hashCode() : 0;
    temp = Double.doubleToLongBits(degree);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}
