// access variable "a" inside the main method

public class StaticChallenge {
  static int b = 4;
  int a = 3;

  public static void main(String[] args) {
    StaticChallenge staticChallenge = new StaticChallenge();

    System.out.println(staticChallenge.a);
    System.out.println(b);
  }
}
