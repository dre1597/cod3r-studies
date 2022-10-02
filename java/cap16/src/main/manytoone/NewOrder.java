package main.manytoone;

import infra.DAO;
import model.basic.Product;
import model.manytoone.Item;
import model.manytoone.Order;

public class NewOrder {
  public static void main(String[] args) {

    DAO<Object> dao = new DAO<>();

    Order order = new Order();
    Product product = new Product("Product3", 2789.99);
    Item item = new Item(order, product, 10);

    dao.openTransaction()
        .persistEntity(product)
        .persistEntity(order)
        .persistEntity(item)
        .closeTransaction()
        .close();
  }
}
