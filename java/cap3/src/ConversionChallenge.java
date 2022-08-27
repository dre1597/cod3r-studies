import java.util.Scanner;

public class ConversionChallenge {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("First salary: ");
    String value1 = scanner.next().replace(",", ".");
    double salary1 = Double.parseDouble(value1);

    System.out.print("Second salary: ");
    String value2 = scanner.next().replace(",", ".");
    double salary2 = Double.parseDouble(value2);

    System.out.print("Third salary: ");
    String value3 = scanner.next().replace(",", ".");
    double salary3 = Double.parseDouble(value3);

    scanner.close();

    double sum = salary1 + salary2 + salary3;
    double average = sum / 3;
    System.out.println("Average: " + average);
  }
}
