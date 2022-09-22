package observer;

public class Girlfriend implements BirthdayPersonArrivalObserver{
  @Override
  public void arrives(BirthdayPersonArrivalEvent event) {
    System.out.println("Notify guests");
    System.out.println("Turn off the lights");
    System.out.println("Wait");
    System.out.println("Surprise!");
  }
}
