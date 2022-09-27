import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class DAO {
  private Connection connection;

  public int store(String sql, Object... attributes) {
    try {
      PreparedStatement preparedStatement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
      addAttributes(preparedStatement, attributes);

      if (preparedStatement.executeUpdate() > 0) {
        ResultSet result = preparedStatement.getGeneratedKeys();

        if (result.next()) {
          return result.getInt(1);
        }
      }

      return -1;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void close() {
    try {
      getConnection().close();
    } catch (SQLException e) {
      System.out.println(Arrays.toString(e.getStackTrace()));
    } finally {
      connection = null;
    }
  }

  private void addAttributes(PreparedStatement preparedStatement, Object[] attributes) throws SQLException {

    int index = 1;
    for (Object attribute : attributes) {
      if (attribute instanceof String) {
        preparedStatement.setString(index, (String) attribute);
      } else if (attribute instanceof Integer) {
        preparedStatement.setInt(index, (Integer) attribute);
      }

      index++;
    }
  }

  private Connection getConnection() {
    try {
      if (connection != null && !connection.isClosed()) {
        return connection;
      }
    } catch (SQLException e) {
      System.out.println(Arrays.toString(e.getStackTrace()));
    }

    connection = ConnectionFactory.getConnection();
    return connection;
  }
}
