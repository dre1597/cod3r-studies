import java.util.Arrays;

public class ShoppingCartMain {
  public static void main(String[] args) {
    ShoppingCart s1 = new ShoppingCart("user1");

    s1.addProduct("product1", 10);
    s1.addProduct("product2", 15, 2);
    s1.addProduct("product3", 3);
    s1.addProduct("product4", 7, 3);

    System.out.println(Arrays.toString(s1.getProducts()));
    System.out.println(s1.getUsername());
    System.out.println(s1.getTotal());
  }

}
