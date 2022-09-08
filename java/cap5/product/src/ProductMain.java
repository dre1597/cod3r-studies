public class ProductMain {
  public static void main(String[] args) {
    Product product1 = new Product();
    product1.name = "Product1";
    product1.price = 10.0;

    System.out.println(product1.getPriceWithDiscount());
    System.out.println(product1.getPriceWithDiscount(0.25));

    Product product2 = new Product("Product2", 20.0);

    System.out.println(product2.getPriceWithDiscount());
    System.out.println(product2.getPriceWithDiscount(0.10));
  }
}
