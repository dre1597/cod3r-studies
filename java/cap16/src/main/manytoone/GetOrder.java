package main.manytoone;

import infra.DAO;
import model.manytoone.Item;
import model.manytoone.Order;

public class GetOrder {
  public static void main(String[] args) {

    DAO<Order> dao = new DAO<>(Order.class);

    Order order = dao.findByID(1L);

    for (Item item : order.getItems()) {
      System.out.println(item.getQuantity());
      System.out.println(item.getProduct().getName());
    }

    dao.close();
  }
}
