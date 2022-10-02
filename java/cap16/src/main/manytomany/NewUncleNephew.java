package main.manytomany;

import infra.DAO;
import model.manytomany.Nephew;
import model.manytomany.Uncle;

public class NewUncleNephew {
  public static void main(String[] args) {

    Uncle aunt = new Uncle("Maria");
    Uncle uncle = new Uncle("João");

    Nephew nephew = new Nephew("Davi");
    Nephew niece = new Nephew("Ana");

    aunt.getNephews().add(nephew);
    nephew.getUncles().add(aunt);

    aunt.getNephews().add(niece);
    niece.getUncles().add(aunt);

    uncle.getNephews().add(nephew);
    nephew.getUncles().add(uncle);

    uncle.getNephews().add(niece);
    niece.getUncles().add(uncle);

    DAO<Object> dao = new DAO<>();
    dao.openTransaction()
        .persistEntity(aunt)
        .persistEntity(uncle)
        .persistEntity(nephew)
        .persistEntity(niece)
        .closeTransaction()
        .close();
  }
}
