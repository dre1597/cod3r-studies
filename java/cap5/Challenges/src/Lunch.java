public class Lunch {
  public static void main(String[] args) {
    Person person1 = new Person("name1", 50.0);
    Food food1 = new Food("food1", 3.0);
    Food food2 = new Food("food2", -1.0);

    person1.eat(food1);
    person1.eat(food2);

    System.out.println(person1.weight);
  }
}
