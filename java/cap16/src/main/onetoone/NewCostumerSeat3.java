package main.onetoone;

import infra.DAO;
import model.onetoone.Costumer;
import model.onetoone.Seat;

public class NewCostumerSeat3 {
  public static void main(String[] args) {

    DAO<Costumer> costumerDAO = new DAO<>(Costumer.class);

    Costumer costumer = costumerDAO.findByID(1L);
    System.out.println(costumer.getSeat().getName());

    costumerDAO.close();


    DAO<Seat> seatDAO = new DAO<>(Seat.class);

    Seat seat = seatDAO.findByID(2L);
    System.out.println(seat.getCostumer().getName());

    seatDAO.close();
  }
}
