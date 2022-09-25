import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  public static Connection getConnection() throws RuntimeException {
    try {
      final String url = "jdbc:mysql://localhost:3306/java_db?verifyServerCertificate=false&useSSL=true";
      final String user = "root";
      final String password = "";

      return DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
