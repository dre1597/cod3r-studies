public class Product {
  String name;
  int quantity;
  double price;

  Product(String name, double price) {
    this.name = name;
    this.price = price;
    this.quantity = 1;
  }

  Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }
}
