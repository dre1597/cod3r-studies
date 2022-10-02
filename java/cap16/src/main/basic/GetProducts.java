package main.basic;

import infra.ProductDAO;
import model.basic.Product;

import java.util.List;

public class GetProducts {
  public static void main(String[] args) {
    ProductDAO dao = new ProductDAO();
    List<Product> products = dao.findAll();

    products.forEach(System.out::println);

    double totalPrice = products.stream().map(Product::getPrice).reduce(0.0, Double::sum);

    System.out.println("Total price: " + totalPrice);
  }
}
