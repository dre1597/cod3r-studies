public class Person {
  String name;
  double weight;

  Person(String name, double weight) {
    this.name = name;
    this.weight = weight > 0 ? weight : 50;
  }

  void eat(Food food) {
    if (food != null) {
      this.weight += food.weight;
    }
  }
}
