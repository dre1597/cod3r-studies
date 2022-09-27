public class DAOMain {
  public static void main(String[] args) {

    DAO dao = new DAO();

    String sql = "INSERT INTO people (name, int) VALUES (?, ?)";
    System.out.println(dao.store(sql, "João da Silva", 1000));
    System.out.println(dao.store(sql, "Ana Julia", 1001));
    System.out.println(dao.store(sql, "Djalma Pereira", 1002));

    dao.close();
  }
}
