package main.onetoone;

import infra.DAO;
import model.onetoone.Costumer;
import model.onetoone.Seat;

public class NewCostumerSeat {
  public static void main(String[] args) {

    Seat seat = new Seat("16A");
    Costumer costumer = new Costumer("Carlos", seat);

    DAO<Object> dao = new DAO<>();

    dao.openTransaction()
        .persistEntity(seat)
        .persistEntity(costumer)
        .closeTransaction()
        .close();
  }
}
