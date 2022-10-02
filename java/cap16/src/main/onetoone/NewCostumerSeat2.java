package main.onetoone;

import infra.DAO;
import model.onetoone.Costumer;
import model.onetoone.Seat;

public class NewCostumerSeat2 {
  public static void main(String[] args) {

    Seat seat = new Seat("4D");
    Costumer costumer = new Costumer("Maria", seat);

    DAO<Costumer> dao = new DAO<>(Costumer.class);
    dao.atomicPersist(costumer);
  }
}
