import java.util.ArrayList;

public class ShoppingCart {
  private final String username;
  private final ArrayList<Product> products = new ArrayList<>();

  ShoppingCart(String username) {
    this.username = username;
  }

  Product[] getProducts() {
    return this.products.toArray(new Product[0]);
  }

  void addProduct(String name, double price) {
    products.add(new Product(name, price));
  }

  void addProduct(String name, double price, int quantity) {
    products.add(new Product(name, price, quantity));
  }

  String getUsername() {
    return this.username;
  }

  double getTotal() {
    double total = 0;

    for (Product product : products) {
      total += product.price * product.quantity;
    }

    return total;
  }
}
