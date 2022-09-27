import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePerson {
  public static void main(String[] args) throws SQLException {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Id: ");
    int inputId = scanner.nextInt();

    scanner.close();

    Connection connection = ConnectionFactory.getConnection();
    String sql = "DELETE FROM people WHERE id = ?";

    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1, inputId);

    int count = preparedStatement.executeUpdate();

    if (count > 0) {
      System.out.println("Success!");
    } else {
      System.out.println("Failed!");
    }

    System.out.println("Lines affected: " + count);

    connection.close();
  }
}
