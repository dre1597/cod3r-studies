import javax.swing.*;

public class StringToNumberConversion {
  public static void main(String[] args) {
    String value1 = JOptionPane.showInputDialog("Type the first number: ");
    String value2 = JOptionPane.showInputDialog("Type the second number: ");

    System.out.println(value1 + value2);

    double number1 = Double.parseDouble(value1);
    double number2 = Double.parseDouble(value2);
    double sum = number1 + number2;
    double average = sum / 2;

    System.out.println("Sum: " + sum);
    System.out.println("Sum: " + average);
  }
}
