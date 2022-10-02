package main.basic;

import infra.DAO;
import model.basic.Product;

public class NewProduct {
  public static void main(String[] args) {
    Product product = new Product("Product2", 4.00);

    DAO<Product> dao = new DAO<>(Product.class);
    dao.openTransaction().persistEntity(product).closeTransaction().close();
  }
}
