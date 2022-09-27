import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueryPerson2 {
  public static void main(String[] args) throws SQLException {
    Scanner scanner = new Scanner(System.in);

    Connection connection = ConnectionFactory.getConnection();

    String sql = "SELECT * FROM people WHERE name like ?";

    System.out.println("Name: ");
    String inputName = scanner.nextLine();

    scanner.close();

    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, "%" + inputName + "%");
    ResultSet resultSet = preparedStatement.executeQuery();

    List<Person> people = new ArrayList<>();

    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      people.add(new Person(id, name));
    }

    for (Person person : people) {
      System.out.println(person.getId() + " -> " + person.getName());
    }

    preparedStatement.close();
    connection.close();
  }
}
