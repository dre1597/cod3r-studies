import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertNewPerson {
  public static void main(String[] args) throws SQLException {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Name: ");
    String name = scanner.nextLine();
    scanner.close();

    Connection connection = ConnectionFactory.getConnection();

    String sql = "INSERT INTO people (name) VALUES (?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, name);

    preparedStatement.execute();

    System.out.println("A person was included");
  }
}
