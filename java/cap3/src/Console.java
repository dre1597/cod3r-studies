import java.util.Scanner;

public class Console {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // if the age was before the name i need a scanner.nextLine(); to take the \n from the enter key

    System.out.print("Name: ");
    String name = scanner.nextLine();

    System.out.print("Age: ");
    int age = scanner.nextInt();

    scanner.close();

    System.out.println("Your name: " + name);
    System.out.println("Your age: " + age);
  }
}