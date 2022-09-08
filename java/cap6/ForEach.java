import java.util.Arrays;

public class ForEach {
  public static void main(String[] args) {
    double[] grades = {9.9, 5.4, 4.0, 10.0};

    for (double grade : grades) {
      System.out.print(grade + " ");
    }

    System.out.println();

    System.out.println(Arrays.toString(grades));
  }
}
