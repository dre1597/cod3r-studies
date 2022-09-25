import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
  public static void main(String[] args) throws SQLException {
    final String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
    final String user = "root";
    final String password = "";

    Connection connection = DriverManager.getConnection(url, user, password);

    Statement statement = connection.createStatement();

    statement.execute("CREATE DATABASE IF NOT EXISTS java_db");

    System.out.println("Database was created");

    connection.close();
  }
}
