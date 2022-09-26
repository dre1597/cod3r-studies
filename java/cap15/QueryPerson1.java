import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryPerson1 {

  public static void main(String[] args) throws SQLException {
    Connection connection = ConnectionFactory.getConnection();

    String sql = "SELECT * FROM people";

    Statement statement = connection.createStatement();

    ResultSet resultSet = statement.executeQuery(sql);

    List<Person> people = new ArrayList<>();

    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      people.add(new Person(id, name));
    }

    for (Person person : people) {
      System.out.println(person.getId() + " -> " + person.getName());
    }

    statement.close();
    connection.close();
  }
}
