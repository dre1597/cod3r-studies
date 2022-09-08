public class Product {
  private static final double discount = 0.25;
  String name;
  double price;

  Product() {
  }

  Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  double getPriceWithDiscount() {
    return this.price * (1 - Product.discount);
  }

  double getPriceWithDiscount(double extraDiscount) {
    return this.price * (1 - (Product.discount + extraDiscount));
  }
}
