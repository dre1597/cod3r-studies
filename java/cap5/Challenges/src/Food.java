public class Food {
  String name;
  double weight;

  Food(String name, double weight) {
    this.name = name;
    this.weight = weight > 0 ? weight : 0.1;
  }
}
