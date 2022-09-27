import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePerson {
  public static void main(String[] args) throws SQLException {

    Scanner scanner = new Scanner(System.in);


    System.out.println("Id: ");
    int inputId = scanner.nextInt();


    String selectSQL = "SELECT id, name FROM people WHERE id = ?";
    String updateSQL = "UPDATE people SET name = ? WHERE id = ?";

    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

    preparedStatement.setInt(1, inputId);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      Person person = new Person(resultSet.getInt(1), resultSet.getString(2));

      System.out.println("Current name " + person.getName());
      scanner.nextLine();

      System.out.print("New name: ");
      String newNameInput = scanner.nextLine();

      preparedStatement.close();

      preparedStatement = connection.prepareStatement(updateSQL);
      preparedStatement.setString(1, newNameInput);
      preparedStatement.setInt(2, inputId);
      preparedStatement.execute();

      System.out.println("Person was updated successfully!");
    } else {
      System.out.println("Person not found!");
    }

    scanner.close();
    connection.close();
  }
}
